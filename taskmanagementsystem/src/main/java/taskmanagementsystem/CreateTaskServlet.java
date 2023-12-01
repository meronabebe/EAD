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

@WebServlet("/create-task")
public class CreateTaskServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskTitle = request.getParameter("taskTitle");
        String taskDescription = request.getParameter("taskDescription");
        String dueDate = request.getParameter("dueDate");
        String priority = request.getParameter("priority");

       
        

        try {
          
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskdb", "root", "baba11@");
       
            PreparedStatement statement = connection.prepareStatement("INSERT INTO tasks (task_title, task_description, due_date, priority) VALUES (?, ?, ?, ?)");
            statement.setString(1, taskTitle);
            statement.setString(2, taskDescription);
            statement.setString(3, dueDate);
            statement.setString(4, priority);
            statement.executeUpdate();

            request.setAttribute("message", "Task created successfully.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Failed to create task. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/createtask.jsp");
            dispatcher.forward(request, response);
        }
    }
}
