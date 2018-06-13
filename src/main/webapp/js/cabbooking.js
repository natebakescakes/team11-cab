$(document).ready(function(){
	
	   		var b=window.contextRoot + '/json/showmember/jsonbookinglist';
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
	    	 			
	    	   	 			
});

