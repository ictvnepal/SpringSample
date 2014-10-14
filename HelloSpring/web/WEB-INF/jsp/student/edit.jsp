<%-- 
    Document   : edit
    Created on : Oct 14, 2014, 12:57:25 AM
    Author     : forsell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Student</h1>
        <form:form method="post" action="/HelloSpring/student/save" modelAttribute="student">
            <label>First Name:</label>
            <form:input path="firstName" value="${student.getFirstName()}"/><br/>
            <label>Last Name:</label>
            <form:input path="lastName" value="${student.getLastName()}"/><br/>
            <form:hidden path="studentId" value="${student.getStudentId()}"/><br/>
            <input type="submit" value="Save"/> <a href="${pageContext.request.contextPath}/student">Cancel</a>
            
        </form:form>
    </body>
</html>
