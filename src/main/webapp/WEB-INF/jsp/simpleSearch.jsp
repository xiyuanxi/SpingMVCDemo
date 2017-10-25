<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
<div class="content">
<br>
<form id="search-form" action="${actionName}" method="get">
	<table>
		<tr>
			<td><label>Search ${function}:</label> 
				<input type="text" name="${paraName}" value="" maxlength="12"  />&nbsp;&nbsp;&nbsp;&nbsp;  <p class="error">${errMessage}</p>
			</td>
		</tr>
		<tr>
			<td>
				<button type="submit" id="btn-search">Search</button>
			</td>
		<tr>
	</table>
</form >
<br>
</div>
</div>