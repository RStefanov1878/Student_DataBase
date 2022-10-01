package table;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import sql.*;

public class EditStudent implements creatable {

	// initialization of global variable
	private  JFrame frame;
	private int number;
	private EditSQL editSQL;
	private JTextField nameText;
	private JTextField textEGN;
	private JTextField adressText;
	private String newName;
	private String egn;
	private String adress;
	private Student student;
	
	public EditStudent(int number) {
		this.number = number;
		frame = new JFrame();
		student = StudentList.getStudent(number);
	}
	@Override
	public void getFrame() {
		frame.setSize(300,300);  
		frame.getContentPane().setLayout(null);  
		frame.setResizable(false);
		
		newName = student.getName();
		egn = student.getEGN();
		adress = student.getAdress();
		
		nameText = (JTextField) createComponent("new name",10, 57, 100, 30, 10, 85, 200, 30);
		nameText.setText(newName);
		textEGN = (JTextField) createComponent("new EGN",10, 114, 100, 30, 10, 143, 200, 30);
		textEGN.setText(egn);
		adressText = (JTextField) createComponent("new adress",10, 176, 100, 30, 10, 205, 200, 30);
		adressText.setText(adress);
			
		JButton change = new JButton("Change");
		componentActionListener(change);
	
		frame.setVisible(true);   
		
	}
	@Override
	public Component createComponent(String name, int... bounds) {
		JLabel label = new JLabel(name);
		label.setBounds(bounds[0] ,bounds[1] ,bounds[2] ,bounds[3]);  
		JTextField textField = new JTextField();
		textField.setBounds(bounds[4] ,bounds[5] ,bounds[6] ,bounds[7]); 
		addComponents(this.frame,label,textField);
		return textField;
	}

	@Override
	public void addComponents(JFrame frame, Component... components) {
		for(Component componet : components) {
			frame.add(componet);
		}
	}

	@Override
	public void componentActionListener(JButton button) {  
		button.setSize(100, 25); 
		button.setLocation(159, 42);
		addComponents(this.frame,button);
		button.addActionListener(new ActionListener() {
			    public void actionPerformed(java.awt.event.ActionEvent e) {
			    	newName = nameText.getText().toString();
			    	egn = textEGN.getText().toString();
			    	adress = adressText.getText().toString();
			    	if(!(newName.isEmpty()) && !(egn.isEmpty()) && !(adress.isEmpty())) {
			    		StudentList.editStudent(number, newName, egn, adress);
			    		nameText.setText("");
			    		textEGN.setText("");
			    		adressText.setText("");
			    		editSQL = new  EditSQL(number, newName, egn, adress);
			    		editSQL.editSQL();
			    		Messange messenge = new Messange("OK");
			    	}
			    }});
	}
	@Override
	public boolean isFrameVisible() {
		boolean visible = frame.isVisible();
		return visible;
	}

}

