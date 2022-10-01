package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import table.StudentList;



public class FromSQL{

	private String name;
	private String EGN;
	private String adress;
	private boolean isDelete;
	private Statement statement;
	private ResultSet resultSet;
	    
	public FromSQL()  {
		try {
			statement = SQL.openSQL().createStatement();
			resultSet = statement.executeQuery("SELECT * FROM studentlist.student");  
			}
		catch (SQLException e) {
			e.printStackTrace();
		}  
			 
	}
		
	public void getData() {
		
		try {
			while(resultSet.next())  
			{
				name = resultSet.getString(2);
				EGN = resultSet.getString(3);
				adress = resultSet.getString(4);
				isDelete = resultSet.getBoolean(5);
				StudentList.addStudent(name, EGN, adress, isDelete);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}  
				SQL.closeSQL();
	}
	
}

