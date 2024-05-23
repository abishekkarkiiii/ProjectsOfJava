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
 * Servlet implementation class Menu
 */@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String check=request.getParameter("action");
		System.out.println(check);
		if(check.equals("deposit")) {
			
			deposit(request,response,new Conn().conn());
			
		}else if(check.equals("logout"))
		{
             logout( request,response,new Conn().conn());		
		}else if(check.equals("transfer"))
		{
			transfer(request, response, new Conn().conn());
		}else if(check.equals("showdata")) {
			showData(request, response, new Conn().conn());
		}
		
	}
	
	void deposit(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		
		 try {
			 
			 int amount=Integer.parseInt(request.getParameter("depositAmount"));
			  HttpSession session=request.getSession();
			  int id=(int) session.getAttribute("id");
			  System.out.println(id);
			 try {
                 int AlreadyExistingAmount=0;
                 PreparedStatement statement= conn.prepareStatement("select * from Userdata where UserId=?");
                 statement.setInt(1,id);
                 ResultSet r=statement.executeQuery();
                 while (r.next()) {
                     AlreadyExistingAmount+=r.getInt("Amount");
                 }
                 //input
                 System.out.println("enter a amount");
                 try {
                     PreparedStatement delStatement=conn.prepareStatement("delete from Userdata where UserId=?");
                     delStatement.setInt(1,(int)session.getAttribute("id"));
                     if(delStatement.executeUpdate()!=0)
                     {
                         System.out.println("deleted past value");
                     }
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
                 AlreadyExistingAmount+=amount;
                 session.setAttribute("TotalAmount", AlreadyExistingAmount);
                 statement=conn.prepareStatement("insert into Userdata(UserId,Amount)values(?,?)");
                 statement.setInt(1, id);
                 statement.setInt(2, AlreadyExistingAmount);
                 if(statement.executeUpdate()!=0)
                 {
                     System.out.println("sucessfull");
                     RequestDispatcher req=request.getRequestDispatcher("/Menuapp.jsp");
                     req.forward(request, response);
                        
                 }else{
                     System.out.println("can't inserted data");
                 }
                          
             } catch (Exception e) {
                 e.printStackTrace();
             }
            } catch (Exception e) {
             e.printStackTrace();
            }
		
	}
	
	void logout(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		try {
			 HttpSession session=request.getSession();
			 session.invalidate();
			 RequestDispatcher r= request.getRequestDispatcher("/index.jsp");
			 r.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	void transfer(HttpServletRequest request, HttpServletResponse response, Connection conn) {
          
		   
		   try {
			   
	            PreparedStatement statement=conn.prepareStatement("update Userdata set Amount = Amount + ? where UserId = ?");
	            PreparedStatement forMinus =conn.prepareStatement("update Userdata set Amount =Amount - ? where UserId = ?");
	            HttpSession session=request.getSession();
	            int tranferId=Integer.parseInt(request.getParameter("UserId"));
	            System.out.println(tranferId);
	            int userId=Integer.parseInt(session.getAttribute("id").toString());
	            int paisa=Integer.parseInt(request.getParameter("amount"));
	            statement.setInt(1, paisa);
	            forMinus.setInt(2, userId);
	            forMinus.setInt(1,paisa);
	            statement.setInt(2,tranferId);
	           conn.setAutoCommit(false);
	           System.out.println("enter 1 to cornfirm you are sending money to another account");
	           int check=Integer.parseInt(request.getParameter("cornfirm"));
	           System.out.println(check);
	           int moneycheck=statement.executeUpdate();
	           int moneycheck2=forMinus.executeUpdate();
	           //for debuging
	           System.out.println(moneycheck+"asd");
	           System.out.println(moneycheck2+"sad");
	           
	           if(check==1)
	           {
	            if(moneycheck!=0&&moneycheck2!=0){
	            	statement=conn.prepareStatement("select * from Userdata where UserId = ?");
	            	statement.setInt(1,userId);
	            	ResultSet r=statement.executeQuery();
	            	int totalUserAmount=0;
	            	while(r.next())
	            	{
	            		totalUserAmount+=r.getInt("Amount");
	            	}
	            	if(totalUserAmount<0)
	            	{
	            		session.setAttribute("tranfermessage", "Insufficent Balance");
	            		RequestDispatcher rd=request.getRequestDispatcher("/Menuapp.jsp");
	            		conn.rollback();
		                rd.forward(request, response);
	            	
	            		
	            	}else {
	            		conn.commit();
		                System.out.println("sucessfull transfer");
		                session.setAttribute("tranfermessage", "Sucessfully transfered to Id Number:"+tranferId);
		                RequestDispatcher rd=request.getRequestDispatcher("/Menuapp.jsp");
		                rd.forward(request, response);
	            	}
	                
	            }else{
	            	session.setAttribute("tranfermessage", "Sorry Something Went Wrong");
            		RequestDispatcher rd=request.getRequestDispatcher("/Menuapp.jsp");
            		conn.rollback();
	                rd.forward(request, response);
	            }
	           }else{
	            System.out.println("process cancel");
	           }
	            
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
   
    }
	
	
	void showData(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		 try {
			 System.out.println("showsdasad");
	            PreparedStatement statement =conn.prepareStatement("select Amount from Userdata where UserId = ? ");
	            HttpSession session=request.getSession();
	            int UserId=(int)session.getAttribute("id");
	            System.out.println(UserId);
	            statement.setInt(1,UserId);
	            
	            ResultSet r1=statement.executeQuery();
	            int Amount=0;
	            String name;
	            String email;
	            if(r1.next())
	            {
	                Amount=r1.getInt("Amount");
	            }
	            System.out.println(Amount+"save");
	            statement=conn.prepareStatement("SELECT Email, Name FROM UsernamePassword WHERE UserId = ?");
	            statement.setInt(1, UserId);
	            r1=statement.executeQuery();
	            if(r1.next())
	            {
	                name=r1.getString("Name");
	                email=r1.getString("Email");
	                System.out.println(name);
	                System.out.println(email);
	                session.setAttribute("name", name);
	                session.setAttribute("email", email);
	                session.setAttribute("amount",Amount);
	                RequestDispatcher rd=request.getRequestDispatcher("/UserDetails.jsp");
	                rd.include(request, response);
	                
	            }else{
	                System.out.println("cant fetch data");
	            }
	        } catch (Exception e) {
	           System.out.println(e.getMessage());
	        }
	}
	
 }
