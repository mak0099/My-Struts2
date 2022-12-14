package com.mystruts.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.action.SessionAware;

import com.mystruts.models.User;
import com.mystruts.services.AppService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchAction extends ActionSupport implements SessionAware {
	public void validate() {
		this.m.put("id", getId());
		this.m.put("name", getName());
		this.m.put("kana", getKana());
//		If nothing is entered in any text box
		if ((getId() != null && getId().length() == 0 && getName() != null && getName().length() == 0 && getKana() != null && getKana().length() == 0) && !getRedirect()) {
			addActionError(getText("MSE015"));
		}
//		If the user ID is not half-width alphanumeric characters
		if (getId() != null && (!AppService.checkHalfWidthCaracter(getId()) || AppService.checkContainSymbol(getId()))) {
			addActionError(getText("MSE002"));
		}
//		If the name is not full-width
		if (getName() != null && getName().length() > 0 && AppService.checkHalfWidthCaracter(getName())) {
			addActionError(getText("MSE010"));
		}
//		If Kana is not half-width
		if (getKana() != null && !AppService.checkHalfWidthCaracter(getKana())) {
			addActionError(getText("MSE013"));
		}
	}
	public String execute() {
		setUserList(User.search(getId(), getName(), getKana()));
		return "success";
	}

	private String id;
	private String name;
	private String kana;
	private Boolean redirect=false;
	private ArrayList<User> userList;
	private Map<String, Object> m;

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

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}
	public ArrayList<User> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	@Override
	public void withSession(Map<String, Object> m) {
		this.m = m;
	}
	public Boolean getRedirect() {
		return redirect;
	}
	public void setRedirect(Boolean redirect) {
		this.redirect = redirect;
	}
}
