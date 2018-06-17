$(document).ready(function(){
	
	
	   		var b=window.contextRoot + '/json/showmybooking';
	   		
	   		var token = $('#_csrf').attr('content');
	   	    var header = $('#_csrf_header').attr('content');
	   	    
	   		$.ajaxSetup({
	   		    beforeSend: function(xhr) {
	   		        xhr.setRequestHeader('X-CSRF-TOKEN', token);
	   		    }
	   		});
	   		
	   		var simple_cancel=function(data,type,full, meta){
				
				var nowDate=Date.parse(data);
				var startDate=Date.parse(full.startDateDate+" "+full.startTime);
				var disable="";
				if(nowDate>=startDate || full.status=="Cancelled"){ disable="disabled"};
				var activeBtn="";
				if(disable!="disabled" ) {activeBtn="btn-danger";}
				return '<input type="button" value="Cancel" class="'+activeBtn+' td-button btn-cancel btn btn-table btn-alert" ' + disable + '/>' ;		
			}

	   		
	    	var $mybookingtable=$('#mbTable');
    	    	
 			var datatbl1 = $mybookingtable.DataTable(
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
						{   data: 'status'  },
						{	data: 'nowDateTime',
							render: simple_cancel
							}
						]
			
				});
	    	 			
	 			 $('#mbTable tbody').on('click', '.btn-cancel', function (e) {
	 				 
	 				var parenttr = $(this).parents('tr');
	 	    		var id = datatbl1.row( parenttr ).data().bookingId;
	 	    		parenttr.children("td:nth-child(7)").text("Cancelled");
	 	    		
	 	    		$.ajax({
	 		             url: window.contextRoot + "/user/booking/cancel",
	 		             type: "POST",
	 		             data: id.toString(),
	 		             contentType: "text/plain",
	 		             cache: true,
	 		             success: function (result) {
	 		            	 
	 		            	datatbl1.ajax.reload();

	 		             }
	 		           });
	 			 } );
	 		     
	    	 		  
	    	 		         
	    	 		      	    
} );    
	    	 		         


