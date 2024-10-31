import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ViewExpensesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensetracker", "root", "password");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM expenses WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            response.setContentType("text/html");
            response.getWriter().println("<h2>Your Recent Expenses</h2>");
            while(rs.next()) {
                int expenseId = rs.getInt("id");
                response.getWriter().println("Amount: " + rs.getString("amount") +
                    ", Date: " + rs.getString("date") + 
                    ", Category: " + rs.getString("category") +
                    " <a href='DeleteExpenseServlet?id=" + expenseId + "'>Delete</a><br>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
