package com.eventorganiser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eventorganiser.domain.constant.UserLoginDetails;
import com.eventorganiser.service.ILoginService;

@RestController
@RequestMapping(value="/user")
public class LoginController {

	@Autowired
	private ILoginService loginService;
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	@CrossOrigin
    public ResponseEntity<HttpStatus> canUserLogin(@RequestBody UserLoginDetails userLoginDetailsObject) {
		return loginService.canUserLogin(userLoginDetailsObject);
    }
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	@CrossOrigin
    public ResponseEntity<HttpStatus> saveUserLoginDetails(@RequestBody UserLoginDetails userLoginDetailsObject) {
		return loginService.saveUserLoginDetails(userLoginDetailsObject);
    }
}
