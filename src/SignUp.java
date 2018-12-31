import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.crypto.SecretKeyFactorySpi;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class SignUp extends JPanel implements ActionListener {
	MainFrame mainFrame;
	int width,height;
	ImageIcon background;
	JTextField username;
	JTextField phone;
	JPasswordField password;
	JLabel userlabel;
	JLabel passlabel;
	JLabel phonelabel;
	JButton login;
	JButton signup;
	String user_id;///username
	


	
	public SignUp(MainFrame mainFrame) {
		
		this.mainFrame=mainFrame;
		background=new ImageIcon("profile_background.jpg");

		
		
		width=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		height=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		
		setSize((int)((width/2.2)),(int)(height/(1.6)));
		setLocation(0,0);
		
		
		
		
		userlabel=new JLabel("username:");
		passlabel=new JLabel("password:");
		phonelabel=new JLabel("phone");
		
		specifylabel(userlabel, 200,205);
		specifylabel(passlabel,200,285);
		specifylabel(phonelabel, 200, 125);
		
		
		
		username=new JTextField();
		username.setSize(230,40);
		username.setLocation(400,200);
		this.add(username);
		
		
		
		
		
		phone=new JTextField();
		phone.setSize(230,40);
		phone.setLocation(400,120);
		this.add(phone);

		
		
		 Font f = new Font("Dialog", Font.ROMAN_BASELINE, 21);

		
		
		login=new JButton("Login");
		login.setSize(140,60);
		login.setLocation(270,400);
		login.setFont(f);
		login.addActionListener(this);
		this.add(login);
		
		
		
		signup=new JButton("Sign up");
		signup.setSize(140,60);
		signup.setLocation(530,400);
		signup.setFont(f);
		signup.addActionListener(this);
		this.add(signup);
		
		
		
		
		
		
		
		
		
		password=new JPasswordField();
		password.setSize(230,40);
		password.setLocation(400,280);
		this.add(password);
		
		
		
		
		
		

		
		
		 JLabel j1=new JLabel();
		 j1.setSize((int)((width/2.2)),(int)(height/(1.6)));
		 j1.setLocation(0,0);
		 j1.setIcon(background);
		 this.add(j1);



		
		setLayout(null);
		setVisible(true);

	}
	
	
	
	
	
	
	
	private void specifylabel(JLabel temp, int posx,int posy) {
		temp.setSize(150, 30);
		temp.setLocation(posx, posy);
		Font f = new Font("Dialog", Font.PLAIN, 28);
		temp.setFont(f);
		temp.setForeground(Color.lightGray);
		this.add(temp);
	}







	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(signup)){
			String usern=username.getText();
			String passw=password.getText();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("username",usern);
			jsonObject.put("password",passw);
			String q=jsonObject.toString();
			String send="3"+q;
			try {
				mainFrame.client.output.write(send.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
			
			
		}
			
			
		if(arg0.getSource().equals(login)){
			String usern=username.getText();
			String passw=password.getText();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("username",usern);
			jsonObject.put("password",passw);
			String q=jsonObject.toString();
			String send="4"+q;
			try {
				mainFrame.client.output.write(send.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			///sending send to server
			
			
			
			
			
	//		try {
	//			String usern=username.getText();
	//			String passw=password.getText();
	//			JSONObject jsonObject=new JSONObject();
	//			jsonObject.put("name",usern);
	//			jsonObject.put("password",passw);
	//			DBObject o=(DBObject) JSON.parse(jsonObject.toString());
	//			System.out.println(o);
		//		System.out.println(JSON.parse(jsonObject.toString()));
		//		System.out.println(jsonObject.toString());
	//			String q=jsonObject.toString();
	//			JSONParser jsonParser=new JSONParser();
	//			try {
	//				JSONObject jo=(JSONObject) jsonParser.parse(q);
	//				System.out.println(jo.toString());
	//			} catch (ParseException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
				
		//		DBObject dbObject=(DBObject) o;
	//			System.out.println(0);
				
				
	//					String usern=username.getText();
		//	String usern=username.getText();
		//	String passw=password.getText();
			
		//				String passw=password.getText();

		//		if(mainFrame.dataBase.checkusernamesigin(usern,passw))
		//			try {
		//				mainFrame.sms(3);
		//			} catch (IOException e) {
						// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}
		//		else
					;
	//		} catch (IOException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}

			
		}
		
	
	}

	
	
	

}
