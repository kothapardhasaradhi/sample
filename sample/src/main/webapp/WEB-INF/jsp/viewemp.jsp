<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Name</th><th>Email-Id</th>
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
   <td>${emp.email}</td>
   <td><a href="edit/${emp.id}">edit</a></td>
   <td><a href="delete/${emp.id}">Delete</a></td>
   <tr>
     
   </c:forEach>  
   </table>  
   <br/>  
   <a href="empform">Add New Employee</a> 