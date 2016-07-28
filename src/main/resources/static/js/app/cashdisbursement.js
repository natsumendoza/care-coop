var $modal = $('#cash-disbursement-modal').modal({ show: false });
var $table = $('#table');

var $addAccountModal = $('#cash-disbursement-add-loan-type-modal').modal({ show: false });

$('.accNoHide').hide();

$('.add-entry').click(function () {
	$modal.modal('show');
});

$('.cancel').click(function() {
	$modal.modal('hide');
});

$('.add-loan-type').click(function() {
	$addAccountModal.modal('show');
});

$('.add-loan-type-cancel').click(function() {
	$addAccountModal.modal('hide');
});

$('.add-loan-type-submit').click(function() {
	
	var loanType = $('.inputLoanType').val();
	
	var rawjson = {
		loanType: loanType,
	};
	
	var jsondata = JSON.stringify(rawjson);
	
	$.ajax({ 
		url: '/care-coop/create-loan-type/', 
		type: 'POST', 			  		    	 
	    data: jsondata,
	  	contentType: 'application/json',
	    success: function(data) { 				  		    				  		    	
	    		loadLoanType();
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
var memberType = "";
var interestRate = 0;
$('.selectCode').change(function() {
	code = $(this).val();
	$.ajax({ 
		url: '/care-coop/get-client-by-code/' + code, 
		type: 'GET', 			  		    	 
	  	contentType: 'application/json',
	  	async: false,
	    success: function(data) { 			
	    	loadLoanType();
	    	$('.nameDiv').text(data.name);
	    	$('.accNoHide').show();
	    	memberType = data.memberType;
	    	interestRate = getInterestRate(memberType);
		},
		    error: function(error, status, er){
		    console.log(error);
		}
	});
});

var loadLoanType = function() {
	$('.selectLoanType').empty();
		$.ajax({ 
			url: '/care-coop/get-all-loan-types/', 
			type: 'GET', 			  		    	 
		  	contentType: 'application/json',
		    success: function(data) { 		
		    	$('.selectLoanType').append($('<option>', {
	    			value: 1,
	    			text: ""
	    		}));
		    	$.each(data, function(index, item) {
		    		$('.selectLoanType').append($('<option>', {
		    			value: item.loanType,
		    			text: item.loanType
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
	term = $('.inputTerm').val();
	var interestVal = (interestRate / 100) * amount;
	$('.crInterest').val(interestVal);
	$('.loanTD1').text(amount);
	$('.loanTD').text(amount);
	$modal.modal('hide');
});

var term = 0;
var total = 0;
$('.computeTotal').click(function() {
	var crCash = ($('.crCash').val() !== "") ? parseFloat($('.crCash').val()) : 0.00;
	inputData("[Credit] Cash", crCash);
	var crLoan = ($('.loanTD1').text() !== "") ? parseFloat($('.loanTD').text()) : 0.00;
	inputData("[Debit] Loans", crLoan);
	var crInterest = ($('.crInterest').val() !== "") ? parseFloat($('.crInterest').val()) : 0.00;
	inputData("[Credit] Interest on Loans", crInterest);
	var crTime = ($('.crTime').val() !== "") ? parseFloat($('.crTime').val()) : 0.00;
	inputData("[Credit] Time or Savings Deposit", crTime);
	var crFixDep = ($('.crFixDep').val() !== "") ? parseFloat($('.crFixDep').val()) : 0.00;
	inputData("[Credit] Fixed Deposits/Share Capital", crFixDep);
	var crRedemFund = ($('.crRedemFund').val() !== "") ? parseFloat($('.crRedemFund').val()) : 0.00;
	inputData("[Credit] Loan Redemption Fund", crRedemFund);
	var crServiceFee = ($('.crServiceFee').val() !== "") ? parseFloat($('.crServiceFee').val()) : 0.00;
	inputData("[Credit] Service Fee", crServiceFee);
	var crProtectPlan = ($('.crProtectPlan').val() !== "") ? parseFloat($('.crProtectPlan').val()) : 0.00;
	inputData("[Credit] Loan Protect Plan", crProtectPlan);
	var crDamayan = ($('.crDamayan').val() !== "") ? parseFloat($('.crDamayan').val()) : 0.00;
	inputData("[Credit] Damayan Fund", crDamayan);
	var crFines = ($('.crFines').val() !== "") ? parseFloat($('.crFines').val()) : 0.00;
	inputData("[Credit] Fines & Penalties", crFines);
	
	console.log("loan amount: " + $('.loanTD1').text());
	
	console.log(crCash + ", " + crLoan + ", " + crInterest + ", " + crTime + ", " + crFixDep + ", " + crRedemFund + ", " + crServiceFee + ", " + crProtectPlan + ", " + crDamayan + ", " + crFines);

	total = crCash + crLoan + crInterest + crTime + crFixDep + crRedemFund + crServiceFee + crProtectPlan + crDamayan + crFines;
	$('.crTotal').text(total);
	var debTotal = parseFloat($('.inputAmount').val());
});

//console.log("Month: " + new Date().getMonth() + 1 + " Date: " + new Date().getDate() + " Year: " + new Date().getFullYear());
$('.submit-entry').click(function() {
	var voucherNo = $('.disbVoucherNo').val();
	var loanType = $('.selectLoanType').val();
	var title = "Cash";
	var debit = parseInt($('.inputAmount').val());
	var credit = 0;
	var transactionType = "Cash Disbursement";
	var currentMonth = new Date().getMonth() + 1;
	
	var createdDate = new Date();
	
	// compute Due Date
	var currentDate = new Date();
	currentDate.setMonth(currentDate.getMonth() + parseInt(term));
	// end
	
	var principal = parseFloat($('.loanTD1').text());
	var interest = interestRate;
	
	console.log("Monthly payment is: " + computeMonthlyPayment(principal, term, interest));
	
	postJournalVoucher(code, loanType, title, debit, credit);
	postLedger(loanType, title, $('.inputAmount').val(), code, createdDate, credit, debit, transactionType, currentMonth, voucherNo, currentDate);
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

var postJournalVoucher = function(code, loanType, title, debit, credit) {
	
	var rawjson = {
		clientNo: code,
		loanType: loanType,
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

var postLedger = function(loanType, accountTitle, balance, clientNo, createdDate, credit, debit, transactionType, month, voucherNo, dueDate) {
	
	var rawjson = {
		clientNo: clientNo,
		loanType: loanType,
		debit: debit,
		credit: credit,
		accountTitle: accountTitle,
		balance: balance,
		createdDate: createdDate,
		transactionType: transactionType,
		month: month,
		voucherNo: voucherNo,
		dueDate: dueDate
	};
	
	var jsondata = JSON.stringify(rawjson);
	
	$.ajax({ 
		url: '/care-coop/create-ledger', 
		type: 'POST', 			  		    	 
	    data: jsondata,
	  	contentType: 'application/json',
	    success: function(data) { 				  		    				  		    	
	    		alert("Ledger successfully created!");
		    },
		    error: function(error, status, er){
		    	console.log(error);
		    }
	
	});
	
}

var getInterestRate = function(memberType) {
	
	var interestRate = 0;
	
	$.ajax({ 
		url: '/care-coop/get-interest-rate-by-accountType/' + memberType, 
		type: 'GET', 
		async: false,
	  	contentType: 'application/json',
	    success: function(data) { 				  		    				  		    	
	    		interestRate = data.rate;
		    },
		    error: function(error, status, er){
		    	console.log(error);
		    }
	
	});
	
	return interestRate;
	
}

// monthly payment computation
var computeMonthlyPayment = function(principal, term, interest) {
	
	var M = 0;
	var P = principal;
	console.log("parsed interest is: " + interest);
	console.log("principal is: " + P);
	var rawInterest = 1 + (interest / 100) / 12;
	console.log("raw interest is: " + rawInterest);
	var J = rawInterest.toFixed(4);
	console.log("J is: " + J);
	N = term;
	console.log("N is: " + N);
	console.log("(1 + J) is: " + J);
	console.log("Math.pow((1 + J), -N) is: " + (Math.pow(J, (-N))));
	
	var tempJ = Math.pow(J, (-N)).toFixed(4);
	
	var finalJ = (J - 1) / (1 - tempJ);
	
	console.log((J - 1).toFixed(4) + " / (" + 1 + " - " + tempJ + ")");
	
	console.log("final J: " + finalJ);
	
	M = P * finalJ;
	
	return M.toFixed(2);
	
}