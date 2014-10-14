<%-- 
    Document   : index
    Created on : Oct 14, 2014, 12:34:38 AM
    Author     : forsell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Students</h1>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Action</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.getStudentId()}</td>
                    <td>${student.getFirstName()}</td>
                    <td>${student.getLastName()}</td>
                    <td><a href="student/edit/${student.getStudentId()}">Edit</a> | 
                        <a href="student/delete/${student.getStudentId()}" onclick="return confirm('Are you sure to delete ?')">Delete</a></td>
                </tr>
            </c:forEach>
                
        </table>
    </body>
</html>
