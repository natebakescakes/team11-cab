$(document).ready(function(){
	
	var u=window.contextRoot + '/json/showmember/jsonlist';
//	
//	$.getJSON(u, function(data) {         
//	    alert(JSON.stringify(data));
//	});
	
	
		var $table=$('#myTable');
		//var editor = $table.Editor();
		
		$table.DataTable(
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
							defaultContent: "<button>Edit</button>"
						},
						{
							defaultContent: "<button>Delete</button>"
						}
					]
					
				});
		
//		 $('#table').on( 'click', 'button', function (e) {
//		        editor.inline( this );
//		    });
	
		
		
//		
//		$('#myTable tbody').on( 'click', function () {
//	        var data = table.row( $(this).parents('tr') ).data();
//	        alert( "Do you want to delete " + data[1] +" "+data[2]+" (Member ID: "+ data[ 0 ]+"?" );
//	    } );

});
