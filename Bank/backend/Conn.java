package backend;

import java.sql.Connection;
import java.sql.DriverManager;
public class Conn {
   
	     private Connection conn=null;
	     Connection conn(){
	         
	             try {
	                 Class.forName("com.mysql.cj.jdbc.Driver");
	                 System.out.println("sucessfull");
	                 conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bank", "root", "");
	             } catch (Exception e) {
	                 e.printStackTrace();
	             }
	         return conn; 
	     }
	     
	 

}
