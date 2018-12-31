import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.html.ListView;

import org.json.simple.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class SearchPanel extends JPanel implements Runnable ,ActionListener{
	int width,height;
	MainFrame mainFrame;
	BufferedImage buttonicon;
	ImageIcon background;
	JLabel backbutton;
	JLabel namesearch,hashsearch;
	JTextField textname,texthash;
	JScrollPane sc;
	Search_resault search_resault;
//	JList<String>jList;
	
	final DefaultListModel model = new DefaultListModel();
	final JList list = new JList(model);

	JButton addcontact;


	



	
	
	
	
	public SearchPanel(MainFrame mainFrame) throws IOException {
		this.mainFrame=mainFrame;
		buttonicon=ImageIO.read(new File("backicon.png"));
		background=new ImageIcon("profile_background.jpg");
		width=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		height=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		setSize((int)((width/2.2)),(int)(height/(1.6)));
		setLocation(0,0);
		
		
		
		
		 
	//	search_resault=new Search_resault(mainFrame,"");
		
	//	jList=new JList<>();
		
		
		
		
		
	//	this.add(search_resault);
		
		sc = new JScrollPane(list);
		sc.setSize(330,330);
		sc.setLocation(200, 200);
		this.add(sc);
		model.addElement("ssdcf");
		
		
		addcontact=new JButton("add contact");
		addcontact.setLocation(50,500);
		addcontact.setSize(150,70);
		addcontact.addActionListener(this);
		this.add(addcontact);

		
		
		
		
		backbutton=new JLabel(new ImageIcon(buttonicon));
		
		backbutton.setBorder(BorderFactory.createEmptyBorder());
		backbutton.setLocation(50,50);
		backbutton.setSize(120, 70);
		backbutton.addMouseListener(new MouseListener() {
			
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
				System.out.println("salam");
				try {
					mainFrame.sms(9);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Auto-generated method stub
				
			}
		});
		this.add(backbutton);
		
		
		

		
		
		
		setLayout(null);
		setVisible(true);

		
		
		
		
		namesearch=new JLabel("serach user");
		hashsearch=new JLabel("search hashtag");
		specifylabel(namesearch, 200,70);
		specifylabel(hashsearch, 200,150);

		textname=new JTextField();
		texthash=new JTextField();
		
		specifytextfield(textname, 460,70);
		specifytextfield(texthash, 460,150);

		
		
		
		
		
		
		
		
		
		 JLabel j1=new JLabel();
		 j1.setSize((int)((width/2.2)),(int)(height/(1.6)));
		 j1.setLocation(0,0);
		 j1.setIcon(background);
		 this.add(j1);
		 
		 
		 
		 
		 new Thread(this).start();

		
		

	}
	
	
	
	
	private void specifylabel(JLabel temp, int posx,int posy) {
		temp.setSize(200, 30);
		
		temp.setLocation(posx, posy);
		Font f = new Font("Dialog", Font.PLAIN, 26);
		temp.setFont(f);
		temp.setForeground(Color.lightGray);
		this.add(temp);
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
				if(arg0.getSource().equals(namesearch)){
					
					
					model.removeAllElements();
					
					
					
					
					String s=textname.getText();
					JSONObject jsonObject=new JSONObject();
					jsonObject.put("username",s);
					String q=jsonObject.toString();
					String send="6"+q;
				//	System.out.println(send);
				//	System.out.println(send);
					
			    	PrintWriter pw=new PrintWriter(mainFrame.client.output);
			    	pw.println(send);
			    	try {
						Thread.sleep(50);
						
					} catch (InterruptedException e) {
						
						
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	
			    //	System.out.println(pw.toString());
			    	pw.flush();

					
					
				}
					
				
				
				
				
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	
	
	
	private void specifytextfield(JTextField temp, int posx,int posy) {
		temp.setSize(230, 40);
		
		temp.setLocation(posx, posy);
		Font f = new Font("Dialog", Font.PLAIN, 22);
		temp.setFont(f);
		temp.setForeground(Color.lightGray);
		this.add(temp);
	}
	
	
	
	
	public void sms1(String s){
		search_resault.removeAll();
		search_resault=new Search_resault(mainFrame,s);
		this.add(search_resault);
		System.out.println(s);
		
		
	}




	@Override
	public void run() {
		
		while(true){
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
	//	System.out.println("sd");
		}
		
		// TODO Auto-generated method stub
		
	}




	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		if(arg0.getSource().equals(addcontact)){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("username",mainFrame.username);
			jsonObject.put("friendname",textname.getText());
			
			
			String q=jsonObject.toString();
			String send="5"+q;
			DBObject dbObject=new BasicDBObject().append("type","person").append("username",textname.getText());
			mainFrame.dataBase.friendgroup.insert(dbObject);
			
			
			
			
			
		
		
    	PrintWriter pw=new PrintWriter(mainFrame.client.output);
    	pw.println(send);
    	try {
			Thread.sleep(50);
			
		} catch (InterruptedException e) {
			
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    //	System.out.println(pw.toString());
    	pw.flush();

		// TODO Auto-generated method stub
		}
	}



	
	
	


}
