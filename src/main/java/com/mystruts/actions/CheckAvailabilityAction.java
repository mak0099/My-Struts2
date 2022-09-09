package com.mystruts.actions;

import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CheckAvailabilityAction extends ActionSupport {
	public void validate() {
		if (getId().length() == 0) {
			addFieldError("id", getText("MSE001"));
		}
		// check already exist ID

		else
			try {
				if (getId().getBytes("MS932").length > getId().length()) {
					addFieldError("id", getText("MSE008"));
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public String execute() {
		setIdAvailability(true);
		System.out.println("Checking for ID is: " + id);
		return "success";
	}
	
	private String id;
	private boolean idAvailability;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isIdAvailability() {
		return idAvailability;
	}
	public void setIdAvailability(boolean idAvailability) {
		this.idAvailability = idAvailability;
	}
	
}
