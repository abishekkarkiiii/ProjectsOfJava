package backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//MysqlDatabase
		int userId=Integer.parseInt(request.getParameter("UserId"));
		   String password=request.getParameter("password");
           String checkquery="select * from UsernamePassword where UserId = ?";
           String name=request.getParameter("fullname");
           String email=request.getParameter("email");
           HttpSession session=request.getSession();
           session.setAttribute("UserId", userId);
           Connection conn= new Conn().conn();
           try {
               PreparedStatement stmt=conn.prepareStatement(checkquery);
               stmt.setInt(1, userId);
               ResultSet r=stmt.executeQuery();
               if(r.next()){
            	   RequestDispatcher re=request.getRequestDispatcher("/index.jsp");
            	   session.setAttribute("userexist", " user exist already ");
                   System.out.println("User exist");
                   re.forward(request, response);
               }else{
                   stmt=conn.prepareStatement("insert into UsernamePassword(UserId,Password,Email,Name)values(?,?,?,?)");
                   stmt.setInt(1, userId);
                   stmt.setString(2, password);
                   stmt.setString(3, email);
                   stmt.setString(4, name);
                   
                   if(stmt.executeUpdate()!=0)
                   {
                       System.out.println("account created sucessfully");
                       RequestDispatcher t=request.getRequestDispatcher("/Deposit.jsp");
                       t.forward(request, response);
                       RequestDispatcher te=request.getRequestDispatcher("/FirstAccount");
                       te.include(request, response);

                       
                   }else{
                       System.out.println("sorry cant created account");
                   }
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
	}

}
