package com.cg.trms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.trms.entity.TraineeEntity;
import com.cg.trms.exception.TraineeException;
import com.cg.trms.model.TraineeModel;
import com.cg.trms.repo.TraineeRepo;

@Service
public class TraineeServiceImpl implements TraineeService{
	@Autowired
	private TraineeRepo repo;

	private TraineeModel of(TraineeEntity source) {
		TraineeModel result=null;
		if(source!=null) {
			result=new TraineeModel();
			result.setTraineeId(source.getTraineeId());
			result.setTraineeName(source.getTraineeName());
			result.setTraineeDomain(source.getTraineeDomain());
			result.setTraineeLocation(source.getTraineeLocation());
		}
		return result;
	}
	private TraineeEntity of(TraineeModel source) {
		TraineeEntity result=null;
		if(source!=null) {
			result=new TraineeEntity();
			result.setTraineeId(source.getTraineeId());
			result.setTraineeName(source.getTraineeName());
			result.setTraineeDomain(source.getTraineeDomain());
			result.setTraineeLocation(source.getTraineeLocation());
		}
		return result;
	}
	@Override
	public TraineeModel addTrainee(TraineeModel trainee) throws TraineeException {
		if(trainee!=null) {
			if(repo.existsById(trainee.getTraineeId())) {
				throw new TraineeException("There exists a trainee with the given ID");
			}
			else{
				trainee=of(repo.save(of(trainee)));
			}
		}
		return trainee;
	}

	@Override
	public TraineeModel updateTrainee(TraineeModel trainee) throws TraineeException {
		if(trainee!=null) {
			TraineeModel oldTrainee=of(repo.findById(trainee.getTraineeId()).orElse(null));
			if(oldTrainee==null) {
				throw new TraineeException("There does not exists a trainee with the given ID");
			}
			else {
				trainee=of(repo.save(of(trainee)));
			}
		}
		return trainee;
	}

	@Override
	public List<TraineeModel> findAll() {

		return repo.findAll().stream().map(entity->of(entity)).collect(Collectors.toList());
	}

	@Override
	public TraineeModel findById(long id) {

		return of(repo.findById(id).orElse(null));
	}

	@Override
	public void deleteById(long id) {
		repo.deleteById(id);
		
	}

}
