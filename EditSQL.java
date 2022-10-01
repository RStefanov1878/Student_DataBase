package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EditSQL {
	
	private int number;
	private String name;
	private String EGN;
	private String adress;

	public EditSQL(int number,String name,String EGN,String adress)  {
		this.number = number;
		this.name = name;
		this.EGN = EGN;
		this.adress = adress;
	}
	
	public void editSQL() {
		try {
			
			Statement statement = SQL.openSQL().createStatement();
			String numberString = String.valueOf(number - 1);
			String sql1 = "update studentlist.student set name= " + "'" + name + "'" + "where id in(" + numberString +")";
			statement.executeUpdate(sql1);
			String sql2 = "update studentlist.student set EGN=" + "'" + EGN + "'" + "where id in(" + numberString +")";
			statement.executeUpdate(sql2);
			String sql3 = "update studentlist.student set adress= " + "'" + adress + "'" + "where id in(" + numberString +")";
			statement.executeUpdate(sql3);
			SQL.closeSQL();
			
			} catch (SQLException e) {
				e.printStackTrace();
			} 
	}
	
	

}