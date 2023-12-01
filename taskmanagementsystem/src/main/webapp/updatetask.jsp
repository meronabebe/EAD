<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="taskmanagementsystem.Task" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task Management System - Update Task</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <h1>Task Management System</h1>

        <%
            List<Task> tasks = (List<Task>) request.getAttribute("tasks");
            Task task = tasks.get(0);
        %>

        <form action="update-task" method="post">
            <label for="taskId">Task ID:</label>
            <input type="number" id="taskId" name="taskId" value="<%= task.getId() %>" readonly>
            <br>
            <label for="taskTitle">Task Title:</label>
            <input type="text" id="taskTitle" name="taskTitle" value="<%= task.getTitle() %>" required>
            <br>
            <label for="taskDescription">Task Description:</label>
            <textarea id="taskDescription" name="taskDescription"><%= task.getDescription() %></textarea>
            <br>
            <label for="dueDate">Due Date:</label>
            <input type="date" id="dueDate" name="dueDate" value="<%= task.getDueDate() %>" required>
            <br>
            <label for="priority">Priority:</label>
            <select id="priority" name="priority" required>
                <option value="Low" <% if (task.getPriority().equals("Low")) { %>selected<% } %>>Low</option>
                <option value="Medium" <% if (task.getPriority().equals("Medium")) { %>selected<% } %>>Medium</option>
                <option value="High" <% if (task.getPriority().equals("High")) { %>selected<% } %>>High</option>
            </select>
            <br>
            <button type="submit">Update Task</button>
        </form>
    </div>
</body>
</html>
