var selectedIndex = 0;

$('.verifier').click(function () {
	$('.main-body').load('/care-coop/verifier');
	selectedIndex = 1;
});

$('.cash-collection').click(function () {
	$('.main-body').load('/care-coop/cashcollection');
	selectedIndex = 2;
});

$('.cash-disbursement').click(function () {
	$('.main-body').load('/care-coop/cashdisbursement');
	selectedIndex = 3;
});

$('.journal-voucher').click(function () {
	$('.main-body').load('/care-coop/journalvoucher');
	selectedIndex = 4;
});

$('.general-ledger').click(function () {
	$('.main-body').load('/care-coop/generalledger');
	selectedIndex = 5;
});

$('.subsidiary-ledger').click(function () {
	$('.main-body').load('/care-coop/subsidiaryledger');
	selectedIndex = 6;
});

$('.setup-computation').click(function () {
	$('.main-body').load('/care-coop/setupcomputation');
	selectedIndex = 7;
});

$('.utility').click(function () {
	$('.main-body').load('/care-coop/utility');
	selectedIndex = 8;
});

$('.home-link').click(function() {
	window.location.href = "/care-coop/home";
	selectedIndex = 1;
});

$('.list-menu').click(function() {
	
	removeClassLI();
	
	if(selectedIndex === 1) {
		$('.verifier').addClass('active-li');
	} else if(selectedIndex === 2) {
		$('.cash-collection').addClass('active-li');
	} else if(selectedIndex === 3) {
		$('.cash-disbursement').addClass('active-li');
	} else if(selectedIndex === 4) {
		$('.journal-voucher').addClass('active-li');
	} else if(selectedIndex === 5) {
		$('.general-ledger').addClass('active-li');
	} else if(selectedIndex === 6) {
		$('.subsidiary-ledger').addClass('active-li');
	} else if(selectedIndex === 7) {
		$('.setup-computation').addClass('active-li');
	} else if(selectedIndex === 8) {
		$('.utility').addClass('active-li');
	}
	
});

var removeClassLI = function() {
	
	$('.verifier').removeClass('active-li');
	$('.cash-collection').removeClass('active-li');
	$('.cash-disbursement').removeClass('active-li');
	$('.journal-voucher').removeClass('active-li');
	$('.general-ledger').removeClass('active-li');
	$('.subsidiary-ledger').removeClass('active-li');
	$('.setup-computation').removeClass('active-li');
	$('.utility').removeClass('active-li');
	
}