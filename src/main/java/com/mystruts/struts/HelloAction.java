package com.mystruts.struts;


public class HelloAction {

	public String execute() {
		System.out.println("Value of firstname is: " + firstName);
		return "success";
	}

	private String firstName;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
}
