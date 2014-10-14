<%-- 
    Document   : edit
    Created on : Oct 14, 2014, 12:57:25 AM
    Author     : forsell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Student</h1>
        
            <label>First Name:</label>
            <input type="text" path="firstName" value="${contact.getFirstName()}"/><br/>
            <label>Last Name:</label>
            <input type="text" path="lastName" value="${contact.getLastName()}"/><br/>
            <label>Email:</label>
            <input type="text" path="email" value="${contact.getEmail()}"/><br/>
            <label>Phone:</label>
            <input type="text" path="phone" value="${contact.getPhone()}"/><br/>
            
            <a href="${pageContext.request.contextPath}/contact">Cancel</a>
            
        </form>
    </body>
</html>
