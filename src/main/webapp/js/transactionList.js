function searchTransactionViaAjax(home, hashStr, mode) {
		//$("#transaction_list_div").jtable({});
		//$("#transaction_list_div tr").has('td').remove();
		hashStr = (hashStr || "");
		var pageSize = 50;
		var currentPage = 1;
		if(hashStr.search('#page=') == 0) {
			hashStr = hashStr.substr(6);
			var arrHash = hashStr.split(',');
			if(arrHash.length == 3) {
				pageSize = arrHash[0];
				currentPage = arrHash[1];
				$("#RecentTransNum").value = arrHash[2];
			}
		}
		if ($('#transaction_list_div .jtable-main-container').length > 0) {
			//$('#transaction_list_div').jtable({});
			$("#transaction_list_div").jtable("destroy");
		}
		var paging = true;
		var title = 'The Transaction List';
		var ajaxUrl = home+'TransactionListAjax2?maxCount=' + $("#RecentTransNum").val();
		//window.location.hash = "RecentTransNum="+$("#RecentTransNum").val();
		if(mode == "account") {
			//paging = false;
			title = "";
			ajaxUrl += "&accountName="+$("#TransactionList_AccountName").val()
		} else if(mode == "device") {
			//paging = false;
			title = "";
			ajaxUrl += "&deviceId="+$("#TransactionList_DeviceId").val()
		} 
		$("#transaction_list_div").jtable({
			  title: title,
	          paging: true, //Enable paging
	          pageSize: pageSize, //Set page size (default: 10)
	          sorting: true, //Enable sorting
	          defaultSorting: 'transactionNum DESC', //Set default sorting
	          saveUserPreferences: false,
	          actions: {
	              listAction: ajaxUrl
	          },
	          recordsLoaded: function(event, data) {
	        	if(mode == undefined) {
	        		// Recent Transactions
	        	  	var pageSize = $("#transaction_list_div").jtable("option")["pageSize"];
	      			var pageNum = $('.jtable-goto-page select option:selected').val();
	      			var maxCount = $("#RecentTransNum").val();
					window.location.hash = "page=" + pageSize + "," + pageNum + "," + maxCount;
	          	}
	          },
	          fields: {
	        	  transactionNum:{
	        		  title:'Transaction ID',
	        		  width: '6%'
	        			//width:"auto"
	        	  },
	        	  dateTime:{
	        		  title:'Date Time',
	           		  width: '7%'
	           			//	width:"auto"
	        	  },
	        	  result:{
	        		  title:'Result',
	           		  width: '5%'
	        	  },
	        	  accountName:{
	        		  title:'Account',
	        		  display : function(data) {
	        			  	var accountName = data.record.accountName;
							return '<a href=' + home + 'accountDetail?account=' + accountName + '>' + accountName + '</a>';
						},
	           		  width: '7%'
	        	  },
	        	  deviceId:{
	        		  title:'Device ID',
	        		  display : function(data) {
	        			  	var deviceId = data.record.deviceId;
							return '<a href=' + home + 'deviceDetail?deviceId=' + deviceId + '>' + deviceId + '</a>';
	        		  },
	           		  width: '7%'
	        	  },
	        	  isNewDevice:{
	        		  title:'New Device',
	           		  width: '6%'
	        	  },
	        	  ip:{
	        		  title:'IP',
	           		  width: '6%'
	        	  },
	        	  browserType:{
	        		  title:'Browser Type',
	           		  width: '7%'
	        	  },
	        	  browserVersion:{
	        		  title:'Browser Version',
	           		  width: '7%'
	        	  },
	        	  browserLanguage:{
	        		  title:'Browser Language',
	           		  width: '7%'
	        	  },
	        	  flashEnabled:{
	        		  title:'Flash Enabled',
	           		  width: '6%'
	        	  },
	        	  flashVersion:{
	        		  title:'Flash Version',
	           		  width: '7%'
	        	  },
	        	  operatingSys:{
	        		  title:'Operation System',
	           		  width: '7%'
	        	  },
	        	  screenResolution:{
	        		  title:'Screen Resolution',
	           		  width: '7%'
	        	  },
	        	  timeZone:{
	        		  title:'Time Zone',
	           		  width: '7%'
	        	  }
	          }
		});
		
		 //Load transaction list from server
		$("#transaction_list_div").jtable("load", {currentPageNo:currentPage });
		
		/*var pageSize = $("#transaction_list_div").jtable("option")["pageSize"];
		//var currentPage = $(".jtable-page-number-active").val();
		var pageNum = $('.jtable-goto-page select option:selected').val();
		//window.location.hash = "pageSize="+pageSize;
		window.location.hash = "page="+pageSize+","+pageNum;*/
		
	}