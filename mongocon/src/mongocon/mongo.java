package mongocon;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.client.*;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.MongoException;

import org.bson.*;
import org.json.simple.JSONObject;
import org.json.JSONArray;
import org.json.simple.JSONValue;
@SuppressWarnings("deprecation")

public class mongo {

	public mongo() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try{// TODO Auto-generated method stub
		//creating credentials
			Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
			mongoLogger.setLevel(Level.SEVERE); 
		MongoCredential credential;
		credential= MongoCredential.createCredential("te3418db", "te3418db", "te3418db".toCharArray());
		@SuppressWarnings("deprecation")
		//creating mongo client///////////////////////////////////////////////////////////////////
				MongoClient mongo= new MongoClient(new ServerAddress("10.10.15.202",27017),Arrays.asList(credential));
		
		System.out.println("Connected to database successfully!");
		
		//accessing db
		MongoDatabase database=mongo.getDatabase("te3418db");
		System.out.println("Credentials ::"+ credential);
		MongoDatabase db = mongo.getDatabase( "te3418db" );
		//creating collection
		
		//db.createCollection("sample1");
		System.out.println("\n Collection created successfully!");
		MongoCollection<Document> col= database.getCollection("sample1");
		System.out.println("\n Yaha tak toh thik hai!\n"+col);
		
		  
	     //Encoding JSON Object
	      JSONObject obj=new JSONObject();    
		  obj.put("name","sharvil");    
		  obj.put("age",new Integer(19));    
		  obj.put("salary",new Double(600000));  
		  System.out.println(obj+"\n");
		  
		
	/*	JSONObject o1 = new JSONObject();
		  o1.put("name", "Alex");
		  o1.put("roll", new Integer(12));
		  o1.put("total_marks", new Double(684.50));
		  o1.put("pass", new Boolean(true));
		  System.out.print(o1);
		  
		  
		  String s = "{\"name\":\"Alex\",\"marks\":648.50,\"roll\":12}";
		  Object obj = JSONValue.parse(s);
		  JSONObject jsonObj = (JSONObject) obj;
		  String name = (String) jsonObj.get("name");
		  double marks = (Double) jsonObj.get("marks");
		  Integer roll = (Integer) jsonObj.get("roll");
		  System.out.println(name + " " + marks + " " + roll);
		  System.out.println("\n Yaha tak bhiiii thik hai!\n");
		  /*Document doc= Document.parse(obj.toString());
		  col.insertOne(doc);
		*/
		  
		//Decoding JSON Object
		  
		  Object obj1=JSONValue.parse(obj.toString());  
		  JSONObject jsonObject = (JSONObject) obj1;  
	  
		  String name = (String) jsonObject.get("name");  
		  double salary = (Double) jsonObject.get("salary");  
		  long age = (Long) jsonObject.get("age");  
	System.out.println("Name : "+name+"\nSalary :  "+salary+"\nAge :  "+age); 
	}
		catch(Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
		}
	}

	
}
