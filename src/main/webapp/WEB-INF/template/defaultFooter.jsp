<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="footer">
	<c:url value="/contact" var="contactUrl" />
	<a href="<c:url value="/contact"/>">Contact</a> |
	

	
	<a href="<c:url value="/mission"/>">Mission</a>	 |
	
	
	<a href="<c:url value="/privacy"/>">Privacy policy</a> |	
	
	<a href="<c:url value="/disclaimer"/>">Disclaimer</a> 
	 

</div>

<div id="footer_copyright">
	copyright_message
</div>
  
