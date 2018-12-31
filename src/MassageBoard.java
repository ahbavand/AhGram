import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class MassageBoard{
	
	
	public MassageBoard() {
		
		JFrame frame = new JFrame();
		frame.setSize(1000,1000);

		JPanel panel = new JPanel();
		panel.setSize(400,400);
		panel.setBackground(Color.red);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));	
		
		for(int i = 0; i < 20; i++) {
		panel.add(new JButton("Button " + i));
		
		}
		 
		frame.add(new JScrollPane(panel));
		frame.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		MassageBoard massageBoard=new MassageBoard();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
