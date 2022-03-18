package com.eventorganiser.domain.constant;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_LOGIN_DETAILS", schema="event_project")
@NamedQuery(name = "UserLoginDetails.findUserByEmailId", query = CommonQueryConstant.FIND_USER_BY_EMAIL_ID)
public class UserLoginDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="USER_LOGIN_DETAILS_GENERATOR", sequenceName="event_project.user_login_details_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USER_LOGIN_DETAILS_GENERATOR")
    @Column(name = "user_id")
	private Long userId;
	
    @Column(name = "first_name")
	private String firstName;
	
    @Column(name = "last_Name")
	private String lastName;
	
    @Column(name = "email_Id")
	private String emailId;
	
    @Column(name = "password")
	private String password;
	
    @Column(name = "mobile_num")
	private String mobileNum;
	
    @Column(name = "alternate_mobile_num")
	private String alternateMobileNum;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getAlternateMobileNum() {
		return alternateMobileNum;
	}

	public void setAlternateMobileNum(String alternateMobileNum) {
		this.alternateMobileNum = alternateMobileNum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
