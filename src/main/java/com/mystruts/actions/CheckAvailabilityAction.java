package com.mystruts.actions;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CheckAvailabilityAction extends ActionSupport {
	public void validate() {
//		addFieldError("id", getText("MSE003"));
	}
	public String execute() {
		addActionMessage("test message");
		System.out.println("Checking for ID is: " + id);
		return "success";
	}
	
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
