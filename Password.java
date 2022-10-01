package table;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import sql.*;

public class Password implements creatable{
	private static JFrame frame;
	private JPasswordField newPassword;
	private JPasswordField oldPassword;
	private JPasswordField confirmPassword;
	private PasswordSQL passwordSQL;

	public Password() {
		frame = new JFrame();
	}
	@Override
	public void getFrame() {
		frame.setSize(299,264);  
	    frame.getContentPane().setLayout(null);
	    frame.setResizable(false);
	    
	    newPassword = (JPasswordField) createComponent("new password",20, 75, 117, 20, 20, 94, 142, 20);
	    confirmPassword = (JPasswordField) createComponent("confirm new password",20, 119, 117, 20, 20, 140, 142, 20);
	    oldPassword = (JPasswordField) createComponent("old password",20, 23, 117, 20, 20, 44, 142, 20);
	    
	    JButton change = new JButton("Change");
	    componentActionListener(change);
	    
	    frame.setVisible(true); 
	}
	@Override
	public Component createComponent(String name, int... bounds) {
		JLabel label = new JLabel(name);
		label.setBounds(bounds[0], bounds[1], bounds[2] ,bounds[3]);
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(bounds[4], bounds[5], bounds[6] ,bounds[7]);
		addComponents(this.frame,label,passwordField);
		return passwordField;
	}
	@Override
	public void addComponents(JFrame frame, Component... components) {
		for(Component componet : components) {
			frame.add(componet);
		}
	}
	@Override
	public void componentActionListener(JButton button) {
		button.setBounds(89, 174, 89, 23);
		addComponents(this.frame,button);
		button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		Messange messange;
	    		passwordSQL = new PasswordSQL();
	    		String pass1 = newPassword.getText().toString();
	    		String pass2 = confirmPassword.getText().toString();
	    		String pass3 = oldPassword.getText().toString();
	    		if(!(pass1.isEmpty()) && !(pass2.isEmpty()) && pass1.equals(pass2) && pass3.equals(passwordSQL.getPassword())) {
	    			passwordSQL.setPassword(pass1);
					messange = new Messange("chaged successful");
	    			newPassword.setText("");
	    			confirmPassword.setText("");
	    			confirmPassword.setText("");
	    		} 
	    		else 
	    		{
	    			messange = new Messange("something wrong");
	    		}
	    	}
	    });
	}
	@Override
	public boolean isFrameVisible() {
		boolean visible = frame.isVisible();
		return visible;
	}
	
}
