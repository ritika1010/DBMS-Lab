package b7_new;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.client.*;
import com.mongodb.util.JSON;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.MongoException;

import org.bson.*;
import org.json.simple.JSONObject;
import org.json.JSONArray;
import org.json.simple.JSONValue;
@SuppressWarnings({ "deprecation", "unused" })

public class connectivity {

	public connectivity() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try{// TODO Auto-generated method stub
		//creating credentials
			Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
			mongoLogger.setLevel(Level.SEVERE); 
		MongoCredential credential;
		credential= MongoCredential.createCredential("te3413db", "te3413db", "te3413db".toCharArray());
		@SuppressWarnings("deprecation")
		//creating mongo client///////////////////////////////////////////////////////////////////
				MongoClient mongo= new MongoClient(new ServerAddress("10.10.15.202",27017),Arrays.asList(credential));
		
		System.out.println("Connected to database successfully!");
		
		//accessing db
		MongoDatabase database=mongo.getDatabase("te3413db");
		System.out.println("Credentials ::"+ credential);
		MongoDatabase db = mongo.getDatabase( "te3413db" );
		//creating collection
		
		//db.createCollection("sample1");
		System.out.println("\n Collection created successfully!");
		MongoCollection<Document> col= database.getCollection("sample1");
		System.out.println("\n Yaha tak toh thik hai!\n"+col);
		
		  
	     //Encoding JSON Object
	      JSONObject obj=new JSONObject();    
		  obj.put("name","Ritiiak");    
		  obj.put("age",new Integer(19));    
		  obj.put("salary",new Double(600000));  
		  System.out.println(obj+"\n");
		  @SuppressWarnings("deprecation")
		  Document myDoc = Document.parse(obj.toJSONString());
	        col.insertOne(myDoc);

		 
		  
	        Document emp1_addr = new Document();
	        emp1_addr.put("name","sharvil");      
	        emp1_addr.put("zip_code", "85794");
	       
	 
	        col.insertOne(emp1_addr);
	        
		  
	       

	        
	        Document dbo = (Document) col.find().first();
	        String name = (String) dbo.get("name");
	        int age = (Integer) dbo.get("age");
	        System.out.println("Name : "+name+"\nAge :  "+age);
		  /*Object obj1=JSONValue.parse(obj.toString());  
		  JSONObject jsonObject = (JSONObject) col.find().first();  
	  
		  String name = (String) jsonObject.get("name");  
		  double salary = (Double) jsonObject.get("salary");  
		  long age = (Long) jsonObject.get("age");  
	System.out.println("Name : "+name+"\nSalary :  "+salary+"\nAge :  "+age)*/ 
	}
		catch(Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
		}
	}

	
}