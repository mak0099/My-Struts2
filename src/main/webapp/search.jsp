<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="Search.Title"/></title>
<style>

.actionMessage{
	list-style: none;
	color: green;
}
.errorMessage{
	list-style: none;
	color: red;
}
</style>
</head>
<body>
	<center>
		<h1><s:text name="Search.Heading"/></h1>
		<s:if test="hasActionMessages()">
		     <s:actionmessage/>
		</s:if>
		<s:if test="hasActionErrors()">
		     <s:actionerror/>
		</s:if>
		<a href="login.jsp">Login</a>
		<a href="registration.jsp">New Registration</a>
		<a href="edit.jsp">Edit</a>
		<a href="delete-confirmation.jsp">Delete Confirmation</a>
	</center>
</body>
</html>