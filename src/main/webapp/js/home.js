$(document).ready(function() {
	$('.thing').slick({
		infinite : true,
		slidesToShow : 3,
		prevArrow: $('.prev'),
	    nextArrow: $('.next'),
		
	});
	
	$('.timepicker').timepicker({
	    timeFormat: 'h:mm p',
	    interval: 60,
	    minTime: '9',
	    maxTime: '9:00pm',
	    defaultTime: '9',
	    startTime: '9:00am',
	    dynamic: true,
	    dropdown: true,
	    scrollbar: true
	});
	
	$('.datepicker').datepicker({
		todayHighlight: true,
		format: 'dd/mm/yyyy',
		startDate: "0d"
	});
	
	/* 
	 * for Form Validator
	 */
	$.validate();
	
});

