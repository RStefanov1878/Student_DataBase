package table;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import sql.*;

public class PasswordTable extends CreateTable {
	
	private DeleteSQL deleteSQL;
	private Object rows[][];
	
	private static final int X = 10;
	private static final int Y = 11;
	private static final int WIDTH = 564;
	private static final int HEIGHT = 237;
	
	public PasswordTable() {
		super();
		rows = StudentList.list(true);
	}
	public void getFrame() {
		frame.setSize(600,297);  
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		createTable(colum, rows, X, Y, WIDTH, HEIGHT);
		frame.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				closeTable();
	    		frame.getContentPane().invalidate();
	    		frame.getContentPane().validate();
	    		frame.getContentPane().repaint();
	    		rows = StudentList.list(true);
	    		createTable(colum, rows, X, Y, WIDTH, HEIGHT);
		}});
		frame.setVisible(true); 
	}
	
	@Override
	public void functionInTable(int i) {
		if(i > 0) {
			StudentList.getStudent(i).setDeleted(true);
			deleteSQL = new DeleteSQL(i - 1,"1");
			deleteSQL.deleteSQL();
			messange = new Messange("Recover");
		}
	}
	

}
