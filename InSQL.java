package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import table.StudentList;


public class InSQL {

	public static int size;
	private String name;
	private String EGN;
	private String adress;
	
	public InSQL(String name,String EGN, String adress) {
		this.name = name;
		this.EGN = EGN;
		this.adress = adress;
	}
	public void inSQL() {
		size = StudentList.getSize();
		String sql = "insert into studentlist.student values (?,?,?,?,?)";
		PreparedStatement preparedStatement;
			try {
				preparedStatement = SQL.openSQL().prepareStatement(sql);
				preparedStatement.setLong(1, size);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, EGN);
				preparedStatement.setString(4, adress);
				preparedStatement.setInt(5, 1);
				preparedStatement.executeUpdate();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				}
		SQL.closeSQL();		
	}

}
