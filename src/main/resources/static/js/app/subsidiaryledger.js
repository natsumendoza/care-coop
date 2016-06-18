$modal = $('#subledger-modal').modal({ show: false });

$('.add-info').click(function () {
	$modal.modal('show');
});

$('.cancel').click(function() {
	$modal.modal('hide');
});

$('#inputBday').datepicker({
	dateFormat: 'yy-mm-dd'
});
$('#inputDateClosed').datepicker();

$('.add-info-submit').click(function() {
	
	var code = $('.inputCode').val();
	var name = $('.inputName').val();
	var status = $('.inputStatus').val();
	var type = $('.inputType').val();
	var area = $('.inputArea').val();
	var creditLine = $('.inputCreditLine').val();
	var street = $('.inputStreet').val();
	var town = $('.inputTown').val();
	var city = $('.inputCity').val();
	var telephone = $('.inputTelephone').val();
	var birthday = $('.inputBday').val();
	var membership = $('.inputMembership').val();
	var sex = $('.inputSex').val();
	var civilStatus = $('.inputCivilStatus').val();
	var occupation = $('.inputOccupation').val();
	var beneficiary = $('.inputBeneficiary').val();
	var closedAccount = $('.inputClosedAccount').val();
	var	business = $('.inputBusiness').val();
	var dateClosed = $('.inputDateClosed').val();
	
	var rawjson = {
		clientNo: code,
		name: name,
		status: status,
		type: type,
		area: area,
		creditLine: creditLine,
		address: {
			street: street,
			town: town,
			city: city
		},
		telephone: telephone,
		birthday: birthday,
		membership: membership,
		sex: sex,
		civilStatus: civilStatus,
		occupation: occupation,
		beneficiary: {
			name: beneficiary
		},
//		closedAccount: closedAccount,
		business: business,
		dateClosed: dateClosed
	};
	
	var jsondata = JSON.stringify(rawjson);
	
	$.ajax({ 
		url: '/care-coop/createclient', 
		type: 'POST', 			  		    	 
	    data: jsondata,
	  	contentType: 'application/json',
	    success: function(data) { 				  		    				  		    	
	    	alert("User successfully created!");
		    },
		    error: function(error, status, er){
		    	console.log(error);
		    }
   	});
	
	$modal.modal('hide');
	
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
	    	$('.nameDiv').text(data.name);
	    	$('.statusDiv').text(data.status);
	    	loadSubLedgerTable(code);
		},
		    error: function(error, status, er){
		    console.log(error);
		}
	});
});

var loadSubLedgerTable = function(code) {
	var totalDebit = 0;
	var totalCredit = 0;
	$('.custom-table > tbody:first').html("");
	$.ajax({ 
		url: '/care-coop/get-ledger-by-clientno/' + code, 
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