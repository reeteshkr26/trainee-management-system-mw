package com.cg.trms.service;

import java.util.List;

import com.cg.trms.exception.TraineeException;
import com.cg.trms.model.TraineeModel;


public interface TraineeService {
	
	public TraineeModel addTrainee(TraineeModel trainee) throws TraineeException;
	public TraineeModel updateTrainee(TraineeModel trainee) throws TraineeException;
	public List<TraineeModel> findAll();
	public TraineeModel findById(long id);
	public void deleteById(long id);
	
	
	
	

}
