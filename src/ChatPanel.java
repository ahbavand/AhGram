import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import org.json.simple.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ChatPanel extends JPanel implements KeyListener,Runnable{
	MainFrame mainFrame;
	
	int width,height;
	ImageIcon background;
	JLabel profile;
	JLabel loadprofile;
	JLabel moremassage;
	JLabel unfriend;
	JLabel privatechat;
	JLabel search;
	JLabel report;
	JTextField chatwrite;
	JTextArea ta;
	JScrollPane sc;
	Contacts_Groups contacts_Groups;
    JScrollPane cgsp;///contacts_group scrollpane
    String cg_username="";
    int conorgro;////////0=contact   1=gruop
	Client client;



	
	


	
	
	public ChatPanel(MainFrame mainFrame) {
	//	System.out.println("yes");
		this.mainFrame=mainFrame;
		background=new ImageIcon("profile_background.jpg");
		
		
		width=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		height=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		setSize((int)((width/2.2)),(int)(height/(1.6)));
		setLocation(0,0);
		
		
		
		ta = new JTextArea();
		sc = new JScrollPane(ta);
		sc.setSize(300, 360);
		sc.setLocation(170, 50);
		this.add(sc);


		
		
		
		
		
		profile=new JLabel("Profile");
		loadprofile=new JLabel("Load profile");
		moremassage=new JLabel("More massage");
		unfriend=new JLabel("Unfriend");
		privatechat=new JLabel("Private chat");
		search=new JLabel("search");
		report=new JLabel("report");
		specifylabel(profile, 20,70);
		specifylabel(loadprofile,20,130);
		specifylabel(moremassage,20,190);
		specifylabel(unfriend,20,250);
		specifylabel(privatechat,20,310);
		specifylabel(search,20,370);
		specifylabel(report,20,430);
		
		
		
		
		contacts_Groups=new Contacts_Groups(this.mainFrame);
	//	this.add(contacts_Groups);
		cgsp=new JScrollPane(contacts_Groups);
		cgsp.setSize(200,500);
		cgsp.setLocation(600,50);

		this.add(cgsp);
		
		
		
		 Font f = new Font("Dialog", Font.PLAIN, 23);
		 chatwrite=new JTextField();
		 chatwrite.setBackground(Color.LIGHT_GRAY);
		 chatwrite.setLocation(10,570);
		 chatwrite.setSize(600,60);
		 chatwrite.setFont(f);
		 this.add(chatwrite);
		 chatwrite.addKeyListener(this);


		
		
		
		
		 JLabel j1=new JLabel();
		 j1.setSize((int)((width/2.2)),(int)(height/(1.6)));
		 j1.setLocation(0,0);
		 j1.setIcon(background);
		 this.add(j1);
		 
		 

		
		
		setLayout(null);
		setVisible(true);
		new Thread(this).start();

	}    
	
	
	
	
	
	
	
	
	private void specifylabel(JLabel temp, int posx,int posy) {
		temp.setSize(150, 30);
		temp.setLocation(posx, posy);
		Font f = new Font("Dialog", Font.PLAIN, 21);
		temp.setFont(f);
		temp.setForeground(Color.lightGray);
		temp.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			} 
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getSource().equals(profile)){
					try {
						mainFrame.sms(1);
					//	System.out.println("salam");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}
				if(arg0.getSource().equals(loadprofile))
					try {
						DBCursor dbCursor=mainFrame.dataBase.friendgroup.find();
						int i=1;
						
						
						
						
						//System.out.println("hello");
							    while(dbCursor.hasNext()){
							   // 	System.out.println("salaa");
							    	
							    	DBObject t=dbCursor.next();
							    	String g=(String) t.get("type");
							    	String r=(String) t.get("username");
							    //	System.out.println(t.get("username"));
							    	if(g.equals("group")&&r.equals(cg_username))
							    		conorgro=1;
							    	if(g.equals("person")&&r.equals(cg_username)){
							    //		System.out.println("salam");
							    		conorgro=2;
							    		
							    	}
							    	i++;
							    }
							    
							   if(conorgro==2) 
							    mainFrame.sms(5);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(arg0.getSource().equals(search))
					try {
						mainFrame.sms(10);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(arg0.getSource().equals(report)){
					JSONObject jsonObject=new JSONObject();
					jsonObject.put("username",cg_username);
					String q=jsonObject.toString();
					String send="7"+q;
					
			    	PrintWriter pw=new PrintWriter(mainFrame.client.output);
			    	pw.println(send);
			    	pw.flush();

					
					
					
				}



				// TODO Auto-generated method stub
				
			}
		});
		this.add(temp);
	}








	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
			String s = chatwrite.getText();
			//System.out.println(s);
			s=s.trim();
		//	System.out.println(s);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("content",s);
		//	System.out.println(s+"text");
	//		jsonObject.put("sender",mainFrame.signUp.user_id);
			jsonObject.put("sender",mainFrame.username);

			jsonObject.put("reciever",cg_username);
			String q=jsonObject.toString();
		//	System.out.println(q);
			
			
			
			
			DBCursor dbCursor=mainFrame.dataBase.friendgroup.find();
			int i=1;
			
			
			
			
			//System.out.println("hello");
				    while(dbCursor.hasNext()){
				   // 	System.out.println("salaa");
				    	
				    	DBObject t=dbCursor.next();
				    	String g=(String) t.get("type");
				    	String r=(String) t.get("username");
				    //	System.out.println(t.get("username"));
				    	if(g.equals("group")&&r.equals(cg_username))
				    		conorgro=1;
				    	if(g.equals("person")&&r.equals(cg_username)){
				    //		System.out.println("salam");
				    		conorgro=2;
				    		
				    	}
				    	i++;
				    }
				    String send="1"+q;
				    if(conorgro==1)
				    	send="1"+q;
				    else if(conorgro==2)
				    	send="2"+q;

			//	    try {
				//    	System.out.println(send);
				    	
				    	PrintWriter pw=new PrintWriter(mainFrame.client.output);
				    	pw.println(send);
				    	pw.flush();
				    	
					//	mainFrame.client.output.write(send.getBytes());
				//	} catch (IOException e) {
				//		 TODO Auto-generated catch block
					//	e.printStackTrace();
				//	}
				    
			
			
			
			

			
			
	//		DBObject dbObject=new BasicDBObject().append("contents",s).append("sender",mainFrame.signUp.user_id).append("reciever",cg_username);///append
			DBObject dbObject=new BasicDBObject().append("content",s).append("sender",mainFrame.username).append("reciever",cg_username);
			mainFrame.dataBase.massages.insert(dbObject);
			
			
			
		}

		
		
		
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	public void sms1(String s){
		ta.setText("");
		cg_username=s;
		
		
		
		
		DBCursor dbCursor=mainFrame.dataBase.massages.find();
		int i=1;
		
		
	    while(dbCursor.hasNext()){
	    	
	    	DBObject v=dbCursor.next();
	    	String res=(String) v.get("reciever");
	    	String sen=(String) v.get("sender");
	    	String con=(String) v.get("content");
	    //	System.out.println(con+"shet");
	    	if( res.equals(cg_username)|| sen.equals(cg_username))
	    		ta.append(con+ "\n");
	    	
	    	i++;
	    }


		
		
	}








	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}








	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}








	@Override
	public void run() {
		
		while(true){
			
			
			ta.setText("");

			DBCursor dbCursor=mainFrame.dataBase.massages.find();
			int i=1;
			
			
		    while(dbCursor.hasNext()){
		    	
		    	DBObject v=dbCursor.next();
		    	String res=(String) v.get("reciever");
		    	String sen=(String) v.get("sender");
		    	String con=(String) v.get("content");
		    	if(res.equals(cg_username)|| sen.equals(cg_username))
		    		ta.append(con+ "\n");
		    	
		    	i++;
		    }
		    
		    try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
			
			
		}
		
		
		
		
		// TODO Auto-generated method stub
		
	}


}
