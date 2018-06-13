<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="utf-8" >
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport" content= "width=device-width,initial-scale=1" >
<title>Facility Page</title>

<link href="../../css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="../../js/jquery-1.11.0.min.js"></script>

<script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<div class="table-responsive">
<h3>Function Room Booking</h3>
<table  class="table table-hover" style="cellspacing: 5; cellpadding: 2; border: 1;">
<thead>
			
</thead>
		<tbody>
		 
			<c:forEach var="type" items="${typeList}">		
			
			<tr class="listRecord">	
			
			<td height="50px" valign="middle" colspan="4"><a href="${pageContext.request.contextPath}/booking"> ${type.typeName}</a> </td>
			   
			</tr>
	     
	        <tr>	      
        	<c:forEach var="facility" items="${type.facilities}">
            <td> <a href="${pageContext.request.contextPath}/booking"> <img src="${pageContext.request.contextPath}/image/${facility.facilityType.typeId}.jpg" 
            width="100" height="100" alt="" align="middle"> </a>
					<br/>
                  ${facility.facilityName}  
           </td>		
             </c:forEach>           
        	</tr>
        	
			</c:forEach>
			
		</tbody>
	</table>
	</div>
	</body>
	
	</html>