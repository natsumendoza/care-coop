var $modal = $('#verifier-modal').modal({ show: false });

var code = 0;

$('.show-info').click(function () {
	loadInfo(code);
	$modal.modal('show');
});

//get all Member codes
$.ajax({ 
	url: '/care-coop/get-clients/', 
	type: 'GET', 			  		    	 
  	contentType: 'application/json',
    success: function(data) { 				  		    				  		    	
    	$.each(data, function(index, item) {
    		$('.selectCode').append($('<option>', {
    			value: item.code,
    			text: item.code
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


