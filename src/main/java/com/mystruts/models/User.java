package com.mystruts.models;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mystruts.models.dao.UserDao;

public class User extends UserDao {
	private String id;
	private String password;
	private String passwordConfirmation;
	private String name;
	private String nameKatakana;
	private Date dateOfBirth;
	private String club;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameKatakana() {
		return nameKatakana;
	}

	public void setNameKatakana(String nameKatakana) {
		this.nameKatakana = nameKatakana;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}
	public User save() {
		insertUser(this);
		return this;
	}
	public User update() {
		updateUser(this);
		return this;
	}
	
	public User delete() {
		deleteUser(this);
		return this;
	}
	public String dateOfBirthformat(String format) {
		DateFormat formatter = new SimpleDateFormat(format);
		String formatedDate = formatter.format(dateOfBirth);
		return formatedDate;
	}
}
