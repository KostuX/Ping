package gui;

import java.awt.*;
import javax.swing.*;

abstract
public class Gui extends JPanel{

	public Gui() {
		

		JFrame frame = new JFrame("FrameDemo");
		Container contentPane = frame.getContentPane();
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		this.setSize(200,200);
	
		frame.setVisible(true);
		
	}
	
	
}
