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



@WebServlet("/mark-task-completed")
public class MarkTaskCompletedServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));

  

        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskdb", "root", "baba11@");
            PreparedStatement statement = connection.prepareStatement("UPDATE tasks SET status = 'Completed' WHERE id = ?");
            statement.setInt(1, taskId);
            statement.executeUpdate();

            request.setAttribute("message", "Task marked as completed successfully.");
            request.setAttribute("taskId", taskId);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Failed to mark task as completed. Please try again.");
            request.setAttribute("taskId", taskId);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard");
            dispatcher.forward(request, response);
        }
    }
}
