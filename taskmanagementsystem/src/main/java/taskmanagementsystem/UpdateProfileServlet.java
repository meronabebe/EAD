package taskmanagementsystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update-profile")
public class UpdateProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");



        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskdb", "root", "baba11@");
            PreparedStatement statement = connection.prepareStatement("SELECT password FROM users WHERE username = ?");
            statement.setString(1, request.getParameter("username"));

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                if (!storedPassword.equals(oldPassword)) {
                    request.setAttribute("error", "Invalid old password. Please enter the correct password.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/update-profile.jsp");
                    dispatcher.forward(request, response);
                } else if (!newPassword.equals(confirmPassword)) {
                    request.setAttribute("error", "New password and confirm password do not match. Please enter the same password for both fields.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/update-profile.jsp");
                    dispatcher.forward(request, response);
                } else {
                    PreparedStatement updateStatement = connection.prepareStatement("UPDATE users SET password = ? WHERE username = ?");
                    updateStatement.setString(1, newPassword); // Store password as it is
                    updateStatement.setString(2, request.getParameter("username"));
                    updateStatement.executeUpdate();

                    request.setAttribute("message", "Profile updated successfully.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                request.setAttribute("error", "User not found. Please register first.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Failed to update profile. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/update-profile.jsp");
            dispatcher.forward(request, response);
        }
    }
}
