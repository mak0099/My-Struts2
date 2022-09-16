<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="DeleteConfirmation.Title"/></title>
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
		<h1><s:text name="DeleteConfirmation.Heading" /></h1>
		<s:form action="confirmDelete">
		<table border="1">
				<thead>
					<tr>
						<th><s:text name="DeleteConfirmation.Field"/></th>
						<th><s:text name="DeleteConfirmation.Value"/></th>
					</tr>
				</thead>
				<tbody>
					<s:textfield name="id" label="%{getText('Edit.ID')}" errorPosition="bottom" readonly="true"/>
					<s:textfield name="name" value="%{user.name}" label="%{getText('Edit.Name')}" errorPosition="bottom" readonly="true"/>
					<s:textfield name="nameKatakana" value="%{user.nameKatakana}" label="%{getText('Edit.NameKatakana')}" errorPosition="bottom" readonly="true"/>
					<s:textfield name="dateOfBirth" value="%{user.dateOfBirthformat('yyyy-MM-dd')}" label="%{getText('Edit.DateOfBirth')}" errorPosition="bottom" readonly="true" />
					<s:textfield name="club" value="%{user.club}" label="%{getText('Edit.Club')}" errorPosition="bottom" readonly="true" />					
				</tbody>
			</table>
			<div style="padding:15px">
				<s:textfield type="button" value="%{getText('DeleteConfirmation.ButtonBack')}" theme="simple" onclick="history.back()" />
				<s:submit value="%{getText('DeleteConfirmation.ButtonSubmit')}" onclick="return confirm('%{getText('MSI001')}')" theme="simple" />
			</div>
		</s:form>
	</center>
</body>
</html>