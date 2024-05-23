package backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class FirstAccount
 */
@WebServlet("/FirstAccount")
public class FirstAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn=new Conn().conn();
			int Amount=Integer.parseInt(request.getParameter("initialDeposit"));
			  HttpSession session=request.getSession();
			int UserId=(int)session.getAttribute("UserId");
			try {
				PreparedStatement stmt=conn.prepareStatement("insert into Userdata (UserId,Amount)values(?,?)");
				stmt.setInt(1, UserId);
				stmt.setInt(2, Amount);
				if(stmt.executeUpdate()!=0)
				{
					session.invalidate();
					RequestDispatcher r=request.getRequestDispatcher("/index.jsp");
					r.forward(request, response);
				}else {
					System.out.println("sorry");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			e.printStackTrace();}
		
		
	}

}
