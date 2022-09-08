<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<style>
.tdErrorMessage{
	text-align: right;
	color: red;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h1><s:text name="Register.Heading" /></h1>
		<h1><s:property value="id" /></h1>
		<s:form method="post" action="submitRegistration">
			<s:textfield name="id" label="%{getText('Register.ID')}" errorPosition="bottom"/>
			<s:submit value="%{getText('Register.ButtonCheckAvailability')}" action="checkAvailability" style="float: right; margin: 5px 0" />
			<s:textfield type="password" name="password" label="%{getText('Register.Password')}" errorPosition="bottom"/>
			<s:textfield type="password" name="passwordConfirmation" label="%{getText('Register.ReEnterPassword')}" errorPosition="bottom"/>
			<s:textfield name="name" label="%{getText('Register.Name')}" errorPosition="bottom"/>
			<s:textfield name="nameKatakana" label="Name (Katakana)" errorPosition="bottom"/>
			<s:textfield type="date" name="dateOfBirth" label="%{getText('Register.DateOfBirth')}" errorPosition="bottom" />
			<s:textfield name="committee" label="%{getText('Register.Committee')}" errorPosition="bottom" />
			<tr>
			    <td colspan="2" style="text-align:right; padding-top:5px">
					<s:textfield type="button" property="back" value="%{getText('Register.ButtonBack')}" theme="simple" onclick="window.location = 'search.jsp'" />
					<s:submit property="submit" value="%{getText('Register.ButtonSubmit')}" theme="simple" />
			    </td>
			</tr> 
		</s:form>
		<a href="search.jsp">Search</a>
		<a href="registration-confirmation.jsp">Registration Confirmation</a>
	</center>
</body>
</html>