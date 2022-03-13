<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>
</head>
<body>
    <div align="center">
        <h2>User Registration</h2>
        <form:form action="/store" method="post">
            <form:label path="id">Full name:</form:label>
            <form:input path="id"/><br/>
             
            <form:label path="name">E-mail:</form:label>
            <form:input path="name"/><br/>
             
            <form:label path="age">Password:</form:label>
            <form:password path="age"/><br/>      
 
            
                 
            <input type="submit" value="Submit">
           </form:form>
    </div>
</body>
</html>