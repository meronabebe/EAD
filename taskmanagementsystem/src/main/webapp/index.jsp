<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Task Management System</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <h1>Task Management System</h1>

        <% 
        if (session.getAttribute("username") != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard");
            dispatcher.forward(request, response);
        } else {
            String message = (String) request.getAttribute("message");
            if (message == null) {
                message = "Please login or register to continue.";
            }
            %>
            <p><%= message %></p>
            <a href="login.jsp">Login</a> | <a href="register.jsp">Register</a>
        <% } %>
    </div>
</body>
</html>