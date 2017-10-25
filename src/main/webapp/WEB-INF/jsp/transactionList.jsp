<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <br>
 <h2>Transaction List</h2>
 
 <!-- Include one of jTable styles. -->
<link href="css/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>

<script src="js/main.js" type="text/javascript"></script>
<script src="js/transactionList.js" type="text/javascript"></script>
<c:url var="home" value="/" scope="request" />
<div class="container">
    <span class="collapse-open-span"></span><div class="page_collapsible collapse-open">&nbsp;Search Parameters</div>
    <div class="content">
    <form id="search-transactions-form">
        <label>Transaction number:</label> <input type="text" value="100" maxlength="4" id="RecentTransNum">&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="submit"  id="btn-search"> Search </button>
    </form>
    </div>
</div>

<div class="container">
    <span class="collapse-open-span"></span><div class="page_collapsible collapse-open">&nbsp;Results</div>
    <div id="transaction_list_div" class="content"></div>
</div>


<script type="text/javascript">
$(document).ready(function($) {

	var hash = location.hash;
	if(hash) {
		//alert(hash);
		searchTransactionViaAjax("${home}", hash);
	}
	$("#search-transactions-form").submit(function(event) {

		// Disble the search button
		enableSearchButton(false);

		// Prevent the form from submitting via the browser.
		event.preventDefault();

		searchTransactionViaAjax("${home}","");

	});
});

function enableSearchButton(flag) {
	$("#btn-search").prop("disabled", flag);
}
	
	function display(data) {
		var json = "<h4>Ajax Response</h4><pre>"
				+ JSON.stringify(data, null, 4) + "</pre>";
		//$('#transaction_list').html(json);
		//$('#transaction_list').find("tr:has(td)").remove();
		$('#transaction_list tr').has('td').remove();
		
		var htmlrow = "";
		$.each(data.result, function(key, rec) {
						htmlrow += "<tr><td>" + rec.transactionNum + "</td><td>" + rec.dateTime + "</td><td>" + rec.result
								+ "</td><td>" + rec.checkName + "</td><td>" + rec.deviceId + "</td><td>" + rec.isNewDevice + "</td><td>" + rec.ip +"</td><td>" + rec.browserType +"</td><td>" + rec.browserVersion 
								+"</td><td>" + rec.browserLanguage +"</td><td>" + rec.flashEnabled +"</td><td>" + rec.flashVersion +"</td><td>" + rec.operatingSys 
								+"</td><td>" + rec.screenResolution +"</td><td>" + rec.timeZone +"</td></tr>";
					});

			//$('#transaction_list').html(json);
		$('#transaction_list').append(htmlrow);
	}
</script>


 