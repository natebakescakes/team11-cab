$(document).ready(function(){
	
	   		var b=window.contextRoot + '/json/showbooking';
	   		
	   		var token = $('#_csrf').attr('content');
	   	    var header = $('#_csrf_header').attr('content');
	   	    
	   		$.ajaxSetup({
	   		    beforeSend: function(xhr) {
	   		        xhr.setRequestHeader('X-CSRF-TOKEN', token);
	   		    }
	   		});
	   		
	    	var $bookingtable=$('#bTable');
    	    	
 			var datatbl1 = $bookingtable.DataTable(
				{
					ajax: {
						url: b,
						dataSrc: ''
					},
					columns: [
						{	data: 'bookingId'	},
						{	data: 'facilityName'	},
						{	data: 'startDateDate'	},
						{	data: 'startTime'	},
						{	data: 'endDateDate'		},
						{	data: 'endTime'		},
						{   data: 'status'      },
						{	defaultContent: "<button class='btn-book btn btn-table btn-primary'>Book</button>"    	},
						{	defaultContent: "<button class='btn-cancel btn btn-table btn-alert'>Cancel</button>" 	},
						{	defaultContent: "<button class='btn-main btn btn-table btn-warning'>Maintenance</button>" 	}
						]
			
				});
	    	 			
	    	 			
	    	 			$('#bTable tbody').on('click', '.btn-book', function (e) {
	    	 				
	    	 			
	    	 				var parenttr=$(this).parents('tr');
	    	 				
	    	 				var id1 = parenttr.children(":first-child").text();
	    	 				var status = parenttr.children("td:nth-child(7)").text();
	    	 				parenttr.children("td:nth-child(7)").text("Booked");
	    	 				
	    	 				 
	    	 		         });
	    	 		         

	    	 				
	    	 				$('#bTable tbody').on('click', '.btn-cancel', function (e) {
		    	 				
	    	    	 			
		    	 				var parenttr=$(this).parents('tr');
		    	 				
		    	 				var id2 = parenttr.children(":first-child").text();
		    	 				var status = parenttr.children("td:nth-child(7)").text();
		    	 				parenttr.children("td:nth-child(7)").text("Cancelled");
		    	 				
		    	 				 
		    	 		         });
	    	 				
	    	 				$('#bTable tbody').on('click', '.btn-main', function (e) {
		    	 				
	    	    	 			
		    	 				var parenttr=$(this).parents('tr');
		    	 				
		    	 				var id3 = parenttr.children(":first-child").text();
		    	 				var status = parenttr.children("td:nth-child(7)").text();
		    	 				parenttr.children("td:nth-child(7)").text("Maintenance");
		    	 				
		    	 				 
		    	 		         });
	    	 				
	    	 				
	    	 				$.ajax({
	    	 		             url: window.contextRoot + "admin/booking/booked",
	    	 		             type: "POST",
	    	 		             data: id1,
	    	 		             contentType: "application/json",
	    	 		             cache: true,
	    	 		             success: function (result) {
	    	 		            	 alert("Booking has been updated");

	    	 		             }
	    	 		           });
	    	 				
	    	 				
});
	    	 				
	    	 			
	    	 			
//	    	 			