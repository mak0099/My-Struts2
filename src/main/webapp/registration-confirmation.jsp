<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="RegConfirmation.Title"/></title>
</head>
<body>
	<center>
		<h1><s:text name="RegConfirmation.Heading"/></h1>
		<h3><s:text name="MSI006"/></h3>
		<s:form action="confirm-registration">
			<table border="1">
				<thead>
					<tr>
						<th><s:text name="RegConfirmation.Field"/></th>
						<th><s:text name="RegConfirmation.Value"/></th>
					</tr>
				</thead>
				<tbody>
					<s:textfield name="id" label="%{getText('RegConfirmation.ID')}" readonly="true" />
					<s:textfield name="password" label="%{getText('RegConfirmation.Password')}" readonly="true" />
					<s:textfield name="name" label="%{getText('RegConfirmation.Name')}" readonly="true" />
					<s:textfield name="kana" label="%{getText('RegConfirmation.Kana')}" readonly="true" />
					<s:textfield name="dateOfBirth" label="%{getText('RegConfirmation.DateOfBirth')}" readonly="true" />
					<s:textfield name="club" label="%{getText('RegConfirmation.Club')}" readonly="true" />
				</tbody>
			</table>
			<div style="padding:15px">
				<s:submit value="%{getText('RegConfirmation.ButtonSubmit')}" onclick="return confirm('%{getText('MSI003')}')" theme="simple" />
				<s:textfield type="button" value="%{getText('RegConfirmation.ButtonBack')}" theme="simple" onclick="history.back();" />
			</div>
		</s:form>
	</center>
</body>
</html>