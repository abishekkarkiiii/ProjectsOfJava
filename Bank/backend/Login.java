package backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bank", "root", "")) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM UsernamePassword WHERE UserId = ? AND password = ?");
            stmt.setInt(1, userId);
            stmt.setString(2, password);
            ResultSet r = stmt.executeQuery();
            if (r.next()) {
                session.setAttribute("id", userId);
                RequestDispatcher transfer = req.getRequestDispatcher("/Menuapp.jsp");
                transfer.forward(req, res);
            } else {
                RequestDispatcher transfer = req.getRequestDispatcher("/index.jsp");
                req.setAttribute("errorMessage", "Incorrect password");
                transfer.forward(req, res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
