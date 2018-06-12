<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Function Room Booking</h3>
<table style="cellspacing: 2; cellpadding: 2; border: 1;">
<thead>
			
</thead>
		<tbody>
			<c:forEach var="type" items="${typeList}">		
			
			<tr class="listRecord">	
			
			<td height="100px" colspan="4"><a	href="${pageContext.request.contextPath}/booking"> ${type.typeName}</a> </td>
			   
			</tr>
			
	        <tr>
        	<c:forEach var="facility" items="${type.facilities}">
            <td><a	href="${pageContext.request.contextPath}/booking"> <img src="${pageContext.request.contextPath}/image/${facility.facilityType.typeId}.jpg"  
					width="100" height="100" alt="" align="middle"> </a>
					<br/>
                  ${facility.facilityName}  
           </td>		
             </c:forEach>           
        	</tr>
        	
			</c:forEach>
			
		</tbody>
	</table>