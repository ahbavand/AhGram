import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContactProfile extends JPanel  {
	
	
	
	
	int width,height;
	BufferedImage buttonicon;
//	JButton backbutton;
	JLabel backbutton;
	ImageIcon background;
//	JLabel name;
	JLabel username,iusername;
	JLabel phonenumber,iphonenumber;
	JLabel personalimage;
	MainFrame mainFrame;
	
	
	

	public  ContactProfile(MainFrame mainFrame,String s) throws IOException {
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
					mainFrame.sms(4);
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
		
		
		
		
		username=new JLabel("username");
		phonenumber=new JLabel("phonenumber");
		specifylabel1(username,260 , 270);
		specifylabel1(phonenumber,260 , 330);
		
		
		
		
		
		
		iusername=new JLabel();
		iphonenumber=new JLabel();
		specifylabel(s,iusername,500,270);
		specifylabel("+989365966365",iphonenumber,500,330);

		


		


		
		
		
		Font f = new Font("Dialog", Font.PLAIN, 27);
//		name=new JLabel("Amirhossein Sohrabbeig");
//		name.setSize(330,120);
//		name.setLocation(490,55);
//		name.setFont(f);
//		name.setForeground(Color.lightGray);
//		this.add(name);
		
		
		
		
		personalimage=new JLabel(new ImageIcon("person.jpg"));
		personalimage.setSize(200,200);
		personalimage.setLocation(240, 30);
		this.add(personalimage);
		
		
		
		
		 JLabel j1=new JLabel();
		 j1.setSize((int)((width/2.2)),(int)(height/(1.6)));
		 j1.setLocation(0,0);
		 j1.setIcon(background);
		 this.add(j1);
		 
	}
	
	
	
	private void specifylabel1(JLabel temp, int posx,int posy) {
		temp.setSize(160, 30);
		
		temp.setLocation(posx, posy);
		Font f = new Font("Dialog", Font.PLAIN, 22);
		temp.setFont(f);
		temp.setForeground(Color.lightGray);
		this.add(temp);
	}
	
	
	
	
	
	
	
	private void specifylabel(String s,JLabel temp, int posx,int posy) {
		temp.setText(s);
		temp.setSize(250, 30);
		
		temp.setLocation(posx, posy);
		Font f = new Font("Dialog", Font.PLAIN, 22);
		temp.setFont(f);
		temp.setForeground(Color.lightGray);
		this.add(temp);
	}





	
	

}
