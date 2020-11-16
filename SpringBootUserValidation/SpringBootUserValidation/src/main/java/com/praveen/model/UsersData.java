package com.praveen.model;

//import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usersdata")
public class UsersData{
	@Id
	@Column
	int userId;
	@Column
	String userPwd;
	@Column
	
	public int getUSerId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPwd;
	}
	public void setUserPassword(String userPwd) {
		this.userPwd = userPwd;
	}
}