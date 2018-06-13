//var editor;
$(document).ready(function(){
	
	var u=window.contextRoot + '/json/showmember/jsonlist';

		var $table=$('#myTable');
		//editor= $table.Editor();
		
		var datatbl = $table.DataTable(
				{
					ajax: {
						url: u,
						dataSrc: ''
					},
					columns: [
						{
							data: 'userid'
						},
						{
							data: 'firstName'
						},
						{
							data: 'lastName'
						},
						{
							data: 'email'
						},
						{
							data: 'address'
						},
						{
							data: 'phone'
						},
						{
							data: 'dob'
						},
						{
							defaultContent: "<button class='td-button btn-edit'>Edit</button>"
						},
						{
							defaultContent: "<button class='td-button btn-delete'>Delete</button>"
						}
					]
					
				});
		
    		var b=window.contextRoot + '/json/showmember/jsonbookinglist';
	    	var $bookingtable=$('#bTable');
	    //	var time = startDate.getHours() + ":" + startDate.getMinutes() + ":" + startDate.getSeconds();

	    	    	
	    	 			var datatbl1 = $bookingtable.DataTable(
	    					{
	    						ajax: {
	    							url: b,
	    							dataSrc: ''
	    						},
	    						columns: [
	    							{
	    								data: 'bookingId'
	    							},
	    							{
	    								data: 'facilityId'
	    							},
  									{
	    								data: 'startDate'
	    							},
	    							{
	    								data: 'endDate'
	    							},
	    							{
	    								data:'startDate'
	    							},
	    							{
	    								data: 'endDate'
	    							},
	    							{
	    								defaultContent: "<button class='td-button btn-edit'>Edit</button>" 							
	    							},
	    							{
	    								defaultContent: "<button class='td-button btn-delete'>Delete</button>"
	    							}
	    						]
	    						
	    					});
});
