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
        <h1>Contacts</h1>
        <a href="contact/add">Add Contact</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Action</th>
            </tr>
            <c:forEach var="contact" items="${contacts}">
                <tr>
                    <td>${contact.getContactId()}</td>
                    <td>${contact.getFirstName()}</td>
                    <td>${contact.getLastName()}</td>
                    <td>${contact.getEmail()}</td>
                    <td>${contact.getPhone()}</td>
                    <td><a href="contact/edit/${contact.getContactId()}">Edit</a> | 
                        <a href="contact/delete/${contact.getContactId()}" onclick="return confirm('Are you sure to delete ?')">Delete</a></td>
                </tr>
            </c:forEach>
                
        </table>
    </body>
</html>
