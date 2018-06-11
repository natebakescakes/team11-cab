$(document).ready(function(){
	
	var u=window.contextRoot + '/json/showmember/jsonlist';
	
	$.getJSON(u, function(data) {         
	    alert(data);
	});
	
		var $table=$('#myTable');
		
		$table.DataTable(
				{
					ajax: {
						url: u,
						dataSrc: ''
					},
				
					columns: [
						{
							data: 'userId'
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
						}
						
					]
				});

});
