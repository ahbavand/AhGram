import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;


public class Client implements Runnable {
	
	
	
	
	InputStream input;
	OutputStream output;
	Socket socket;
	private int id;
	MainFrame mainFrame;
	String o;
	JSONObject json = new JSONObject();
	JSONParser parser = new JSONParser();



	
	
	
	 
  public Client() throws IOException {
/*		try {
			socket = new Socket(InetAddress.getByName("localhost"),5005);
			input = socket.getInputStream();
			output = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
*/		mainFrame=new MainFrame(this);
		(new Thread(this)).start();

	}


	
	
	
	
	
	
	
	

	@Override
	public void run() {
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int i = 0;
		while (i != -1){
		//	System.out.println(output.toString());

			try {
				byte [] b = new byte[200];

				i = input.read(b);
					o =new String(b).trim();
					int job=Integer.parseInt(o.substring(0,1));
					;
					;
				//	System.out.println(o);
//					try {
//						Thread.sleep(50);
//					} catch (InterruptedException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
					
					
					switch (job){
					case 0: ;
					mainFrame.sms(3);

						    break;
					case 1: ;
							break;
					case 2: ;
					mainFrame.sms(3);

							break;
					case 3: 
						
						try {
						//	System.out.println(json.toString());
							json = (JSONObject) parser.parse(o.substring(1));
						//	System.out.println();
							DBObject newMESSAGE = new BasicDBObject().append("content",json.get("content")).append("sender",json.get("sender")).append("reciever",json.get("reciever"));
							mainFrame.dataBase.massages.insert(newMESSAGE);

							
							
							
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						
						
						
							break;
					case 4: ;
							break;
							
							
					case 6:
						mainFrame.searchPanel.model.addElement(mainFrame.searchPanel.textname.getText());
						break;
						
					case 7:
						try {
							json = (JSONObject) parser.parse(o.substring(1));
							DBObject dbObject=new BasicDBObject().append("type","person").append("username",json.get("username"));
							mainFrame.dataBase.friendgroup.insert(dbObject);
							
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						
						
						
						
						
				}


					

					
					
					
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		(new Thread(new Client())).start();
	}

	
	
	
	
	
	
	
	
	
	
	public void setId(int id) {
		this.id = id;
	}

	
	
	
	
	

}
