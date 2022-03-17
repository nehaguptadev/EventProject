package com.eventorganiser.service;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.eventorganiser.domain.constant.UserLoginDetails;

public interface ILoginService {
	
	public ResponseEntity<Map<String, String>> canUserLogin(@RequestBody UserLoginDetails userLoginDetailsObject);
	
	public ResponseEntity<HttpStatus> saveUserLoginDetails(UserLoginDetails userLoginDetailsObject);
	
}
