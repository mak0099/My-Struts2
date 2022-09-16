package com.mystruts.actions;

import java.util.Date;

import com.mystruts.models.User;
import com.mystruts.services.AppService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateAction extends ActionSupport {
	public void validate() {
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
	public String execute() {
		return "success";
	}

	public String confirmEdit() {
		try {
			User user = User.find(id);
			user.setName(name);
			user.setNameKatakana(nameKatakana);
			user.setDateOfBirth(dateOfBirth);
			user.setClub(club);
			user.update();
			addActionMessage(getText("MSI008"));
		} catch (Exception e) {
			addActionError(getText("MSE020"));
		}
		return "success";
	}

	private String id;
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
