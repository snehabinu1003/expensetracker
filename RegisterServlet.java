import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensetracker", "root", "password");
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            int result = ps.executeUpdate();

            if (result > 0) {
                response.sendRedirect("login.jsp");
            } else {
                response.getWriter().println("Error occurred while registering. Try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
