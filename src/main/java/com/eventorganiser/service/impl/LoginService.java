package com.eventorganiser.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.eventorganiser.domain.constant.UserLoginDetails;
import com.eventorganiser.repository.UserLoginRepository;
import com.eventorganiser.service.ILoginService;

@Service
public class LoginService implements ILoginService{

	@Autowired
	public UserLoginRepository userLoginRepository;
	
	private ResponseEntity<HttpStatus> response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	
	@Override
	public ResponseEntity<HttpStatus> saveUserLoginDetails(UserLoginDetails userLoginDetailsObject) {
		if(ObjectUtils.isEmpty(userLoginDetailsObject)) {
			response = new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		} else {
			UserLoginDetails userLoginDetails = userLoginRepository.findUserByEmailId(userLoginDetailsObject.getEmailId());
			if(ObjectUtils.isEmpty(userLoginDetails)) {
				userLoginRepository.save(userLoginDetailsObject);
				response = new ResponseEntity<>(HttpStatus.CREATED);
			} else {
				response = new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
			}
		}
		return response;
	}

	@Override
	public ResponseEntity<Map<String, String>> canUserLogin(UserLoginDetails userLoginDetailsObject) {
		Map<String, String> loginStatus = new HashMap<>();
		loginStatus.put("status", "FALSE");
		ResponseEntity<Map<String, String>> response = new ResponseEntity<>(loginStatus, HttpStatus.BAD_REQUEST);
		if(ObjectUtils.isEmpty(userLoginDetailsObject.getEmailId())
				&& ObjectUtils.isEmpty(userLoginDetailsObject.getPassword())) {
			loginStatus.put("status", "Pre-requisite details missing");
			response = new ResponseEntity<>(loginStatus, HttpStatus.PRECONDITION_FAILED);
		} else {
			UserLoginDetails userLoginDetails = userLoginRepository.findUserByEmailId(userLoginDetailsObject.getEmailId());
			if(ObjectUtils.isEmpty(userLoginDetails)) {
				loginStatus.put("status", "FALSE");
				loginStatus.put("reason", "Email ID does not exist");
				response = new ResponseEntity<>(loginStatus, HttpStatus.NOT_FOUND);
			} else if(!userLoginDetails.getPassword().equals(userLoginDetailsObject.getPassword())) {
				loginStatus.put("status", "FALSE");
				loginStatus.put("reason", "Invalid Username/Password");
				response = new ResponseEntity<>(loginStatus, HttpStatus.UNAUTHORIZED);
			} else {
				loginStatus.put("status", "TRUE");
				response = new ResponseEntity<>(loginStatus, HttpStatus.OK);
			}
		}
		return response;
	}
	
}
