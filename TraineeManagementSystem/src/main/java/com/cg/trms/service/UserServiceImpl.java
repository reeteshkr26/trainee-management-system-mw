package com.cg.trms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.trms.entity.UserEntity;
import com.cg.trms.model.UserModel;
import com.cg.trms.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo repo;
	
	private UserModel of(UserEntity source) {
		UserModel result=null;
		if(source!=null) {
			result=new UserModel();
			result.setUserName(source.getUserName());
			result.setPassword(source.getPassword());
		}
		return result;
	}
	private UserEntity of(UserModel source) {
		UserEntity result=null;
		if(source!=null) {
			result=new UserEntity();
			result.setUserName(source.getUserName());
			result.setPassword(source.getPassword());
		}
		return result;
	}

	@Override
	public UserModel getUser(String uName, String pass) {
		
		return of(repo.getUser(uName, pass));
	}
	
}
