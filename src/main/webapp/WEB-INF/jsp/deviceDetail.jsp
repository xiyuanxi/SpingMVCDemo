<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <br>
 <h2>Device Detail:  <b>${param.deviceId}</b></h2>
 
 
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
    <span class="collapse-open-span"></span><div class="page_collapsible collapse-open">Associated Accounts</div>
    <div  class="content">
    <div id="associated_accounts_div" style="width: 700px"></div>
    </div>
</div>

 <div class="container">
    <span class="collapse-open-span"></span><div class="page_collapsible collapse-open">Associated Devices</div>
    <div  class="content" >
   	<div id="associated_devices_div" style="width: 700px"></div>
    </div>
</div>

<input type="hidden" value="100" maxlength="4" id="RecentTransNum">
<input type="hidden" value="${param.deviceId}" maxlength="20" id="TransactionList_DeviceId">
<div class="container">
    <span class="collapse-open-span"></span><div class="page_collapsible collapse-open">Transactions</div>
    <div id="transaction_list_div" class="content">
    </div>
</div>

<script type="text/javascript">
function searchDeviceViaAjax(home) {
		$("#associated_devices_div").jtable({
	          paging: false, //Enable paging
	          sorting: false, //Enable sorting
	          saveUserPreferences: false,
	          actions: {
	              listAction: "${home}AssociatedDevicesAjax"
	          },
	          fields: {
	        	  deviceId:{
	        		  title:'Device ID',
	        		  display : function(data) {
	        			  	var deviceId = data.record.deviceId;
							return '<a href=' + home + 'deviceDetail?deviceId=' + deviceId + '>' + deviceId + '</a>';
	        		  },
	        		  width: '20%'
	        	  },
	        	  firstSeen:{
	        		  title:'First Seen Date',
	           		  width: '20%'
	        	  },
	        	  accountsInCommon:{
	        		  title:'Accounts in Common',
	           		  width: '20%'
	        	  },
	        	  otherAccounts:{
	        		  title:'Other Accounts',
	           		  width: '20%'
	        	  },
	        	  associatedDevices:{
	        		  title:'Associated Devices',
	           		  width: '20%'
	        	  }
	          }
		});
		
		 //Load transaction list from server
		$("#associated_devices_div").jtable("load");
}
function searchAccountViaAjax(home) {
	$("#associated_accounts_div").jtable({
          paging: false, //Enable paging
          sorting: false, //Enable sorting
          saveUserPreferences: false,
          actions: {
              listAction: "${home}AssociatedAccountsAjax?device_id=${param.deviceId}"
          },
          recordsLoaded: function(event, data) {
        	  searchDeviceViaAjax("${home}");
	      },
          fields: {
        	  accountName:{
        		  title:'Accounts',
        		  display : function(data) {
        			  	var accountName = data.record.accountName;
						return '<a href=' + home + 'accountDetail?account=' + accountName + '>' + accountName + '</a>';
					},
           		  width: '30%'
        	  },
        	  associatedDevices:{
        		  title:'Associated Devices',
           		  width: '20%'
        	  },
        	  associatedAccounts:{
        		  title:'Associated Accounts',
           		  width: '20%'
        	  }
          }
	});
	
	 //Load transaction list from server
	$("#associated_accounts_div").jtable("load");
}
//$(document).ready(searchDeviceViaAjax);
var error = "${errMessage}";
if(!error) {
	$(document).ready(searchAccountViaAjax("${home}"));
	$(document).ready(searchTransactionViaAjax("${home}","","device"));
} else {
	alert(error);
}
 </script>
 