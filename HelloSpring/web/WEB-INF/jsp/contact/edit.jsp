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
        <h1>Edit Contact</h1>
        <form:form method="post" action="/HelloSpring/contact/save" modelAttribute="contact">
            <label>First Name:</label>
            <form:input path="firstName" value="${contact.getFirstName()}"/><br/>
            <label>Last Name:</label>
            <form:input path="lastName" value="${contact.getLastName()}"/><br/>
            <label>Email:</label>
            <form:input path="email" value="${contact.getEmail()}"/><br/>
            <label>Phone:</label>
            <form:input path="phone" value="${contact.getPhone()}"/><br/>
            <form:hidden path="contactId" value="${contact.getContactId()}"/><br/>
            <input type="submit" value="Save"/> <a href="${pageContext.request.contextPath}/contact">Cancel</a>
            
        </form:form>
    </body>
</html>
