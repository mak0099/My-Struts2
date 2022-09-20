<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="EditConfirmation.Title"/></title>
</head>
<body>
	<center>
		<h1><s:text name="EditConfirmation.Heading"/></h1>
		<s:form action="confirm-edit">
			<table border="1">
				<thead>
					<tr>
						<th><s:text name="EditConfirmation.Field"/></th>
						<th><s:text name="EditConfirmation.Value"/></th>
					</tr>
				</thead>
				<tbody>
					<s:textfield name="id" label="%{getText('EditConfirmation.ID')}" readonly="true" />
					<s:textfield name="name" label="%{getText('EditConfirmation.Name')}" readonly="true" />
					<s:textfield name="kana" label="%{getText('EditConfirmation.Kana')}" readonly="true" />
					<s:textfield name="dateOfBirth" label="%{getText('EditConfirmation.DateOfBirth')}" readonly="true" />
					<s:textfield name="club" label="%{getText('EditConfirmation.Club')}" readonly="true" />
				</tbody>
			</table>
			<div style="padding:15px">
				<s:submit value="%{getText('EditConfirmation.ButtonSubmit')}" onclick="return confirm('%{getText('MSI002')}')" theme="simple" />
				<s:textfield type="button" value="%{getText('EditConfirmation.ButtonBack')}" theme="simple" onclick="history.back()" />
			</div>
		</s:form>
	</center>
</body>
</html>