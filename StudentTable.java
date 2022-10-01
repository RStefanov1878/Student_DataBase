package table;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.sun.javafx.geom.Rectangle;

import sql.*;

public class StudentTable extends CreateTable  {

	
	private boolean isButtonDeletedCheck = true;
	private boolean isButtonEditCheck = true;
	
	private DeleteSQL deleteSQL;
	private PasswordSQL passwordSQL;
	private AddStudent addStudent;
	private EditStudent editStudent;
	private Password password;
	private PasswordTable passwordTable;
	private HelpWindow helpWindow;
	private Object rows[][];
	
	private static final int X = 10;
	private static final int Y = 51;
	private static final int WIDTH = 564;
	private static final int HEIGHT = 237;
	
	
	public StudentTable() {
		super();
		rows = StudentList.list(false);
		addStudent = new AddStudent();
		password = new Password();
	}
	
	public void getFrame() {
		
		frame.setSize(600,340);  
	    frame.getContentPane().setLayout(null);
	    createTable(colum, rows, X, Y, WIDTH, HEIGHT);
	    frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				closeTable();
	    		frame.getContentPane().invalidate();
	    		frame.getContentPane().validate();
	    		frame.getContentPane().repaint();
	    		rows = StudentList.list(false);
	    		createTable(colum, rows, X, Y, WIDTH, HEIGHT);
		}});
		
	    JButton btnNewButton_2 = new JButton("Add new student");
	    btnNewButton_2.setBounds(0, 0, 123, 23);
	    frame.getContentPane().add(btnNewButton_2);
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent e) {
	    		if(addStudent.isFrameVisible() == false) {
	    			addStudent = new AddStudent();
	    			addStudent.getFrame();
	    }}});
	    
	    JButton btnNewButton_3 = new JButton("Remove student");
	    btnNewButton_3.setBounds(0, 22, 123, 23);
	    frame.getContentPane().add(btnNewButton_3);
	     btnNewButton_3.addActionListener(new ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent e) {
	    		if(isButtonDeletedCheck == true && isButtonEditCheck == true) {
	    			isButtonDeletedCheck = false;
	    			btnNewButton_3.setForeground(Color.RED);
	    		}else {
	    			isButtonDeletedCheck = true;
	    			btnNewButton_3.setForeground(Color.BLACK);
	    		}
	    	}});
	     
	    JButton btnNewButton_4 = new JButton("Edit student info.");
	    btnNewButton_4.setBounds(123, 0, 123, 23);
	    frame.getContentPane().add(btnNewButton_4);
	    btnNewButton_4.addActionListener(new ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent e) {
	    		if(isButtonEditCheck == true && isButtonDeletedCheck == true) {
	    			isButtonEditCheck = false;
	    			btnNewButton_4.setForeground(Color.GREEN);
	    		}else {
	    			isButtonEditCheck = true;
	    			btnNewButton_4.setForeground(Color.BLACK);
	    		}
	    	}});
	    
	    JButton btnNewButton_5 = new JButton(" help ");
	    btnNewButton_5.setBounds(123, 22, 123, 23);
	    frame.getContentPane().add(btnNewButton_5);
	     btnNewButton_5.addActionListener(new ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent e) {
	    		helpWindow = new HelpWindow();
	    		helpWindow.getFrame();                          
	    }});

	    JButton btnNewButton_6 = new JButton("change pass.");
	    btnNewButton_6.setBounds(246, 22, 114, 23);
	    frame.getContentPane().add(btnNewButton_6);
	     btnNewButton_6.addActionListener(new ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent e) {
	    		password.getFrame();
	    	}});
	     
	    JLabel lblNewLabel =  new JLabel("Must password");
	    lblNewLabel.setBounds(370, 4, 86, 14);
	    frame.getContentPane().add(lblNewLabel);
	    
	    JPasswordField passwordField = new JPasswordField();
	    passwordField.setBounds(449, 1, 125, 20);
	    frame.getContentPane().add(passwordField);
	    
	    JButton btnNewButton_7 = new JButton("restore student");
	    btnNewButton_7.setBounds(246, 0, 114, 23);
	    frame.getContentPane().add(btnNewButton_7);
	    btnNewButton_7.addActionListener(new ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent e) {
	    		String pass =  passwordField.getText().toString();
	    		passwordSQL = new PasswordSQL();
	    		if(pass.equals(passwordSQL.getPassword())) {
	    			passwordTable = new PasswordTable();	
	    			passwordTable.getFrame();
	    	}}});
	    
	    frame.setVisible(true);
	}

	@Override
	public void functionInTable(int i) {
		System.out.print(i);
		if(isButtonDeletedCheck == false && isButtonEditCheck == true) {
			messange = new Messange(StudentList.getStudent(i).getName() + " is deleted");
			StudentList.getStudent(i).setDeleted(false);
			deleteSQL = new DeleteSQL(i - 1,"0");
			deleteSQL.deleteSQL();
		}
		if(isButtonDeletedCheck == true && isButtonEditCheck == false) {
			editStudent = new EditStudent(i);
			editStudent.getFrame();
		}
	}
}



