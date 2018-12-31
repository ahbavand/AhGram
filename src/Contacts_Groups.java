import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class Contacts_Groups extends JPanel implements ActionListener{
	MainFrame mainFrame;
	JButton[] jb;
	int counter=0;
	
	
	
	public Contacts_Groups(MainFrame mainFrame) {
		jb=new JButton[100];
		this.mainFrame=mainFrame;
//		setSize(200,500);
//		setLocation(600,50);
		setLayout(new GridBagLayout());
	    setBorder(LineBorder.createBlackLineBorder());
//		JButton jButton=new JButton("salam");
//		JButton jButton2=new JButton("this");
//		this.add(jButton);
//		this.add(jButton2);
//		jButton.addActionListener(this);
		create();
		
		
		
		
		
		setVisible(true);
		 
		
		
		
		
	}
	
	
	public void create(){
		DBCursor dbCursor=mainFrame.dataBase.friendgroup.find();
		int i=1;
		
		
	    while(dbCursor.hasNext()){
	    	
	    	DBObject s=dbCursor.next();
	    	String g=(String) s.get("username");
	    	
	//    	this.add(new JButton(g));
	    	jb[counter]=new JButton(g);
	    	this.add(jb[counter]);
	    	jb[counter].addActionListener(this);
	    	counter++;
	    	
	    	
	    	
	    	
	  //  	String pas=(String) s.get("password");
	    	
	    	i++;
	    }


		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JButton temp;
		for(int i=0;i<100;i++)
			if(arg0.getSource().equals(jb[i])){
				String tem=jb[i].getText();
			//	System.out.println(tem);
				mainFrame.chatPanel.sms1(tem);
				
				
			}
		
		
		// TODO Auto-generated method stub
		
		
	}
	
	
	
	
	
	

}
