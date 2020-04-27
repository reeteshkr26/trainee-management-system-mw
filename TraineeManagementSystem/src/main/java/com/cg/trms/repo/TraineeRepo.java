package com.cg.trms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.trms.entity.TraineeEntity;

public interface TraineeRepo extends JpaRepository<TraineeEntity,Long>{

}
