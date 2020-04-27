package com.cg.trms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.trms.exception.TraineeException;
import com.cg.trms.model.TraineeModel;
import com.cg.trms.service.TraineeService;

@RestController
@RequestMapping("/trainees")
@CrossOrigin
public class TraineeController {
	@Autowired
	public TraineeService traineeService;
	
	@PostMapping
	public ResponseEntity<TraineeModel> createTrainee(@RequestBody TraineeModel trainee) throws TraineeException{
		trainee=traineeService.addTrainee(trainee);
		return new ResponseEntity<>(trainee,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<TraineeModel>> getAllTrainees(){
		
		return new ResponseEntity<>(traineeService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id:[0-9]{1,4}}")
	public ResponseEntity<TraineeModel> findById(@PathVariable("id") Long traineeId) {
		ResponseEntity<TraineeModel> response = null;

		TraineeModel trainee = traineeService.findById(traineeId);

		if (trainee == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(trainee, HttpStatus.OK);
		}

		return response;
	}
	
	@PutMapping
	public ResponseEntity<TraineeModel> updateTrainee(@RequestBody TraineeModel trainee) throws TraineeException {
		trainee = traineeService.updateTrainee(trainee);
		return new ResponseEntity<>(trainee, HttpStatus.OK);
	}
	
	@DeleteMapping("/{traineeId}")
	public ResponseEntity<Void> deleteTrainee(@PathVariable("traineeId") long traineeId) {

		ResponseEntity<Void> response = null;

		TraineeModel trainee = traineeService.findById(traineeId);

		if (trainee == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			traineeService.deleteById(traineeId);
			response = new ResponseEntity<>(HttpStatus.OK);
		}

		return response;
	}
}
