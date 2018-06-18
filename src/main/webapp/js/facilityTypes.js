//var editor;
$(document).ready(function(){
	
	var v=window.contextRoot + '/json/showfacilitytypes';
//	
//	$.getJSON(u, function(data) {         
//	    alert(JSON.stringify(data));
//	});
	
	var token = $('#_csrf').attr('content');
	var header = $('#_csrf_header').attr('content');
	
	$.ajaxSetup({
		beforeSend: function(xhr) {
			xhr.setRequestHeader('X-CSRF-TOKEN', token);
		}
	})
	
	
		var $table=$('#facilityTypesTable');
		//editor= $table.Editor();
	
	var simple_checkbox=function(data,type,full, meta){
		var checked= (data==true)? "checked" : "";
		return '<input type="checkbox"  disabled="true" class="checkbox td-button" ' + checked + '/>';
	}
		
		var datatbl = $table.DataTable(
				{
					ajax: {
						url: v,
						dataSrc: ''
					},
					columns: [
						{
							data: 'typeId'
						},
						{
							data: 'typeName'
						},
						{
							data: 'description'
						},
						{
							defaultContent: "<button class='td-button btn-edit btn btn-table btn-primary'>Edit</button>"
						}
					]
					
				});
		

	//https://stackoverflow.com/questions/31327933/how-add-more-then-one-button-in-each-row-in-jquery-datatables-and-how-to-apply-e
	     $('#myFacTable tbody').on('click', '.btn-edit', function (e) {
	    	 var data = datatbl.row( $(this).parents('tr') ).data();
	    	 var counter = 0;
	         $($(this).parents('tr')).find("td").each(function(){
        		 counter++;
	        	 if(counter < 2){
	        		 return;
	        	 }
//	        	 if(this.hasClass("sorting_1")){
//	        		 return true;
//	        	 }
	        	 if ($(this).children().hasClass("checkbox"))
	        	 {
	        		( $(this).find("input")).prop("disabled",false);
	        		 
	        	 }
	        	 if (!$(this).children().hasClass("td-button"))
	        	    {
	        	        var text = $(this).text();
	        	        $(this).html ('<input type="text" value="' +  text + '">');
	        	    } 
	        	 if ($(this).children().hasClass("btn-edit"))
	        		 {
	        	       $(this).html ('<button class="td-button btn-save btn btn-table btn-primary">Submit</button>');
	        		 }
	        	   })
	      
	      } );
	     
	     $('#myFacTable tbody').on('click', '.btn-save', function (e) {
	    	 var parenttr = $(this).parents('tr');
	    	 var counter = 0;
	    	 $($(this).parents('tr')).find("td").each(function(){
//	    		 if(this.hasClass("sorting_1")){
//	        		 return true;
//	        	 }
        		 counter++;
	        	 if(counter < 2){
	        		 return;
	        	 }
	        	 
	        	 if ($(this).children().hasClass("checkbox"))
	        	 {
		        		( $(this).find("input")).prop("disabled",true);
		        		
		        		if ( ($(this).find("input")).prop('checked')==true)
		        		{
				        	 var cell = datatbl.cell( $(this) );
				        	 
				        	 cell.data(1).draw();
		   	        	}
		        		
		   	        	 else
		   	        	 {
			   	        	 var cell = datatbl.cell( $(this) );
			   	        	 cell.data(0).draw();
		   	        	 }
	        		
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
	        	        $(this).html ('<button class="td-button btn-edit btn btn-table btn-primary">Edit</button>')
	        		 } 
	        	 
	        	 
	        	});
	    	 
	         var facilitydata = datatbl.row( parenttr ).data();
//	         alert(JSON.stringify(facilitydata));
	         
	         $.ajax({
	             url: window.contextRoot + "/admin/facilities/update",
	             type: 'POST',
	             data: JSON.stringify(facilitydata),
	             contentType: "application/json",
	             cache: true,
	             success: function (data) {
//	            	 alert("You have successfully edited the facility!");
	            	 
	             }
	           });
	      	    
	      } );    
	         
	     $('#myFacTable tbody').on('click', '.btn-delete', function (e) {
	         var data = datatbl.row( $(this).parents('tr') ).data();
//	    	 alert(JSON.stringify(data));
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

