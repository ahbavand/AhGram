import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Search_resault extends JPanel implements ActionListener {
	MainFrame mainFrame;
	JButton[] jb;
	int counter=0;

	
	
	
	public Search_resault(MainFrame mainFrame,String user) {
		this.mainFrame=mainFrame;
		jb=new JButton[100];
		this.mainFrame=mainFrame;
		setLayout(null);
		setSize(330,300);
		setLocation(200,200);
	//	setLayout(new GridBagLayout());
	//    setBorder(LineBorder.createBlackLineBorder());
	    System.out.println("no");
	    if(!user.equals("")){
	    	System.out.println("yes");
	    JButton jButton=new JButton(user);
	    jButton.setSize(100,100);
	    jButton.setLocation(50,50);
	    this.add(jButton);
	    
	    
	    }

	    
	    setVisible(true);


		
		
		
		
		
	}
	
	
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
