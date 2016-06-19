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

$('.add-entry-submit').click(function() {
	var amount = $('.inputAmount').val();
	$('.loanTD').text(amount);
	$modal.modal('hide');
});

var total = 0;
$('.computeTotal').click(function() {
	var crCash = parseInt($('.crCash').val());
	inputData("[Credit] Cash", crCash);
	var crLoan = parseInt($('.crLoan').val());
	inputData("[Credit] Loans", crLoan);
	var crInterest = parseInt($('.crInterest').val());
	inputData("[Credit] Interest on Loans", crInterest);
	var crTime = parseInt($('.crTime').val());
	inputData("[Credit] Time or Savings Deposit", crTime);
	var crFixDep = parseInt($('.crFixDep').val());
	inputData("[Credit] Fixed Deposits/Share Capital", crFixDep);
	var crRedemFund = parseInt($('.crRedemFund').val());
	inputData("[Credit] Loan Redemption Fund", crRedemFund);
	var crServiceFee = parseInt($('.crServiceFee').val());
	inputData("[Credit] Service Fee", crServiceFee);
	var crProtectPlan = parseInt($('.crProtectPlan').val());
	inputData("[Credit] Loan Protect Plan", crProtectPlan);
	var crDamayan = parseInt($('.crDamayan').val());
	inputData("[Credit] Damayan Fund", crDamayan);
	var crFines = parseInt($('.crFines').val());
	inputData("[Credit] Fines & Penalties", crFines);

	total = crCash + crLoan + crInterest + crTime + crFixDep + crRedemFund + crServiceFee + crProtectPlan + crDamayan + crFines;
	$('.crTotal').text(total);
	var debTotal = parseInt($('.inputAmount').val());
});

$('.submit-entry').click(function() {
	var accountCode = parseInt($('.selectAccountCode').val());
	var title = "title";
	var debit = parseInt($('.inputAmount').val());
	var credit = total;
	postJournalVoucher(code, accountCode, title, debit, credit);
});

var rows = [];

function inputData(particulars, amount) {
//    var row = [];
//    row.push({
//        particulars: particulars,
//        amount: amount
//    });
    rows.push({
        particulars: particulars,
        amount: amount
    });
}

var postJournalVoucher = function(code, accountCode, title, debit, credit) {
	
	var rawjson = {
		clientNo: code,
		accountNo: accountCode,
		title: title,
		debit: debit,
		credit: credit,
		particulars: 'Disbursement',
		accountsPayables: JSON.parse(postAccountsPayables()),
		createdDate: new Date()
	};
	
	
	var jsondata = JSON.stringify(rawjson);
	
	console.log(jsondata);
	
	$.ajax({ 
		url: '/care-coop/create-journal-voucher', 
		type: 'POST', 			  		    	 
	    data: jsondata,
	  	contentType: 'application/json',
	    success: function(data) { 				  		    				  		    	
	    		alert("Journal Voucher successfully created!");
		    },
		    error: function(error, status, er){
		    	console.log(error);
		    }
	
	});
}

var postAccountsPayables = function() {
	
	jsonRowAR = [];
	
	$.each(rows, function(i, item) {
		jsonRowAR.push({
			title: 'Payables - ' + item.particulars,
			debit: 0,
			credit: item.amount,
			dateCreated: new Date()
		});
	});
	return JSON.stringify(jsonRowAR);
}