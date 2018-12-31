import com.mongodb.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

	InputStream input;
	OutputStream output;
	ServerSocket ss;
	Vector<Workstation> v;
	DB DataCenter;
	DBCollection USERS = null;
	DBCollection MESSAGES = null;
	DBCollection GROUPS = null;
	DBCollection REPORT=null;
	JSONObject json = new JSONObject();
	JSONParser parser = new JSONParser();
	DBObject cursor;
//	int corg;///////contact=3   group=4

	int job;

	public Server() {
		v = new Vector<Workstation>();
		try {
			ss = new ServerSocket(5005);// port number, MaxClients
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// newly added
	private  void database(){

		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE);
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			DataCenter = mongoClient.getDB("DataCenter");
			if (!DataCenter.collectionExists("USERS")) {
				USERS = DataCenter.createCollection("USERS", new BasicDBObject());
			}
			if (!DataCenter.collectionExists("MESSAGES")) {
				MESSAGES = DataCenter.createCollection("MESSAGES", new BasicDBObject());
			}
			//System.out.println("SADFGHJ");
			if (!DataCenter.collectionExists("GROUPS")) {
			//	System.out.println("sdkfgjdl");
				GROUPS = DataCenter.createCollection("GROUPS", new BasicDBObject());
				
				
				GROUPS = DataCenter.getCollection("GROUPS");
				
				
			//	List<BasicDBObject> milestones = new ArrayList<>();	
				ArrayList<String> use=new ArrayList<>();
				use.add("sohrab");
				use.add("amirhossein");
				use.add("ahbavand");
				BasicDBObject doc=new BasicDBObject().append("groupId","gorouh").append("users",use);
			//	System.out.println("salam");
				System.out.println(doc.toString());
				
				
				
				

		//		BasicDBObject doc=new BasicDBObject().append("groupId","gorouh").append("users","sohrab").append("users","amirhossein").append("users","ahbavand");
			    GROUPS.insert(doc);
			//    System.out.println(doc.toString()+"doc");

			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		


	}

	private void execute() {
		database();//connects to the DataCenter and uses the needed collections
		while (true) {
			try {
				Socket client = ss.accept();
				Workstation w = new Workstation(client, this);
				v.addElement(w);
				w.start();
				w.username="yes";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized void recieve(String msg, Workstation sender) {
		//System.out.println(msg);
		job = Integer.parseInt(msg.substring(0,1));
		try {
		//	System.out.println(json.toString()+"salam");
			json = (JSONObject) parser.parse(msg.substring(1));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		switch (job){
			case 0: sendProfile(json,sender);
				    break;
			case 1: sendGroup(json,sender);
					break;
			case 2: sendPV(json,sender);
					break;
			case 3: signUp(json,sender);
					break;
			case 4: signIn(json,sender);
					break;
					
			
			case 5: 
				addFriend(json,sender);
			break;

					
					
				
					
			
					
			case 6:serachuser(json,sender);
				break;
				
				
			case 7:  
				REPORT=DataCenter.getCollection("REPORT");
				BasicDBObject doc=new BasicDBObject().append("username",json.get("username").toString() );
				REPORT.insert(doc);	
				break;
				
			case 8:
				
				USERS = DataCenter.getCollection("USERS");
				
				
				
				DBCursor dbCursor=USERS.find();
				int i=1;
					    while(dbCursor.hasNext()){
					    	
					    	DBObject s=dbCursor.next();
					    	String g=(String) s.get("username");
					    	if(g.equals(json.get("username"))){
					    		
					    		
					    		
					    		
					    		break;
					    		}
					    	i++;
					    }


				
				
				
				
				
				
				
				
				
				
				
				break;
				
				
				
					
					
		}
	}

	private void serachuser(JSONObject json, Workstation sender) {
		USERS = DataCenter.getCollection("USERS");
	//	try {
	//		cursor = USERS.find(new BasicDBObject().append("username",json.get("username"))).next();
			//there is such a user
	//		sender.output.write("6".getBytes());
			

	//	}catch (Exception e){
	//	}
		
		
		DBCursor dbCursor=USERS.find();
		int i=1;
			    while(dbCursor.hasNext()){
			    	
			    	DBObject s=dbCursor.next();
			    	String g=(String) s.get("username");
			    	if(g.equals(json.get("username"))){
			    		//System.out.println(g);
			    		//System.out.println(json.get("username"));
			    		try {
			    			
			    			
			    			
							sender.output.write("6".getBytes());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		break;
			    	//	if(pas.equals(json.get("password"))){
			    		//	sender.username= json.get("username").toString();
						//	accept(true,sender);
			    		}
			    	i++;
			    }
		



		
		
		
		
	}

	// newly added
	public synchronized void sendPV(JSONObject json, Workstation sender){
		
		sendMessage(json.get("reciever").toString());
		
	}

	// newly added
	public synchronized void sendGroup(JSONObject json, Workstation sender){
	//	corg=4;
	//	System.out.println(sender.username);
		
		GROUPS= DataCenter.getCollection("GROUPS");

	//	BasicDBObject doc=new BasicDBObject().append("groupId","gorouh");//.append("users","sohrab").append("users","amirhossein").append("users","ahbavand");
	//      GROUPS.insert(doc);

		
		MESSAGES = DataCenter.getCollection("MESSAGES");
		cursor = GROUPS.find(new BasicDBObject().append("groupId",json.get("reciever"))).next();

		
		
		
		Vector<String> usernames = new Vector<>();
		String s = (String) cursor.get("users").toString();
	//	System.out.println(s);
		for (String retval: s.toString().substring(1,s.length()).split(",")){
			retval=retval.toString().substring(2,retval.length()-2);

		//	System.out.println(retval);
		//	retval=retval.toString().substring(2,retval.length()-1);
			usernames.addElement(retval);
		}
		for (int i =0; i < usernames.size();i++){
			if(!usernames.elementAt(i).equals(sender.username))
			sendMessage(usernames.elementAt(i));
		}
	}

	// newly added
	public synchronized void sendProfile(JSONObject json, Workstation sender){
		USERS = DataCenter.getCollection("USERS");
		cursor = GROUPS.find(new BasicDBObject().append("username",json.get("username"))).next();
		JSONObject requestedUser = new JSONObject();
		requestedUser.put("username",cursor.get("username"));
		requestedUser.put("name",cursor.get("name"));
		requestedUser.put("phoneNumber",cursor.get("phoneNumber"));
		try {
			sender.output.write(requestedUser.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// newly added
	public synchronized void signUp(JSONObject json,Workstation sender){
	//	System.out.println("hello");

		USERS = DataCenter.getCollection("USERS");
		try {
			cursor = USERS.find(new BasicDBObject().append("username",json.get("username"))).next();
			//there is such a user
			accept(false,sender);

		}catch (Exception e){
			//there is not such a user
			DBObject newUser = new BasicDBObject().append("username",json.get("username")).append("password",json.get("password"));
			USERS.insert(newUser);
			accept(true,sender);
			
			sender.username = json.get("username").toString();
		}

	}
	
	
	
	
	
	
	
	
	public synchronized void addFriend(JSONObject json,Workstation sender){
		JSONObject jsonObject=new JSONObject();
		json.put("username",sender.username);
		
		
		
		
		
		USERS = DataCenter.getCollection("USERS");
		try {
			DBObject temp;
			DBObject query = new BasicDBObject("username", sender.username);
			temp = USERS.find(query).next();
			String s = (String) temp.get("friendname");
			if (s.equals(""))s = "[".concat(json.get("friendname").toString()).concat("]");
			else s = "[".concat(s.substring(1,s.length()-1)).concat(",").concat(json.get("friendname").toString()).concat("]");
			DBObject update = new BasicDBObject();
			update.put("$set", new BasicDBObject().append("friendname",s));
			USERS.update(query, update);
		}catch (Exception e){

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		JSONObject jo=new JSONObject();
		jo.put("username",json.get("username"));
		
		
		
		
		for (Workstation w : v) {
			if (w.username.equals(json.get("friendname"))){
				try {
					w.output.write(("7"+json.toString()).getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			};
		}

		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// newly added
	public synchronized void signIn(JSONObject json,Workstation sender){
		//System.out.println("hello");

		USERS = DataCenter.getCollection("USERS");
	//	try {
			
		//	cursor = USERS.find(new BasicDBObject().append("username",json.get("username"))).next();
			
			//there is such a user
	//		if (cursor.get("password") == json.get("password")){
			
			
			DBCursor dbCursor=USERS.find();
			int i=1;
				    while(dbCursor.hasNext()){
				    	
				    	DBObject s=dbCursor.next();
				    	String g=(String) s.get("username");
				    	String pas=(String) s.get("password");
				    	if(g.equals(json.get("username"))){
				    		if(pas.equals(json.get("password"))){
				    			sender.username= json.get("username").toString();
								accept(true,sender);
				    		}

				    	}
				    	i++;
				    }
	}


	//newly added
	public void accept(boolean b,Workstation sender){
		String accept;
	//	JSONObject accept = new JSONObject();
	//	if (b)accept.put("accept","true");
	//	else accept.put("accept","false");
		if(b) accept="0";
		else accept="1";
			try {
				sender.output.write(accept.getBytes());

	//	try {
	//		sender.output.write(accept.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String username){
		for (Workstation w : v) {
			if (w.username.equals(username)){
				try {
					w.output.write(("3"+json.toString()).getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			};
		}
	}


	public static void main(String[] args) {

		(new Server()).execute();

	}

}
