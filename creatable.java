package table;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;

public interface creatable {
	
	abstract void getFrame();
	abstract Component createComponent(String name, int...bounds);
	abstract void addComponents(JFrame frame, Component...components);
	abstract void componentActionListener(JButton button);
	abstract boolean isFrameVisible();

}
