package com.cg.trms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.trms.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity,String>{

	@Query("Select u FROM UserEntity u WHERE u.userName= :uName and u.password=:pass")
	public UserEntity getUser(String uName,String pass);
}
