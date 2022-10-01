package table;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public abstract class CreateTable {
	
	protected JScrollPane scrollPane;
	protected JTable table;
	protected JFrame frame;
	protected String colum[] = {"ID","NAME","EGN","ADRESS"};
	protected Messange messange;
	
	protected CreateTable() {
		frame = new JFrame();
	}
	
	protected void createTable(String[] colums, Object[][] rows, int...bounds) {
		scrollPane = new JScrollPane();
	    table = new JTable(rows, colums);
	    scrollPane.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
	    table.addMouseListener(new MouseAdapter() {   
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    		int colum = 0;
	    		int row = table.getSelectedRow();
	    		try {
	    			String value = table.getModel().getValueAt(row, colum).toString();
		    		int i=Integer.parseInt(value); 
		    		functionInTable(i);
	    		}
	    		catch(Exception exception) {
	    			messange = new Messange("not a student");
	    		}
	    	}
	    });
	    scrollPane.setViewportView(table);
	    table.setFillsViewportHeight(true);
	    frame.getContentPane().add(scrollPane);
	}
	
	protected void closeTable() {
		frame.remove(scrollPane);
	}
	
	protected void functionInTable(int i) {}

	
	
	

}
