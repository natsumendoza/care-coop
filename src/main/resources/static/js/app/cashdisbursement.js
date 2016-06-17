var $modal = $('#cash-disbursement-modal').modal({ show: false });
var $table = $('#table');

var $addAccountModal = $('#cash-disbursement-add-account-modal').modal({ show: false });

$('.accNoHide').hide();

$('.add-entry').click(function () {
	$modal.modal('show');
});

$('.cancel').click(function() {
	$modal.modal('hide');
});

$('.add-account').click(function() {
	$addAccountModal.modal('show');
});

$('.add-account-cancel').click(function() {
	$addAccountModal.modal('hide');
});

$('.add-account-submit').click(function() {
	
	var accountName = $('.inputAccountName').val();
	var accountNo = $('.inputAccountNo').val();
	
	var rawjson = {
		accountNo: accountNo,
		title: accountName,
		clientNo: code,
		createdDate: new Date()
	};
	
	var jsondata = JSON.stringify(rawjson);
	
	$.ajax({ 
		url: '/care-coop/create-account/', 
		type: 'POST', 			  		    	 
	    data: jsondata,
	  	contentType: 'application/json',
	    success: function(data) { 				  		    				  		    	
	    		alert("Account with Account No. " + data.accountNo +" successfully created!");
	    		loadAccountNo(data.clientNo);
	    		$addAccountModal.modal('hide');
		    },
		    error: function(error, status, er){
		    	console.log(error);
		    }
   	});
	
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

var code = 0;

$('.selectCode').change(function() {
	code = $(this).val();
	$.ajax({ 
		url: '/care-coop/get-client-by-code/' + code, 
		type: 'GET', 			  		    	 
	  	contentType: 'application/json',
	    success: function(data) { 			
	    	loadAccountNo(code);
	    	$('.nameDiv').text(data.name);
	    	$('.accNoHide').show();
		},
		    error: function(error, status, er){
		    console.log(error);
		}
	});
});

$('.add-entry-submit').click(function() {
	var amount = $('.inputAmount').val();
	$('.loanTD').text(amount);
	$modal.modal('hide');
});

var loadAccountNo = function(clientNo) {
	$('.selectAccountCode').empty();
	$.ajax({ 
		url: '/care-coop/get-by-client-no/' + clientNo, 
		type: 'GET', 			  		    	 
	  	contentType: 'application/json',
	    success: function(data) { 				  		    				  		    	
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