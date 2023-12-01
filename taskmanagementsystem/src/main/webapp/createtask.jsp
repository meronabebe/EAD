<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Task Management System - Create Task</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <h1>Task Management System</h1>

        <form action="create-task" method="post">
            <label for="taskTitle">Task Title:</label>
            <input type="text" id="taskTitle" name="taskTitle" required>
            <br>
            <label for="taskDescription">Task Description:</label>
            <textarea id="taskDescription" name="taskDescription"></textarea>
            <br>
            <label for="dueDate">Due Date:</label>
            <input type="date" id="dueDate" name="dueDate" required>
            <br>
            <label for="priority">Priority:</label>
            <select id="priority" name="priority" required>
                <option value="Low">Low</option>
                <option value="Medium">Medium</option>
                <option value="High">High</option>
            </select>
            <br>
            <button type="submit">Create Task</button>
        </form>
    </div>
</body>
</html>
