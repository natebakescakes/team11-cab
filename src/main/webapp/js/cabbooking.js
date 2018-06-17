$(document).ready(function(){
	
	   		var b=window.contextRoot + '/json/showbooking';
	   		
	   		var token = $('#_csrf').attr('content');
	   	    var header = $('#_csrf_header').attr('content');
	   	    //alert(token);
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
						{	defaultContent: "<button class='btn-cancel btn btn-table btn-alert btn-danger'>Cancel</button>" 	},
						{	defaultContent: "<button class='btn-main btn btn-table btn-warning'>Maintenance</button>" 	}
						]
			
				});
	    	 			
	    	 			
	    	 			$('#bTable tbody').on('click', '.btn-book', function (e) {
	    	 				
	    	 			
	    	 				var parenttr=$(this).parents('tr');
	    	 				var id1=datatbl1.row( parenttr ).data().bookingId;
	    	 				
	    	 				//var status = parenttr.children("td:nth-child(7)").text();
	    	 				parenttr.children("td:nth-child(7)").text("Booked");
	    	 				
	    	 				
	    	 				$.ajax({
	    	 		             url: window.contextRoot + "/admin/booking/booked",
	    	 		             type: "POST",
	    	 		             data: id1.toString(),
	    	 		             contentType: "text/plain",
	    	 		             cache: true,
	    	 		             success: function (result) {
	    	 		            	// alert("Booking has been updated " + result);

	    	 		             }
	    	 		           });
	    	 				 
	    	 		         });
	    	 		         

	    	 				
	    	 				$('#bTable tbody').on('click', '.btn-cancel', function (e) {
		    	 				
	    	    	 			
		    	 				var parenttr=$(this).parents('tr');
		    	 				var id2=datatbl1.row( parenttr ).data().bookingId;
		    	 				
		    	 				parenttr.children("td:nth-child(7)").text("Cancelled");
		    	 				
		    	 				$.ajax({
		    	 		             url: window.contextRoot + "/admin/booking/cancelled",
		    	 		             type: "POST",
		    	 		             data: id2.toString(),
		    	 		             contentType: "text/plain", 
		    	 		             cache: true,
		    	 		             success: function (result) {
		    	 		             }
		    	 		           });
		    	 				
		    	 				 
		    	 		         });
	    	 				
	    	 				$('#bTable tbody').on('click', '.btn-main', function (e) {
		    	 				
	    	 					var parenttr=$(this).parents('tr');
		    	 				var id3=datatbl1.row( parenttr ).data().bookingId;
		    	 				
		    	 				parenttr.children("td:nth-child(7)").text("Maintenance");
		    	 				
		    	 				$.ajax({
		    	 		             url: window.contextRoot + "/admin/booking/maintenance",
		    	 		             type: "POST",
		    	 		             data: id3.toString(),
		    	 		             contentType: "text/plain",
		    	 		             cache: true,
		    	 		             success: function (result) {
		    	 		            	 

		    	 		             }
		    	 		           });
		    	 				
		    	 				
		    	 				
		    	 				 
		    	 		         });
	    	 				
	    	 				
	    	 				
	    	 				
	    	 				
});
	    	 				
	    	 			
	    	 			
//	    	 			