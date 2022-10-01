package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PasswordSQL {

	public String getPassword()  {
		
		String passwordSQL = null;
		try {
			Statement stmt = SQL.openSQL().createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM studentlist.password");  
			while(rs.next())  
			{
				passwordSQL = rs.getString(2);
			}	
			SQL.closeSQL();
			
		} catch (SQLException e) {
				e.printStackTrace();
			}  
		return passwordSQL;
	}
	
	public void  setPassword(String password)  {
		
		try {
			Statement stmt = SQL.openSQL().createStatement();
			String str = "update studentlist.password set pass=" + "'" + password + "'" + "where idpassword in(1)";;
			stmt.executeUpdate(str);
			SQL.closeSQL();
				
		} catch (SQLException e) {
				e.printStackTrace();
			} 
			
	}
	
	
	

}

