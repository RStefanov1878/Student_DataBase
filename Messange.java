package table;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Messange {

	private JFrame frame; 
	
	public Messange(String str) {
		frame = new JFrame(); 
		frame.setSize(300, 60);
	    frame.getContentPane().setLayout(null);
		JLabel label = new JLabel(str);
		label.setBounds(0, 0, 200, 20); 
		frame.add(label);
		frame.setVisible(true);
	}
	public Messange(int num) {
		frame = new JFrame(); 
		frame.setSize(300, 60);
	    frame.getContentPane().setLayout(null);
		JLabel label = new JLabel(String.valueOf(num));
		label.setBounds(0, 0, 200, 20); 
		frame.add(label);
		frame.setVisible(true);
	}
	

}
