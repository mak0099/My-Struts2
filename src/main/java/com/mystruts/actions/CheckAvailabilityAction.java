package com.mystruts.actions;
import com.mystruts.models.User;
import com.mystruts.services.AppService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CheckAvailabilityAction extends ActionSupport {
	public void validate() {
//		If no user ID is entered
		if (getId().length() == 0) {
			addFieldError("id", getText("MSE001"));
		}
//		If the user ID is not half-width alphanumeric characters
		else if (!AppService.checkHalfWidthCaracter(getId())) {
			addFieldError("id", getText("MSE002"));
		}
//		Duplicate user ID
		else {
			User user = User.find(getId());
			if (user.getId() != null) {
				addFieldError("id", getText("MSE003"));
			}
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
