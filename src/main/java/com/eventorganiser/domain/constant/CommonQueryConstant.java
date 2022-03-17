package com.eventorganiser.domain.constant;

public class CommonQueryConstant {

	public static final String FIND_USER_BY_EMAIL_ID = " select * from UserLoginDetails uld"
			+ " where uld.emailId = :emailId";
	
}
