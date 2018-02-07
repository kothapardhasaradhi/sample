<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<form>
	<table >    
         <tr>    
          	<td>Event Name:</td><td><form:input path="eventName"/></td>  
         </tr>    
         <tr>    
         	 <td>Location:</td>
			<td><form:select path="eventLocation">
         			<form:option value="none" label="---select---"/>
         			<form:option value="others" label="others"/>	
         			<form:option items="${eventList}"/>
         	</form:select>
         	 </td>  
         </tr>   
         <tr>    
          <td>Spekars:</td><td><form:input path="eventSpekars"/></td>  
         </tr>
		<tr>
          <td><input type="submit" value="${submit_value}"/></td>    
         </tr>    
     </table>    


</form>