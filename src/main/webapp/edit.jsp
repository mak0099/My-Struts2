<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="Edit.Title"/></title>
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
		<h1><s:text name="Edit.Heading" /></h1>
		<s:form action="submit-edit" method="get">
			<s:textfield name="id" label="%{getText('Edit.ID')}" errorPosition="bottom" readonly="true"/>
			<s:textfield name="name" value="%{user.name}" label="%{getText('Edit.Name')}" errorPosition="bottom"/>
			<s:textfield name="kana" value="%{user.kana}" label="%{getText('Edit.Kana')}" errorPosition="bottom"/>
			<s:textfield type="date" name="dateOfBirth" value="%{user.dateOfBirthformat('yyyy-MM-dd')}" label="%{getText('Edit.DateOfBirth')}" errorPosition="bottom" />
			<s:textfield name="club" value="%{user.club}" label="%{getText('Edit.Club')}" errorPosition="bottom" />
			<tr>
			    <td colspan="2" style="text-align:right; padding-top:5px">
					<s:submit property="submit" value="%{getText('Edit.ButtonSubmit')}" theme="simple" />
					<s:textfield type="button" value="%{getText('Edit.ButtonBack')}" theme="simple"  onclick="window.location='back-to-search.action'" />
			    </td>
			</tr> 
		</s:form>
	</center>
</body>
</html>