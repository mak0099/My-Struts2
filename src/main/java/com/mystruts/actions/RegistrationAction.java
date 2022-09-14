package com.mystruts.actions;

import java.util.Date;

import com.mystruts.models.User;
import com.mystruts.services.AppService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RegistrationAction extends ActionSupport {
	public void validateCheckAvailability() {
//		If no user ID is entered
		if (getId().length() == 0) {
			addFieldError("id", getText("MSE001"));
		}
//		If the user ID is not half-width alphanumeric characters
		else if (!AppService.checkHalfWidthCaracter(getId())) {
			addFieldError("id", getText("MSE002"));
		}
//		Duplicate user ID
		else {
			User user = User.find(getId());
			if (user.getId() != null) {
				addFieldError("id", getText("MSE003"));
			}
		}
	}
	public void validateExecute() {
//		If no user ID is entered
		if (getId().length() == 0) {
			addFieldError("id", getText("MSE001"));
		}
//		If the user ID is not half-width alphanumeric characters
		else if (!AppService.checkHalfWidthCaracter(getId())) {
			addFieldError("id", getText("MSE002"));
		}
//		Duplicate user ID
		else {
			User user = User.find(getId());
			if (user.getId() != null) {
				addFieldError("id", getText("MSE003"));
			}
		}
//		No password entered
		if (getPassword().length() == 0) {
			addFieldError("password", getText("MSE005"));
		}
//		If the password is not half-width alphanumeric characters
		else if (!AppService.checkHalfWidthCaracter(getPassword())) {
			addFieldError("password", getText("MSE006"));
		}
//		If password re-entry is not entered
		if (getPasswordConfirmation().length() == 0) {
			addFieldError("passwordConfirmation", getText("MSE005"));
		}
//		If password re-entry is other than half-width alphanumeric characters
		else if (!AppService.checkHalfWidthCaracter(getPasswordConfirmation())) {
			addFieldError("passwordConfirmation", getText("MSE008"));
		}
//		If the re-entered password does not match the entered password
		else if (!getPassword().equals(getPasswordConfirmation())) {
			addFieldError("passwordConfirmation", getText("MSE025"));
		}
//		No name entered
		if (getName().length() == 0) {
			addFieldError("name", getText("MSE009"));
		}
//		If the name is not full-width
		else if (AppService.checkHalfWidthCaracter(getName())) {
			addFieldError("name", getText("MSE010"));
		}
//		If Kana is not entered
		if (getNameKatakana().length() == 0) {
			addFieldError("nameKatakana", getText("MSE012"));
		}
//		If Kana is not half-width
		else if (!AppService.checkHalfWidthCaracter(getNameKatakana())) {
			addFieldError("nameKatakana", getText("MSE013"));
		}
//		If date of birth is not entered
		if (getDateOfBirth() == null) {
			addFieldError("dateOfBirth", getText("MSE016"));
		}
//		If the date of birth is not half-width alphanumeric characters
		else if (!AppService.checkHalfWidthCaracter(getDateOfBirth().toString())) {
			addFieldError("dateOfBirth", getText("MSE017"));
		}
//		If the date of birth is incorrect
		else if (!AppService.checkCorrectDateOfBirth(getDateOfBirth())) {
			addFieldError("dateOfBirth", getText("MSE018"));
		}
//		If the committee is not full-width
		if (getClub().length() > 0 && AppService.checkHalfWidthCaracter(getClub())) {
			addFieldError("club", getText("MSE019"));
		}
	}
	public String checkAvailability() {
		setIdAvailability(true);
		return "success";
	}
	public String execute() {
		return "success";
	}

	public String confirmRegistration() {
		try {
			User user = new User();
			user.setId(id);
			user.setPassword(password);
			user.setName(name);
			user.setNameKatakana(nameKatakana);
			user.setDateOfBirth(dateOfBirth);
			user.setClub(club);
			user.save();
			addActionMessage(getText("MSI007"));
		} catch (Exception e) {
			addActionError(getText("MSE024"));
		}
		return "success";
	}

	private String id;
	private String password;
	private String passwordConfirmation;
	private String name;
	private String nameKatakana;
	private Date dateOfBirth;
	private String club;
	private boolean idAvailability;

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
	public boolean isIdAvailability() {
		return idAvailability;
	}
	public void setIdAvailability(boolean idAvailability) {
		this.idAvailability = idAvailability;
	}
}
