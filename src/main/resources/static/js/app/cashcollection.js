var $modal = $('#cash-collection-modal').modal({ show: false });
var $table = $('#table');

var $addCollectorModal = $('#cash-collection-add-collector-modal').modal({ show: false });

$('.accNoHide').hide();

$('.add-entry').click(function () {
	$modal.modal('show');
});

$('.submit-entry').prop('disabled', true);

$('.cancel').click(function() {
	$modal.modal('hide');
});

$('.add-collector').click(function() {
	$addCollectorModal.modal('show');
});

$('.add-collector-cancel').click(function() {
	$addCollectorModal.modal('hide');
});

$('.add-collector-submit').click(function() {
	
	var collector = $('.inputCollector').val();
	
	var rawjson = {
			collector: collector,
	};
	
	var jsondata = JSON.stringify(rawjson);
	
	$.ajax({ 
		url: '/care-coop/create-collector/', 
		type: 'POST', 			  		    	 
	    data: jsondata,
	  	contentType: 'application/json',
	    success: function(data) { 				  		    				  		    	
	    		loadCollector();
	    		$addCollectorModal.modal('hide');
		    },
		    error: function(error, status, er){
		    	console.log(error);
		    }
   	});
	
});

// get all Account titles
$.ajax({ 
	url: '/care-coop/account-titles', 
	type: 'GET', 			  		    	 
  	contentType: 'application/json',
    success: function(data) { 				  		    				  		    	
    	$.each(data, function(index, item) {
    		$('.particulars').append($('<option>', {
    			value: item.title,
    			text: item.title
    		}));
    	});
	},
	    error: function(error, status, er){
	    console.log(error);
	}
});
// end

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

var total = 0;
$('.add-entry-submit').click(function () {
	var particulars = $('.particulars').val();
	var amount = $('.inputAmount').val();
	
	total = parseInt(total) + parseInt(amount);
	$table.bootstrapTable('append', inputData(particulars, amount));
    $table.bootstrapTable('scrollTo', 'bottom');
    $('.totalDiv').text(total);
    
    $('.submit-entry').prop('disabled', false);
    
    clearFields();
    $modal.modal('hide');
});

$('.submit-entry').click(function() {
	var orNo = $('.inputORNo').val();
	var title = $('.particulars').val();
	var debit = total;
	var credit = 0;
	
	var currentMonth = new Date().getMonth() + 1;
	
	var transactionType = "Cash Collection";
	
	var collector = $('.selectCollector').val();
	
	
	/* temporary static loan type */
	var latestBalance = getLatestBalance(code, "Educational Loan", "Cash Disbursement");
	
	var newBalance = latestBalance - parseInt(debit);
	
	postJournalVoucher(code, title, debit, credit);
	postLedger(orNo, "Cash", debit, code, new Date(), debit, credit, transactionType, currentMonth, collector);
	
	$('.totalDiv').text("0");
	$table.bootstrapTable('removeAll');
});

var code = 0;
var accountNo = 0;

$('.selectCode').change(function() {
	code = $(this).val();
	$.ajax({ 
		url: '/care-coop/get-client-by-code/' + code, 
		type: 'GET', 			  		    	 
	  	contentType: 'application/json',
	    success: function(data) { 
	    	loadCollector();
	    	$('.nameDiv').text(data.name);
	    	$('.accNoHide').show();
		},
		    error: function(error, status, er){
		    console.log(error);
		}
	});
});

var rows = [];

var loadCollector = function() {
	$('.selectCollector').empty();
		$.ajax({ 
			url: '/care-coop/get-all-collectors/', 
			type: 'GET', 			  		    	 
		  	contentType: 'application/json',
		    success: function(data) { 		
		    	$('.selectCollector').append($('<option>', {
	    			value: 1,
	    			text: ""
	    		}));
		    	$.each(data, function(index, item) {
		    		$('.selectCollector').append($('<option>', {
		    			value: item.collector,
		    			text: item.collector
		    		}));
		    	});
			},
			    error: function(error, status, er){
			    console.log(error);
			}
		});
}

function getLatestBalance(clientNo, loanType, transactionType) {
	
	var latestBalance = 0;
	
	$.ajax({ 
		url: '/care-coop/get-latest-balance-by-clientno-and-loantype-and-transactiontype/' + clientNo +'/' + loanType + '/' + transactionType, 
		type: 'GET', 			  		    	 
	    async: false,
	  	contentType: 'application/json',
	    success: function(data) { 				  		    				  		    	
	    		latestBalance = parseInt(data.balance);
		    },
		    error: function(error, status, er){
		    	console.log(error);
		    }
   	});
	return latestBalance;
}

function inputData(particulars, amount) {
    var row = [];
    row.push({
        particulars: particulars,
        amount: amount
    });
    rows.push({
        particulars: particulars,
        amount: amount
    });
    return row;
}
var clearFields = function() {
	$('.inputParticulars').val("");
	$('.inputAmount').val("");
}

var postJournalVoucher = function(code, title, debit, credit) {
	
	var rawjson = {
		clientNo: code,
		title: title,
		debit: debit,
		credit: credit,
		particulars: 'Cash',
		accountsReceivables: JSON.parse(postAccountsReceivables()),
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

var postAccountsReceivables = function() {
	
	jsonRowAR = [];
	
	$.each(rows, function(i, item) {
		jsonRowAR.push({
			title: 'Receivable - ' + item.particulars,
			debit: 0,
			credit: item.amount,
			dateCreated: new Date()
		});
	});
	return JSON.stringify(jsonRowAR);
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

var postLedger = function(orNo, accountTitle, balance, clientNo, createdDate, credit, debit, transactionType, month, collector) {
	
	var rawjson = {
		clientNo: clientNo,
		orNo: orNo,
		debit: debit,
		credit: credit,
		accountTitle: accountTitle,
		balance: balance,
		createdDate: createdDate,
		transactionType: transactionType,
		month: month,
		collector: collector
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