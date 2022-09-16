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
		<s:form action="submitSearch">
			<table border="1" style="border-collapse: collapse">
				<s:textfield name="id" label="%{getText('Search.ID')}" errorPosition="bottom" />
				<s:textfield name="name" label="%{getText('Search.Name')}" errorPosition="bottom" />
				<s:textfield name="nameKatakana" label="%{getText('Search.NameKatakana')}" errorPosition="bottom" />
			</table>
			<div style="margin: 10px auto">
				<button type="submit"><s:text name="Search.ButtonSearch"/></button>
				<button type="button" onclick="window.location='registration.jsp'"><s:text name="Search.ButtonNewRegistration"/></button>
				<button type="button" onclick="window.location='login.jsp'"><s:text name="Search.ButtonLogout"/></button>
			</div>
		</s:form>
		<s:if test="!userList.isEmpty()">
		<table border="1" style="border-collapse: collapse">
			<thead>
				<tr>
					<th><s:text name="Search.ID"/></th>
					<th><s:text name="Search.Name"/></th>
					<th><s:text name="Search.NameKatakana"/></th>
					<th><s:text name="Search.DateOfBirth"/></th>
					<th><s:text name="Search.Club"/></th>
					<th><s:text name="Search.Action"/></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="userList" var="user" > 
				<tr>
					<td><s:property value="id"/></td>
					<td><s:property value="name"/></td>
					<td><s:property value="nameKatakana"/></td>
					<td><s:date name="dateOfBirth" format="yyyy/MM/dd" /></td>
					<td><s:property value="club"/></td>
					<td>
						<form>
							<input name="id" type="hidden" value="<s:property value="id"/>" />
							<button type="submit" formaction="editUser"><s:text name="Search.ButtonEdit"/></button>
							<button type="submit" formaction="deleteUser"><s:text name="Search.ButtonDelete"/></button>
						</form>
					</td>
				</tr>
				</s:iterator>
			</tbody>
		</table>
		</s:if>
	</center>
</body>
</html>