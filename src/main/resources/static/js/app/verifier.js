var $modal = $('#verifier-modal').modal({ show: false });

var code = 0;
var monthInt = 0;

$('.show-info').prop('disabled', true);

$('.selectMonth').change(function() {
	monthInt = $(this).val();
	loadSubLedgerTable();
});

$('.rowHide').hide();

$('.show-info').click(function () {
	loadInfo(code);
	$modal.modal('show');
});

$('.typeSelect').change(function() {
	$('.rowHide').show();
});

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

$('.selectCode').change(function() {
	code = $(this).val();
	$.ajax({ 
		url: '/care-coop/get-client-by-code/' + code, 
		type: 'GET', 			  		    	 
	  	contentType: 'application/json',
	    success: function(data) { 				  		    				  		    	
	    	$('.nameDiv').text(data.name);
	    	$('.statusDiv').text(data.status);
	    	loadSubLedgerTable();
	    	$('.show-info').prop('disabled', false);
		},
		    error: function(error, status, er){
		    console.log(error);
		}
	});
});

var loadInfo = function(code) {
	$.ajax({ 
		url: '/care-coop/get-client-by-code/' + code, 
		type: 'GET', 			  		    	 
	  	contentType: 'application/json',
	    success: function(data) {
	    	console.log(data);
	    	$('.type').text(data.type);
	    	$('.area').text(data.area);
	    	$('.creditLine').text(data.creditLine);
	    	$('.street').text(data.address.street);
	    	$('.town').text(data.address.town);
	    	$('.city').text(data.address.city);
	    	$('.telephone').text(data.telephone);
	    	$('.bday').text(data.birthday);
	    	$('.membership').text(data.membership);
	    	$('.sex').text(data.sex);
	    	$('.civilStatus').text(data.civilStatus);
	    	$('.occupation').text(data.occupation);
	    	$('.beneficiary').text(data.beneficiary.name);
	    	$('.closedAccount').text(data.closedAccount);
	    	$('.business').text(data.business);
	    	$('.dateClosed').text(data.dateClosed);
		},
		    error: function(error, status, er){
		    console.log(error);
		}
	});
}

var loadSubLedgerTable = function() {
	var totalDebit = 0;
	var totalCredit = 0;
	
	var url = "";
	
	if((code !== 0) && (monthInt !== 0)) {
		url = '/care-coop/get-ledger-by-clientno-and-month/' + code +  '/' + monthInt + '/';
	} else if((code !== 0) && (monthInt === 0)) {
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
	    		totalDebit += item.debit;
	    		totalCredit += item.credit;
	    	});
	    	$('.tdTotalDebit').text(totalDebit);
	    	$('.tdTotalCredit').text(totalCredit);
		},
		    error: function(error, status, er){
		    console.log(error);
		}
	});
	
}
