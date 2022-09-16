package com.mystruts.actions;

import com.mystruts.models.User;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class EditAction extends ActionSupport {

	public String execute() {
		if (getId().length() == 0) {
			return "404";
		}
		User user = User.find(id);
		if (user.getId() == null) {
			return "404";
		}
		setUser(user);
		return "success";
	}

	private String id;
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
}
