<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Facility List page</h3>


	<div class="container">

		<div class="row" style="max-width:100%">
			<div class="centered" style="align:center; width:80%"  >

				<table id="myFacTable" style="width:100%" class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Facility ID</th>
							<th>Facility Name</th>
							<th>Facility Type</th>
							<th>Location</th>
							<th>Description</th> 
							<th></th>
							<th></th>
						</tr>

					</thead>
				</table>

			</div>

		</div>
	</div>


</body>
</html>