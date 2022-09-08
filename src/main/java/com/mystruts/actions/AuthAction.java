package com.mystruts.actions;

import com.opensymphony.xwork2.ActionSupport;

public class AuthAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public void validate(){
		addFieldError("id", "ID is required.");
		addFieldError("firstName", "First name is required.");
//	    if (getFirstName().length() == 0) {
//	    }
	}
	public String execute() {
		System.out.println("Value of firstname is: " + firstName);
		return "success";
	}
	
//	public String register() {
//		System.out.println("Register Value of firstname is: " + firstName);
//		addFieldError("firstName", "First name is required.");
//		return "input";
//	}
	private String firstName;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
