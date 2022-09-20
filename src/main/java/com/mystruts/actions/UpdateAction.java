package com.mystruts.actions;

import com.mystruts.models.User;
import com.mystruts.services.AppService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class UpdateAction extends ActionSupport implements ModelDriven<User> {
	public void validate() {
//		No name entered
		if (user.getName().length() == 0) {
			addFieldError("name", getText("MSE009"));
		}
//		If the name is not full-width
		else if (AppService.checkHalfWidthCaracter(user.getName())) {
			addFieldError("name", getText("MSE010"));
		}
//		If Kana is not entered
		if (user.getNameKatakana().length() == 0) {
			addFieldError("nameKatakana", getText("MSE012"));
		}
//		If Kana is not half-width
		else if (!AppService.checkHalfWidthCaracter(user.getNameKatakana())) {
			addFieldError("nameKatakana", getText("MSE013"));
		}
//		If date of birth is not entered
		if (user.getDateOfBirth() == null) {
			addFieldError("dateOfBirth", getText("MSE016"));
		}
//		If the date of birth is not half-width alphanumeric characters
		else if (!AppService.checkHalfWidthCaracter(user.getDateOfBirth().toString())) {
			addFieldError("dateOfBirth", getText("MSE017"));
		}
//		If the date of birth is incorrect
		else if (!AppService.checkCorrectDateOfBirth(user.getDateOfBirth())) {
			addFieldError("dateOfBirth", getText("MSE018"));
		}
//		If the committee is not full-width
		if (user.getClub().length() > 0 && AppService.checkHalfWidthCaracter(user.getClub())) {
			addFieldError("club", getText("MSE019"));
		}
	}
	public String execute() {
		return "success";
	}

	public String confirmEdit() {
		try {
			user.update();
			addActionMessage(getText("MSI008"));
		} catch (Exception e) {
			addActionError(getText("MSE020"));
		}
		return "success";
	}


	private User user = new User();
	private boolean idAvailability;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isIdAvailability() {
		return idAvailability;
	}
	public void setIdAvailability(boolean idAvailability) {
		this.idAvailability = idAvailability;
	}
	@Override
	public User getModel() {
		return user;
	}
}
