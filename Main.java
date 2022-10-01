package table;
import sql.*;

public class Main {

	public static void main(String[] args) {
		FromSQL fromSQL = new FromSQL();
		fromSQL.getData();
		StudentTable st = new StudentTable();
		st.getFrame();
		
		
	}

}
