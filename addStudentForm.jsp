<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Add New Student</h1>  
       <form:form method="post" action="save">    
        <table >    
         <tr>    
          <td>firstname : </td>   
          <td><form:input path="firstName"  /></td>  
         </tr>    
         <tr>    
          <td>lastname :</td>    
          <td><form:input path="lastName" /></td>  
         </tr>   
         <tr>    
          <td>email :</td>    
          <td><form:input path="email" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    