
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="taskmanagementsystem.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
    <h1>User Profile</h1>

    <%
        // Get the user instance from session or elsewhere
        User user = (User) session.getAttribute("user");

        String username = user.getUsername();
        String password = user.getPassword();
    %>

    <form action="update-profile" method="POST">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="<%= username %>" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="<%= password %>" required><br><br>
        
        <button type="submit">Update Profile</button>
    </form>
</body>
</html>
