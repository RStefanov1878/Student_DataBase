package table;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import sql.*;

public class AddStudent implements creatable {

	private JFrame frame;
	private JTextField nameText;
	private JTextField textEGN;
	private JTextField adressText;
	private InSQL inSql;
	
	public  AddStudent() {
		frame = new JFrame();
	}
	
	@Override
	public void getFrame() {
		frame.setSize(300,300);  
		frame.getContentPane().setLayout(null);  
		frame.setResizable(false);
		
		nameText = (JTextField) createComponent("Name", 50, 11, 100, 30, 50, 35, 200, 30);
		textEGN = (JTextField) createComponent("EGN", 50, 72, 100, 30, 50, 94, 200, 30);
		adressText = (JTextField) createComponent("Adress", 50, 135, 100, 30, 50, 157, 200, 30);
		
		JButton creat =new JButton("Creat");  
		creat.setSize(100, 25); 
		creat.setLocation(98, 198);
		addComponents(this.frame,creat);
		componentActionListener(creat);
		 
		frame.setVisible(true); 
	}

	@Override
	public Component createComponent(String name, int... bounds) {
		JLabel label = new JLabel(name);
		label.setBounds(bounds[0], bounds[1], bounds[2] ,bounds[3]);  
		JTextField textField = new JTextField();
		textField.setBounds(bounds[4] ,bounds[5], bounds[6], bounds[7]);
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
		button.setLocation(98, 198);
		addComponents(this.frame,button);
		button.addActionListener(new ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent e) {
	    		String name = nameText.getText().toString();
	    		String egn = textEGN.getText().toString();
	    		String adress = adressText.getText().toString();
	    		if(!(name.isEmpty()) && !(egn.isEmpty()) && !(adress.isEmpty())) {
	    			StudentList.addStudent(name, egn, adress,true);
	    			nameText.setText("");
	    			textEGN.setText("");
	    			adressText.setText("");
	    			inSql = new InSQL(name,egn,adress);
	    			inSql.inSQL();
	    			Messange messange = new Messange("creat student");
	    		}
	    	}});
	}

	@Override
	public boolean isFrameVisible() {
		boolean visible = frame.isVisible();
		return visible;
	}

	
	


}
