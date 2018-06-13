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
	    							{	data: 'facilityId'	},
  									{	data: 'startDate'	},
	    							{	data: 'endDate'		},
	    							{	data:'startDate'	},
	    							{	data: 'endDate'		},
	    							{	defaultContent: "<button class='td-button btn-edit'>Edit</button>"    	},
	    							{	defaultContent: "<button class='td-button btn-delete'>Delete</button>" 	}
	    							]
						
	    					});
	    	   	 			
});

