package com.mystruts.actions;

import com.mystruts.models.User;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteAction extends ActionSupport {
	private String id;
	private User user;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
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
	public String confirmDelete() {
		try {
			User user = User.find(id);
			user.delete();
			addActionMessage(getText("MSI009"));
		} catch (Exception e) {
			addActionError(getText("MSE021"));
		}
		return "success";
	}
}
