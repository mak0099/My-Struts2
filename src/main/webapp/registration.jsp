<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="Registration.Title"/></title>
<style>
.tdErrorMessage{
	text-align: right;
	color: red;
	font-style: italic;
}
.tdSuccessMessage{
	text-align: right;
	color: green;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h1><s:text name="Registration.Heading" /></h1>
		<s:form action="submit-registration" method="get">
			<s:textfield name="id" label="%{getText('Registration.ID')}" errorPosition="bottom"/>
			<tr><td colspan="2" class="tdSuccessMessage"><s:if test="idAvailability"><s:text name="MSI004" /></s:if></td></tr>
			<s:submit value="%{getText('Registration.ButtonCheckAvailability')}" action="check-availability" style="float: right; margin: 5px 0" />
			<s:textfield name="password" label="%{getText('Registration.Password')}" errorPosition="bottom"/>
			<s:textfield name="passwordConfirmation" label="%{getText('Registration.ReEnterPassword')}" errorPosition="bottom"/>
			<s:textfield name="name" label="%{getText('Registration.Name')}" errorPosition="bottom"/>
			<s:textfield name="kana" label="%{getText('Registration.Kana')}" errorPosition="bottom"/>
			<s:textfield type="date" name="dateOfBirth" value="%{user.dateOfBirthformat('yyyy-MM-dd')}" label="%{getText('Registration.DateOfBirth')}" errorPosition="bottom" />
			<s:textfield name="club" label="%{getText('Registration.Club')}" errorPosition="bottom" />
			<tr>
			    <td colspan="2" style="text-align:right; padding-top:5px">
					<s:submit property="submit" value="%{getText('Registration.ButtonSubmit')}" theme="simple" />
					<s:textfield type="button" value="%{getText('Registration.ButtonBack')}" theme="simple" onclick="window.location='back-to-search.action'" />
			    </td>
			</tr> 
		</s:form>
	</center>
</body>
</html>