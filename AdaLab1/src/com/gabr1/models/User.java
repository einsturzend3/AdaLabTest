package com.gabr1.models;

import java.util.Date;

import com.mobandme.ada.Entity;
import com.mobandme.ada.annotations.Table;
import com.mobandme.ada.annotations.TableField;

@Table(name = "tUser")
public class User extends Entity {
	@TableField(name = "uName", datatype = Entity.DATATYPE_STRING)
	private String userName;
	@TableField(name = "uEmail", datatype = Entity.DATATYPE_STRING, required = true, maxLength = 255)
	private String email;
	@TableField(name = "uPass", datatype = Entity.DATATYPE_STRING)
	private String password;
	@TableField(name = "altaDate", datatype = Entity.DATATYPE_DATE)
	private Date date;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
