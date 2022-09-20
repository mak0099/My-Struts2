<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="Login.Title"/></title>
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
.errorMessage{
	list-style: none;
	color: red;
}
</style>
</head>
<body>
	<center>
		<h1><s:text name="Login.Heading" /></h1>
		<s:if test="hasActionErrors()">
		     <s:actionerror/>
		</s:if>
		<s:form method="post" action="submit-login">
			<s:textfield name="id" label="%{getText('Login.ID')}" errorPosition="bottom"/>
			<s:textfield type="password" name="password" label="%{getText('Login.Password')}" errorPosition="bottom"/>
			<tr>
			    <td colspan="2" style="text-align:right; padding-top:5px">
					<s:submit property="submit" value="%{getText('Login.ButtonSubmit')}" theme="simple" />
			    </td>
			</tr> 
		</s:form>
	</center>
</body>
</html>