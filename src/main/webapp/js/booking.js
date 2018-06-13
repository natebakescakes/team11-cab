$( document ).ready(function() {
	
	// on box click
		// 1) DONE: un-highlight all other boxes
		// 2) DONE: apply class .selected on clicked box
		// 3) DONE: set the Choose Room input to the label of that booking-grid
		// 4) DONE: set the #starttime input to what was clicked
		// 5) DONE: set the #endtime input to what was clicked + 1 hour
	
	var box = $(".booking-grid>.row>div:not(.booked)")
	var times = {
		"9AM" 	: "09:00",
		"10AM" 	: "10:00",
		"11AM" 	: "11:00",
		"12PM" 	: "12:00",
		"1PM" 	: "13:00",
		"2PM" 	: "14:00",
		"3PM" 	: "15:00",
		"4PM" 	: "16:00",
		"5PM" 	: "17:00",
		"6PM" 	: "18:00",
		"7PM" 	: "19:00",
		"8PM" 	: "20:00"
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
	    var d = new Date.parseExact($("#starttime").val(), "HH:mm");
	    d = d.add({ hours: 1 });
	    d = d.toString("HH:mm");
	    
	    $("#endtime").val(d);
	})
});