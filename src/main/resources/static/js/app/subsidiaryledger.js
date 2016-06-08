$modal = $('#subledger-modal').modal({ show: false });

$('.add-info').click(function () {
	$modal.modal('show');
});

$('.cancel').click(function() {
	$modal.modal('hide');
});
