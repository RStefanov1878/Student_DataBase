package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import table.StudentList;

abstract class SQL {

	private static Connection connection;
	
	public static Connection openSQL() {
		   
	    	try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentlist","root","0000");  
				
				}
	    	catch(Exception e){
	    		System.out.println(e);
	    		}
	    	
			return connection;  
	    }
	   
	 public static void closeSQL() {
		 
			   try {
				   connection.close();
				} 
			   catch (SQLException e) {
				e.printStackTrace();
				}
			   
		   }
	    

}

