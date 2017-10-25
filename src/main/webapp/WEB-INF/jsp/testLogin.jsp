<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
	<title>登录(Testing for Iova)</title>
  </head>
  <body>
  
	<font color="red">${message}</font>
	<br><br>
	 <form:form id="loginForm" method="post" action="TestLogin" modelAttribute="loginBean">
	 		<input type="hidden" name="CSRFToken" value="${csrf}" />
	 		<input type="hidden" name="upload_packaging" id="upload_packaging" /> 
	 
	 		<table>
	 		<tr><td>
			<form:label path="username">Enter your user-name:</form:label></td>
			<td><form:input id="username" name="username" path="username"/></td>
			</tr><tr><td>
			<form:label path="username">Please enter your password:</form:label></td>
			<td><form:password id="password" name="password" path="password"/></td></tr>
			</table>
			<br><br>
            <input type="submit" value="Submit" />
     </form:form>
	<script language="javascript">
		var league_trust_input_id = "upload_packaging";
	</script>
	<script language="javascript" src="js/leagueCore.js"></script>
</body>
</html>