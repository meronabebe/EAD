package taskmanagementsystem;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/update-task")
public class UpdateTaskServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        String taskTitle = request.getParameter("taskTitle");
        String taskDescription = request.getParameter("taskDescription");
        String dueDate = request.getParameter("dueDate");
        String priority = request.getParameter("priority");

 

        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskdb", "root", "baba11@");
            PreparedStatement statement = connection.prepareStatement("UPDATE tasks SET task_title = ?, task_description = ?, due_date = ?, priority = ? WHERE id = ?");
            statement.setString(1, taskTitle);
            statement.setString(2, taskDescription);
            statement.setString(3, dueDate);
            statement.setString(4, priority);
            statement.setInt(5, taskId);
            statement.executeUpdate();

            request.setAttribute("message", "Task updated successfully.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Failed to update task. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/update-task.jsp");
            dispatcher.forward(request, response);
        }
    }
}
