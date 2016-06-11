var $modal = $('#cash-collection-modal').modal({ show: false });
var $table = $('#table');

$('.add-entry').click(function () {
	$modal.modal('show');
});

$('.cancel').click(function() {
	$modal.modal('hide');
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

var total = 0;
$('.add-entry-submit').click(function () {
	var particulars = $('.particulars').val();
	var amount = $('.inputAmount').val();
	
	total = parseInt(total) + parseInt(amount);
	$table.bootstrapTable('append', inputData(particulars, amount));
    $table.bootstrapTable('scrollTo', 'bottom');
    $('.totalDiv').text(total);
    
    clearFields();
    $modal.modal('hide');
});

$('.submit-entry').click(function() {
	
});

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
});

function inputData(particulars, amount) {
    var row = [];
    row.push({
        particulars: particulars,
        amount: amount
    });
    return row;
}
var clearFields = function() {
	$('.inputParticulars').val("");
	$('.inputAmount').val("");
}