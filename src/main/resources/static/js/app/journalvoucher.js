var $table = $('#table');

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

var code = 0;

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
	loadTable(code);
});

var loadTable = function(code) {
	$('.custom-table > tbody:first').html("");
	$.ajax({ 
		url: '/care-coop/get-journal-voucher-by-member-code/' + code, 
		type: 'GET', 			  		    	 
	  	contentType: 'application/json',
	    success: function(data) { 				  		    				  		    	
	    	
	    	$.each(data, function(i, value) {
	    		$('.custom-table > tbody:first').append("<tr><td>"+value.createdDate+"</td><td align='left'>"+value.particulars+"</td><td>"+value.debit+"</td><td>"+value.credit+"</td></tr>");
		    	
		    	$.each(value.accountsReceivables, function(i, item) {
		    		$('.custom-table > tbody:first').append("<tr><td></td><td>"+item.title+"</td><td>"+item.debit+"</td><td>"+item.credit+"</td></tr>");
		    	});
	    	});
	    	
		},
		    error: function(error, status, er){
		    console.log(error);
		}
	});
	
	
	
}