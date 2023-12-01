<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="taskmanagementsystem.Task" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task Management System - Dashboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <h1>Task Management System</h1>

        <p>Welcome, <%= session.getAttribute("username") %>!</p>

        <a href="create-task.jsp">Create Task</a> |
        <a href="search-tasks.jsp">Search Tasks</a> |
        <a href="logout">Logout</a>

        <table>
            <thead>
                <tr>
                    <th>Task Title</th>
                    <th>Description</th>
                    <th>Due Date</th>
                    <th>Priority</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Task> tasks = (List<Task>) request.getAttribute("tasks");

                    if (tasks != null && !tasks.isEmpty()) {
                        for (Task task : tasks) {
                            String status = (task.isCompleted()) ? "Completed" : "Pending";
                            String dueDate = task.getDueDate().toString();
                            String priority = task.getPriority().toString();
                %>
                <tr>
                    <td><%= task.getTitle() %></td>
                    <td><%= task.getDescription() %></td>
                    <td><%= dueDate %></td>
                    <td><%= priority %></td>
                    <td><%= status %></td>
                    <td>
                        <a href="edit-task.jsp?id=<%= task.getId() %>">Edit</a> |
                        <a href="delete-task.jsp?id=<%= task.getId() %>">Delete</a> |
                        <a href="mark-completed.jsp?id=<%= task.getId() %>">
                            <% if (task.isCompleted()) { %>
                            Mark Pending
                            <% } else { %>
                            Mark Completed
                            <% } %>
                        </a>
                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="6">No tasks found.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
