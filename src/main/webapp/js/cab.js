//var editor;
$(document).ready(function(){
	
	var u=window.contextRoot + '/json/showmember';
	
    var token = $('#_csrf').attr('content');
    var header = $('#_csrf_header').attr('content');
    
	$.ajaxSetup({
	    beforeSend: function(xhr) {
	        xhr.setRequestHeader('X-CSRF-TOKEN', token);
	    }
	});
	
	
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
							data: 'username'
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
		

	     $('#myTable tbody').on('click', '.btn-edit', function (e) {
	         var data = datatbl.row( $(this).parents('tr') ).data();
	    	 var counter = 0;
	         $($(this).parents('tr')).find("td").each(function(){
        		 counter++;
	        	 if(counter < 3){
	        		 return;
	        	 }
//	        	 if(this.hasClass("sorting_1")){
//	        		 return true;
//	        	 }
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
	     
	     $('#myTable tbody').on('click', '.btn-save', function (e) {
    		 var parenttr = $(this).parents('tr');
	    	 var counter = 0;
	    	 $($(this).parents('tr')).find("td").each(function(){
//	    		 if(this.hasClass("sorting_1")){
//	        		 return true;
//	        	 }
        		 counter++;
	        	 if(counter < 3){
	        		 return;
	        	 }
	        	 if (!$(this).children().hasClass("td-button"))
	        	    {
	        		 	var text = $(this).find("input").val();
	        		 	$(this).text(text);
	        		 	var cell = datatbl.cell( $(this) );
	        		 	cell.data( text ).draw();
	        	   
	        	    } 
	
		    	 
	        	 if ($(this).children().hasClass("btn-save"))
	        		 {
	        	        $(this).html ('<button class="td-button btn-edit">Edit</button>')
	        		 } 
	        	 
	        	 
	        	});
	    	 
	         var memberdata = datatbl.row( parenttr ).data();

	         
	         $.ajax({
	             url: window.contextRoot + "/admin/members/update",
	             type: "POST",
	             data: JSON.stringify(memberdata),
	             contentType: "application/json",
	             cache: true,
	             success: function (result) {
	            	 alert("Member has been updated");

	             }
	           });
	      	    
	      } );    
	         
	     $('#myTable tbody').on('click', '.btn-delete', function (e) {
	         var del = datatbl.row( $(this).parents('tr') ).data();
	         $.ajax({
	             url: window.contextRoot + "/admin/members/delete",
	             type: "POST",
	             data: JSON.stringify(del),
	             contentType: "application/json",
	             cache: true,
	             success: function (result) {
	            	 alert("Member has been deleted");
	    	         datatbl.ajax.reload();
	 
	             }
	         
	        
	           });
	         
	      } );	
	     
	     
	     
	     
//			$('.edit').each(function () {
//				$(this).on('click', function(evt){
//					$this = $(this);
//					var dtRow = $this.parents('tr');
//					if(confirm("Are you sure to delete this row?")){
////						var table = $('#example').DataTable();
////						table.row(dtRow[0].rowIndex-1).remove().draw( false );
//						alert('hi');
//					}
//				});
//			});
//		
//		$('#myTable tbody').on( 'click', function () {
//	        var data = table.row( $(this).parents('tr') ).data();
//	        alert( "Do you want to delete " + data[1] +" "+data[2]+" (Member ID: "+ data[ 0 ]+"?" );
//	    } );

});
