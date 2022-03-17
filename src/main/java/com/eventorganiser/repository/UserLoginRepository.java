package com.eventorganiser.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eventorganiser.domain.constant.UserLoginDetails;

@Repository
public interface UserLoginRepository extends CrudRepository<UserLoginDetails, Long> {

	@Query(nativeQuery = true, value = "UserLoginDetails.findUserByEmailId")
	UserLoginDetails findUserByEmailId(@Param("emailId") String emailId);
	
}
