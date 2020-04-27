package com.cg.trms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trainee_table")
public class TraineeEntity {
	
	@Id
	@Column(name="traineeid")
	private long traineeId;
	
	@Column(name="trainee_name",nullable=false)
	private String traineeName;
	
	@Column(name="trainee_domain",nullable=false)
	private String traineeDomain;
	
	@Column(name="location",nullable=false)
	private String traineeLocation;
	
	
	public long getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(long traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeDomain() {
		return traineeDomain;
	}
	public void setTraineeDomain(String traineeDomain) {
		this.traineeDomain = traineeDomain;
	}
	public String getTraineeLocation() {
		return traineeLocation;
	}
	public void setTraineeLocation(String traineeLocation) {
		this.traineeLocation = traineeLocation;
	}
	
	
	
}
