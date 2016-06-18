$('.accNoHide').hide();

//get all Member codes
$.ajax({ 
	url: '/care-coop/get-clients/', 
	type: 'GET', 			  		    	 
  	contentType: 'application/json',
    success: function(data) { 				  		    				  		    	
    	$.each(data, function(index, item) {
    		$('.selectCode').append($('<option>', {
    			value: item.clientNo,
    			text: item.clientNo
    		}));
    	});
	},
	    error: function(error, status, er){
	    console.log(error);
	}
});
// end

var code = 0;
var accountNo = 0;
var monthInt = 0;

$('.selectMonth').change(function() {
	monthInt = $(this).val();
	loadGenLedgerTable();
});

$('.selectAccountCode').change(function() {
	accountNo = $(this).val();
	loadGenLedgerTable();
});

$('.selectCode').change(function() {
	code = $(this).val();
	$.ajax({ 
		url: '/care-coop/get-client-by-code/' + code, 
		type: 'GET', 			  		    	 
	  	contentType: 'application/json',
	    success: function(data) { 	
	    	loadAccountNo(code);
	    	$('.nameDiv').text(data.name);
	    	$('.statusDiv').text(data.status);
	    	$('.accNoHide').show();
	    	loadGenLedgerTable();
		},
		    error: function(error, status, er){
		    console.log(error);
		}
	});
});

var loadGenLedgerTable = function() {
	
	var url = "";
	
	if((code !== 0) && (accountNo !== 0) && (monthInt !== 0)) {
		url = '/care-coop/get-ledger-by-clientno-and-accountno-and-month/' + code + '/' + accountNo + '/' + monthInt + '/';
	} else if((code !== 0) && (accountNo !== 0) && (monthInt === 0)) {
		url = '/care-coop/get-ledger-by-clientno-and-accountno/' + code + '/' + accountNo + '/';
	} else if((code !== 0) && (accountNo === 0) && (monthInt === 0)) {
		url = '/care-coop/get-ledger-by-clientno/' + code + '/';
	}
	
	$('.custom-table > tbody:first').html("");
	$.ajax({ 
		url: url, 
		type: 'GET', 			  		    	 
	  	contentType: 'application/json',
	    success: function(data) { 				  		    				  		    	
	    	$.each(data, function(i, item) {
	    		$('.custom-table > tbody:first').append("<tr><td>" + item.createdDate + "</td><td>" + item.accountTitle + "</td><td>"+item.debit+"</td><td>"+item.credit+"</td><td>"+item.balance+"</td></tr>");
	    	});
		},
		    error: function(error, status, er){
		    console.log(error);
		}
	});
	
}

var loadAccountNo = function(clientNo) {
	$('.selectAccountCode').empty();
	$.ajax({ 
		url: '/care-coop/get-by-client-no/' + clientNo, 
		type: 'GET', 			  		    	 
	  	contentType: 'application/json',
	    success: function(data) { 	
	    	$('.selectAccountCode').append($('<option>', {
    			value: 1,
    			text: ""
    		}));
	    	$.each(data, function(index, item) {
	    		$('.selectAccountCode').append($('<option>', {
	    			value: item.accountNo,
	    			text: item.accountNo
	    		}));
	    	});
		},
		    error: function(error, status, er){
		    console.log(error);
		}
	});
	
}