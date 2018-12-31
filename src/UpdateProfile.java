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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.simple.JSONObject;





public class UpdateProfile extends JPanel implements ActionListener {
	
	BufferedImage buttonicon;
	ImageIcon background;
	JLabel backbutton;
	JLabel name,username,password,phnenumber;
	JTextField textname,textusername,textpassword,textphonenumber;
	JButton submit;

	MainFrame mainFrame;
	int width,height;

	
	
	
	
	public UpdateProfile(MainFrame mainFrame) throws IOException {
		this.mainFrame=mainFrame;
		buttonicon=ImageIO.read(new File("backicon.png"));
		background=new ImageIcon("profile_background.jpg");
		width=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		height=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		setSize((int)((width/2.2)),(int)(height/(1.6)));
		setLocation(0,0);
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
					mainFrame.sms(6);
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
		
		

		
		name=new JLabel("name");
		username=new JLabel("username");
		password=new JLabel("password");
		phnenumber=new JLabel("phonenumber");
		
		specifylabel(name, 230, 170);
		specifylabel(username,230 ,240);
		specifylabel(password, 230, 310);
		specifylabel(phnenumber, 230, 380);
		
		
		
		textname=new JTextField();
		textusername=new JTextField();
		textpassword=new JTextField();
		textphonenumber=new JTextField();
		specifytextfield(textname, 450, 170);
		specifytextfield(textusername, 450, 240);
		specifytextfield(textpassword, 450, 310);
		specifytextfield(textphonenumber, 450,380);
		
		
		
	    Font f = new Font("Dialog", Font.ROMAN_BASELINE, 21);
		submit=new JButton("Submit");
		submit.setSize(140,60);
		submit.setLocation(220,470);
		submit.setFont(f);
		submit.addActionListener(this);
		this.add(submit);

		
		


		
		
		 JLabel j1=new JLabel();
		 j1.setSize((int)((width/2.2)),(int)(height/(1.6)));
		 j1.setLocation(0,0);
		 j1.setIcon(background);
		 this.add(j1);
		 textpassword.setText("");

		
		
	}
	
	
	
	
	
	
	private void specifylabel(JLabel temp, int posx,int posy) {
		temp.setSize(160, 30);
		
		temp.setLocation(posx, posy);
		Font f = new Font("Dialog", Font.PLAIN, 22);
		temp.setFont(f);
		temp.setForeground(Color.lightGray);
		this.add(temp);
	}
	
	
	
	
	
	
	
	private void specifytextfield(JTextField temp, int posx,int posy) {
		temp.setSize(230, 40);
		
		temp.setLocation(posx, posy);
		Font f = new Font("Dialog", Font.PLAIN, 22);
		temp.setFont(f);
		temp.setForeground(Color.lightGray);
		this.add(temp);
	}






	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		if(arg0.getSource().equals(submit))
			try {
				
				
				if(!textpassword.getText().equals("")){
					JSONObject jsonObject=new JSONObject();
					jsonObject.put("username",mainFrame.username);
					jsonObject.put("password",textpassword.getText());
					mainFrame.password=textpassword.getText();
					String q=jsonObject.toString();
					String send="8"+q;
			    	PrintWriter pw=new PrintWriter(mainFrame.client.output);
			    	pw.println(send);
			    	pw.flush();
					mainFrame.sms(8);

			    	
					
					
					
					
					
					
					
					
					
				}
				
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	}


	
	
	

}
