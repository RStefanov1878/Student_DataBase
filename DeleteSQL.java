package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteSQL {
	
	private int number;
	private String isDelete;
	
	public DeleteSQL(int number,String isDelete) {
		this.number = number;
		this.isDelete = isDelete;
	}
	
	public void deleteSQL() {
		
		try {
			String stringNumber = String.valueOf(number);
			Statement statement = SQL.openSQL().createStatement();
			String str = "update studentlist.student set deleted='" + isDelete + "' " + "where id in(" + stringNumber +")";
			statement.executeUpdate(str);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		SQL.closeSQL();
	}

}
