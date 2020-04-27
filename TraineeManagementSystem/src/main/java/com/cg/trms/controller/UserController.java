package com.cg.trms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.trms.model.UserModel;
import com.cg.trms.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService service;
	@GetMapping("/{uname}/{pass}")
	public ResponseEntity<UserModel> getUser(@PathVariable("uname") String uname,@PathVariable("pass") String pass){
		ResponseEntity<UserModel> result=null;
		UserModel model=service.getUser(uname, pass);
		if(model==null) {
			result=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			result=new ResponseEntity<>(model,HttpStatus.OK);
		}
		return result;
	}
}
