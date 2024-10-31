import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddExpenseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String date = request.getParameter("date");
        String category = request.getParameter("category");

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensetracker", "root", "password");
            PreparedStatement ps = con.prepareStatement("INSERT INTO expenses (username, amount, date, category) VALUES (?, ?, ?, ?)");
            ps.setString(1, username);
            ps.setDouble(2, amount);
            ps.setString(3, date);
            ps.setString(4, category);
            ps.executeUpdate();

            response.sendRedirect("home.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

