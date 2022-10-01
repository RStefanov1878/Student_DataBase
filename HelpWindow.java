package table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class HelpWindow {
	
	private JFrame frame;

	public HelpWindow() {
		frame = new JFrame();
	}
	
	public void getFrame() {
		File file = null;
		BufferedReader input = null;
		JTextArea tarea = null;
		try {
			file = new File("Help.txt");
			input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			tarea = new JTextArea(10, 10);
			tarea.setBackground(Color.LIGHT_GRAY);
			tarea.read(input, "READING FILE :-)");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		frame.getContentPane().add(tarea, BorderLayout.CENTER);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setSize(680,300);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

}
