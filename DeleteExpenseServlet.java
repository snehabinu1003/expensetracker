import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DeleteExpenseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensetracker", "root", "password");
            PreparedStatement ps = con.prepareStatement("DELETE FROM expenses WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            response.sendRedirect("ViewExpensesServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

