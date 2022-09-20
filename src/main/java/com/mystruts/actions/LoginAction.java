package com.mystruts.actions;
import com.mystruts.models.User;
import com.mystruts.services.AppService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	public void validate() {
//		If no user ID is entered
		if (getId().length() == 0) {
			addFieldError("id", getText("MSE001"));
		}
//		If the user ID is not half-width alphanumeric characters
		else if (!AppService.checkHalfWidthCaracter(getId())) {
			addFieldError("id", getText("MSE002"));
		}
//		No password entered
		if (getPassword().length() == 0) {
			addFieldError("password", getText("MSE005"));
		}
//		If the password is not half-width alphanumeric characters
		else if (!AppService.checkHalfWidthCaracter(getPassword())) {
			addFieldError("password", getText("MSE006"));
		}
	}
	public String execute() {
		User user = User.find(getId());
		if(user.getId() != null) {
			if(user.getPassword().equals(getPassword())) {
				addActionMessage(getText("MSI010"));
				setPassword(null);
				return "success";
			}else {
				addActionError(getText("MSE007"));
			}
		}else {
			addActionError(getText("MSE004"));
		}
		return "input";
	}

	private String id;
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
