package com.eventorganiser.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

import com.eventorganiser.domain.constant.UserLoginDetails;
import com.eventorganiser.repository.UserLoginRepository;
import com.eventorganiser.service.ILoginService;

public class LoginService implements ILoginService{

	private UserLoginRepository userLoginRepository;
	
	private ResponseEntity<HttpStatus> response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	
	@Override
	public ResponseEntity<HttpStatus> saveUserLoginDetails(UserLoginDetails userLoginDetailsObject) {
		if(ObjectUtils.isEmpty(userLoginDetailsObject)) {
			response = new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		} else {
			userLoginRepository.save(userLoginDetailsObject);
			response = new ResponseEntity<>(HttpStatus.CREATED);
		}
		return response;
	}

	@Override
	public ResponseEntity<HttpStatus> canUserLogin(UserLoginDetails userLoginDetailsObject) {
		if(ObjectUtils.isEmpty(userLoginDetailsObject.getEmailId())
				&& ObjectUtils.isEmpty(userLoginDetailsObject.getPassword())) {
			response = new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		} else {
			UserLoginDetails userLoginDetails = userLoginRepository.findUserByEmailId(userLoginDetailsObject.getEmailId());
			if(ObjectUtils.isEmpty(userLoginDetails)) {
				response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			} else {
				response = new ResponseEntity<>(HttpStatus.OK);
			}
		}
		return response;
	}
	
}
