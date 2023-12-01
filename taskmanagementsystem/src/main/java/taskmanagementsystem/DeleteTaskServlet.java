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



@WebServlet("/delete-task")
public class DeleteTaskServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));



        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskdb", "root", "baba11@");
            PreparedStatement statement = connection.prepareStatement("DELETE FROM tasks WHERE id = ?");
            statement.setInt(1, taskId);
            statement.executeUpdate();

            request.setAttribute("message", "Task deleted successfully.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Failed to delete task. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard");
            dispatcher.forward(request, response);
        }
    }
}
