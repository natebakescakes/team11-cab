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
	    							{	data: 'endDateDate'		},
	    							{	data: 'startTime'	},
	    							{	data: 'endTime'		},
	    							{	defaultContent: "<button class='td-button btn-edit'>Edit</button>"    	},
	    							{	defaultContent: "<button class='td-button btn-delete'>Delete</button>" 	}
	    							]
						
	    					});
	    	 			
	    	 			 $('#bTable tbody').on('click', '.btn-edit', function (e) {
	    	 		         var data = datatbl1.row( $(this).parents('tr') ).data();
	    	 		    	 var counter = 0;
	    	 		         $($(this).parents('tr')).find("td").each(function(){
	    	 	        		 counter++;
	    	 		        	 if(counter == 1){
	    	 		        		 return;
	    	 		        	 }
	    	 		        	 if (!$(this).children().hasClass("td-button"))
	    	 		        	    {
	    	 		        	        var text = $(this).text();
	    	 		        	        $(this).html ('<input type="text" value="' +  text + '">');
	    	 		        	    } 
	    	 		        	 if ($(this).children().hasClass("btn-edit"))
	    	 		        		 {
	    	 		        	       $(this).html ('<button class="td-button btn-save">Submit</button>');
	    	 		        		 }
	    	 		        	   })
	    	 		      
	    	 		      } );
	    	 		     
	    	 		     $('#bTable tbody').on('click', '.btn-save', function (e) {
	    	 	    		 var parenttr = $(this).parents('tr');
	    	 		    	 var counter = 0;
	    	 		    	 $($(this).parents('tr')).find("td").each(function(){
	    	 	        		 counter++;
	    	 		        	 if(counter == 1){
	    	 		        		 return;
	    	 		        	 }
	    	 		        	 if (!$(this).children().hasClass("td-button"))
	    	 		        	    {
	    	 		        		 	var text = $(this).find("input").val();
	    	 		        		 	$(this).text(text);
	    	 		        		 	var cell = datatbl1.cell( $(this) );
	    	 		        		 	cell.data( text ).draw();
	    	 		        	   
	    	 		        	    } 
	    	 		
	    	 			    	 
	    	 		        	 if ($(this).children().hasClass("btn-save"))
	    	 		        		 {
	    	 		        	        $(this).html ('<button class="td-button btn-edit">Edit</button>')
	    	 		        		 } 
	    	 		        	 
	    	 		        	 
	    	 		        	});
	    	 		    	 
	    	 		         var bookingdata = datatbl1.row( parenttr ).data();

	    	 		         
	    	 		         $.ajax({
	    	 		             url: window.contextRoot + "admin/booking/update",
	    	 		             type: "POST",
	    	 		             data: JSON.stringify(bookingdata),
	    	 		             contentType: "application/json",
	    	 		             cache: true,
	    	 		             success: function (result) {
	    	 		            	 alert("Booking has been updated");

	    	 		             }
	    	 		           });
	    	 		      	    
	    	 		      } );    
	    	 		         
	    	 		     $('#bTable tbody').on('click', '.btn-delete', function (e) {
	    	 		         var del = datatbl1.row( $(this).parents('tr') ).data();
	    	 		         $.ajax({
	    	 		             url: window.contextRoot + "admin/booking/delete",
	    	 		             type: "POST",
	    	 		             data: JSON.stringify(del),
	    	 		             contentType: "application/json",
	    	 		             cache: true,
	    	 		             success: function (result) {
	    	 		                    datatbl1.ajax.reload();
	    	 		 
	    	 		             }
	    	 		         
	    	 		        
	    	 		           });
	    	 		         
	    	 		      });	
});


