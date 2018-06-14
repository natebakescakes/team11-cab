$( document ).ready(function() {
	
	/*
	 * For Table manipulation
	 */
	
	// on box click
		// 1) DONE: un-highlight all other boxes
		// 2) DONE: apply class .selected on clicked box
		// 3) DONE: set the Choose Room input to the label of that booking-grid
		// 4) DONE: set the #starttime input to what was clicked
		// 5) DONE: set the #endtime input to what was clicked + 1 hour
	
	var box = $(".booking-grid>.row>div:not(.booked)")
	var times = {
		"9AM" 	: "9:00 AM",
		"10AM" 	: "10:00 AM",
		"11AM" 	: "11:00 AM",
		"12PM" 	: "12:00 PM",
		"1PM" 	: "1:00 PM",
		"2PM" 	: "2:00 PM",
		"3PM" 	: "3:00 PM",
		"4PM" 	: "4:00 PM",
		"5PM" 	: "5:00 PM",
		"6PM" 	: "6:00 PM",
		"7PM" 	: "7:00 PM",
		"8PM" 	: "8:00 PM"
	}
	
	box.click(function(e) {
		var time;
		var target = $(e.target);
		var selectedFacId;
		
		// 1
		box.removeClass("selected");
		// 2
		target.addClass("selected");
		// 3
		selectedFacId = target.parent().attr("data-value");
		$("#choose-room").val(selectedFacId);
		
		// 4
		time = times[target.text()];
	    $("#starttime").val(time);
	    
	    // 5
	    var d = new Date.parseExact($("#starttime").val(), "h:mm tt");
	    d = d.add({ hours: 1 });
	    d = d.toString("h:mm tt");
	    
	    $("#endtime").val(d);
	})
	
	/* 
	 * for Form Validator
	 */
	$.validate();
	
	/* 
	 * for timepicker
	 */
	$('.timepicker').timepicker({
	    timeFormat: 'h:mm p',
	    interval: 60,
	    minTime: '9',
	    maxTime: '9:00pm',
	    defaultTime: '9',
	    startTime: '9:00am',
	    dynamic: false,
	    dropdown: true,
	    scrollbar: true
	});
	
	/* 
	 * for datepicker
	 */
	$('.datepicker').datepicker({
		todayHighlight: true,
		format: 'dd/mm/yyyy'
	});
});