package com.mystruts.actions;

import java.util.ArrayList;

import com.mystruts.models.User;
import com.mystruts.services.AppService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchAction extends ActionSupport {
	public void validate() {
//		If nothing is entered in any text box
		if (getId() != null && getId().length() == 0 && getName() != null && getName().length() == 0 && getNameKatakana() != null && getNameKatakana().length() == 0) {
			addActionError(getText("MSE015"));
		}
//		If the user ID is not half-width alphanumeric characters
		if (getId() != null && !AppService.checkHalfWidthCaracter(getId())) {
			addActionError(getText("MSE002"));
		}
//		If the name is not full-width
		if (getName() != null && getName().length() > 0 && AppService.checkHalfWidthCaracter(getName())) {
			addActionError(getText("MSE010"));
		}
//		If Kana is not half-width
		if (getNameKatakana() != null && !AppService.checkHalfWidthCaracter(getNameKatakana())) {
			addActionError(getText("MSE013"));
		}
	}
	public String execute() {
		setUserList(User.search(getId(), getName(), getNameKatakana()));
		return "success";
	}

	private String id;
	private String name;
	private String nameKatakana;
	private ArrayList<User> userList;

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
	public ArrayList<User> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
}
