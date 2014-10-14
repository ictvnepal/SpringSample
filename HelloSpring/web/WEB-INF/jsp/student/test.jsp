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
        <form method="post" action="student/edit/${student.getStudentId()}">
            <label>First Name:</label>
            <input type="text" path="firstName" value="${student.getFirstName()}"/><br/>
            <label>Last Name:</label>
            <input type="text" path="lastName" value="${student.getLastName()}"/><br/>
            <input type="hidden" path="studentId" value="${student.getStudentId()}"/><br/>
            <input type="submit" value="Save"/> <a href="${pageContext.request.contextPath}/student">Cancel</a>
            
        </form>
    </body>
</html>
