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
/**
 * Servlet implementation class Delete
 */
@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn= new Conn().conn();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String CheckPassword=request.getParameter("password");
			HttpSession session= request.getSession();
			System.out.println(CheckPassword);
			int id=(int)session.getAttribute("id");
		    try {
		    	PreparedStatement stmti=conn.prepareStatement("delete from Userdata where  UserId = ? ");
                stmti.setInt(1, id);
                try {
                	  if(session!=null){
                PreparedStatement 	 stmt=conn.prepareStatement("delete from UsernamePassword where  UserId = ? and password=?");
                      	stmt.setInt(1, id);
                      	stmt.setString(2, CheckPassword);
                         conn.setAutoCommit(false);
                      	if(stmti.executeUpdate()!=0)
                      	{
                      		System.out.println("enter in first");
                      		if(stmt.executeUpdate()!=0)
                      		{
                      			session.invalidate();
                          		RequestDispatcher req=request.getRequestDispatcher("/index.jsp");
                                 req.forward(request, response);
                                 conn.commit();
                      		}else {
                      			conn.rollback();
                      			System.out.println("cant delete");
                      			RequestDispatcher req=request.getRequestDispatcher("/Menuapp.jsp");
                                req.forward(request, response);
                      		}
                      	
                      	}else {
                      		RequestDispatcher req=request.getRequestDispatcher("/Menuapp.jsp");
                             req.forward(request, response);
                      	}
                      	
                     }
				} catch (Exception e) {
				     e.printStackTrace();
					System.out.println("amount is empty");
				}
               
              
            } catch (Exception e) {
                e.printStackTrace();
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
