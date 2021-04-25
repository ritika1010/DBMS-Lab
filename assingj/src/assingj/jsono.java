package assingj;

import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase; 
import org.bson.Document;  
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;  

public class jsono { 
   
   public static void main( String args[] ) {  
      try{
	
      // Creating a Mongo client 
      MongoClient mongo = new MongoClient( "127.0.0.1" , 27017 ); 

      // Creating Credentials 
      MongoCredential credential; 
      credential = MongoCredential.createCredential("t3407","t3407db","t3407".toCharArray()); 
      System.out.println("Connected to the database successfully");  
      
      // Accessing the database 
      MongoDatabase database = mongo.getDatabase("t3407db"); 

      // Retrieving a collection
      MongoCollection collection = database.getCollection("student"); 
      System.out.println("Collection sampleCollection selected successfully");

      Document document = new Document("title", "MongoDB") 
      .append("id","1")
      .append("description", "database") 
      .append("likes", "100") 
      .append("url", "http://www.tutorialspoint.com/mongodb/") 
      .append("by", "tutorials point");  
      collection.insertOne(document); 
      System.out.println("Document inserted successfully");     
      mongo.close();
   }
      catch(Exception ex)
      {
    	  System.out.println("error");
      }
   }
	   
   
}