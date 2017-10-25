<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="css/main.css"/>

<div id="social_and_flags">
	<div id="logos">
		
	</div>

</div>

<!-- display login button if not authenticated-->
<%-- <sec:authorize access="isAnonymous()">
  <div id="login-button">
      <a href="<c:url value='/login/custom_login'/>"><spring:message code="user.login"/></a>
  </div>
</sec:authorize> --%>

<div id="username_and_logout">Welcome ${sessionScope.user.displayUserName}[${sessionScope.group.displayGroupName}]  &nbsp; [<a  id="username_and_logout_url" href="logout">logout</a>] 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<font color="red">Notice: This is a demo website, and only <b>Search</b> menu is working.
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Major Skills: JSP, Tiles, JQuery, AJAX, JTable, Maven, SpringMVC, Mybatis, MySQL, log4j</font></div>

<div class="clear"></div>
<%@ include file="header_common_part.jsp" %>






