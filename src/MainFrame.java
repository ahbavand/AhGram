import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.MouseInputListener;

public class MainFrame extends JFrame {
	Client client;
	DataBase dataBase;
	ChatPanel chatPanel;
	My_Profile my_Profile;
	ContactProfile contactProfile;
	UpdateProfile updateProfile;
	SearchPanel searchPanel;
	SignUp signUp;
	int height;
	int width;
	String username;
	String password;
	
	public MainFrame(Client client) throws IOException{
		
		
		
		
		
		System.out.println("salam");
		this.client=client;

		width=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		height=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		setSize((int)((width/2.2)),(int)(height/(1.6)));
		setLocation(400,200);
		setResizable(false);
		setTitle("Ahgram");
	//	setUndecorated(true);

		
	//	searchPanel=new SearchPanel(this);
	//	getContentPane().add(searchPanel);
		signUp=new SignUp(this);
		getContentPane().add(signUp);
	//	chatPanel=new ChatPanel(this);
	//	getContentPane().add(chatPanel);
		setLayout(null);
		setVisible(true);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		client=new Client(this);


//		lm.addElement("salam");

		
	}
	
	
	public void sms(int x) throws IOException{
		if(x==1){
			chatPanel.removeAll();
			my_Profile=new My_Profile(this,username,password);
			this.setContentPane(my_Profile);
			repaint();
		}
		else if(x==2){
			my_Profile.removeAll();
			chatPanel=new ChatPanel(this);
			this.setContentPane(chatPanel);
			repaint();
			
			
			
			
		}
		else if(x==3){
			dataBase=new DataBase();
			dataBase.createdata(signUp.username.getText(),signUp.password.getText());
			username=signUp.username.getText();
			password=signUp.password.getText();

			signUp.removeAll();
			chatPanel=new ChatPanel(this);
			this.setContentPane(chatPanel);
			repaint();

		}
		else if(x==4){
			contactProfile.removeAll();
			chatPanel=new ChatPanel(this);
			this.setContentPane(chatPanel);
			repaint();
		}
		else if(x==5){
			chatPanel.removeAll();
			contactProfile=new ContactProfile(this,chatPanel.cg_username);
			this.setContentPane(contactProfile);
			repaint();
		}
		
		else if(x==6){
			updateProfile.removeAll();
			
			System.out.println(username);
			my_Profile=new My_Profile(this,username,password);
			this.setContentPane(my_Profile);
			repaint();
		}
		else if(x==7){
			chatPanel.removeAll();
			updateProfile=new UpdateProfile(this);
			this.setContentPane(updateProfile);
			repaint();
		}
		else if(x==8){
			updateProfile.removeAll();
			System.out.println(username);
			my_Profile=new My_Profile(this,username,password);
			this.setContentPane(my_Profile);
			repaint();
		}
		else if(x==9){
			searchPanel.removeAll();
			chatPanel=new ChatPanel(this);
			this.setContentPane(chatPanel);
			repaint();
			this.setContentPane(chatPanel);
			repaint();
		}
		else if(x==10){
			chatPanel.removeAll();
			searchPanel=new SearchPanel(this);
			this.setContentPane(searchPanel);
			repaint();
		}





		

		
		
		
		
	}
	
	
	


}
