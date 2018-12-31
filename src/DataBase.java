import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.operation.DropCollectionOperation;

public class DataBase {
	DBCollection profile;
	DBCollection friendgroup;
	DBCollection massages;
	
	
	
	
	
	
	public void createdata(String username,String password){
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
	    mongoLogger.setLevel(Level.SEVERE);
	//    DBCollection mycollection;
	    
	    
	    
	    
		try {
		      MongoClient mongoClient = new MongoClient("localhost", 27017);
		      DB db1 = mongoClient.getDB(username);
		      db1.getCollection("profile").drop();
		      db1.getCollection("friendgroup").drop();
		      db1.getCollection("massages").drop();

		      
		//      if (db1.collectionExists("mycollection")) {
		//    	  System.out.println("salam");
		    	  
	//	     mycollection= db1.getCollection("mycollection");//select a collection if exists
		      
		 //     } else {
		      profile = db1.createCollection("profile", new BasicDBObject());
		      friendgroup = db1.createCollection("friendgroup", new BasicDBObject());
		      massages = db1.createCollection("massages", new BasicDBObject());
		      
		      
		      
		      
		      
		      BasicDBObject doc=new BasicDBObject().append("username","ahbavand").append("type","person");
		      friendgroup.insert(doc);
		      BasicDBObject doc1=new BasicDBObject().append("username","amirhossein").append("type","person");
		      friendgroup.insert(doc1);
		      BasicDBObject doc2=new BasicDBObject().append("username","sohrab").append("type","person");
		      BasicDBObject doc3=new BasicDBObject().append("username","gorouh").append("type","group");
		      friendgroup.insert(doc3);

		      friendgroup.insert(doc2);

		    //  BasicDBObject doc2=new BasicDBObject().append("reciever","amir").append("sender","hasan").append("contents","salam");
		  //    BasicDBObject doc3=new BasicDBObject().append("reciever","hasan").append("sender","amir").append("contents","salamii");
//
	//	      massages.insert(doc2);
		//      massages.insert(doc3);
		      



		      
		 //     }
		      
		      
		//		System.out.println("conct");
			//	System.out.println("coc");
				
				
				
	//		BasicDBObject doc = new BasicDBObject().append("name",username).append("pass",password);
	//			BasicDBObject doc1 = new BasicDBObject().append("name","amirhossein").append("lastName","bavand").append("studentNumber","9331028");
	//	    mycollection.insert(doc);
	//		    mycollection.insert(doc1);
			    
			    
		    DBObject query = new BasicDBObject("name", "amirhossein");
		 //       DBObject update = new BasicDBObject();
		   //     update.put("$set", new BasicDBObject("name","India").append("lastName", "David New"));
		   //     mycollection.update(query, update);
		   //     mycollection.updateMulti(query, update);
		       
			    
		//	    DBCursor dbCursor=mycollection.find();
		//	    int i=1;
		//	    while(dbCursor.hasNext()){
		//	    	
		//	    	System.out.println("hello");
		//	    	DBObject s=dbCursor.next();
		//	    	String g=(String) s.get("name");
		//	//   String s =System.out.println(dbCursor.next());
		//	    	System.out.println(g);
		//	    	i++;
		//	    }
				
				
				
	//		}

		}
		
		
		
		
		
		
		      catch (Exception e) {
				// TODO: handle exception
			}

	    
		
		

		
		
		
	}
	
	
	
//	public boolean checkusernamesignup(String a,String b){
//		
//		
//		
//		
//		DBCursor dbCursor=mycollection.find();
//		int i=1;
//		
//		
//		
//		
//			    while(dbCursor.hasNext()){
//			    	
//			    	DBObject s=dbCursor.next();
//			    	String g=(String) s.get("name");
//			    	if(g.equals(a))
//			    		return false;
//			    	
//			 //   	System.out.println(g);
//			    	i++;
//			    }
//			    
//				BasicDBObject doc = new BasicDBObject().append("name",a).append("password",b);
//			    mycollection.insert(doc);
//			    return true;
//
//		
//		
//		
//		
//		
//		
//		
//	}
//	
//	
	
	
	
//	public boolean checkusernamesigin(String a,String b){
//		
//		
//		
//		
//		DBCursor dbCursor=mycollection.find();
//		int i=1;
//		
//		
//		
//		
//			    while(dbCursor.hasNext()){
//			    	
//			    	DBObject s=dbCursor.next();
//			    	String g=(String) s.get("name");
//			    	String pas=(String) s.get("password");
//			    	if(g.equals(a)){
//			    		if(pas.equals(b))
//			    			return true;
//			    		
//			    	}
//			    	
//			 //   	System.out.println(g);
//			    	i++;
//			    }
//			    
//		//		BasicDBObject doc = new BasicDBObject().append("name",a);
//		//	    mycollection.insert(doc);
//			    return false;
//
//		
//		
//		
//		
//		
//		
//		
//	}
//
//	
	

	
	
	
	
	
	
	
	

}
