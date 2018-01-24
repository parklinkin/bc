package blockchain;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import static com.mongodb.client.model.Filters.*;

public class DB 
{
	public static void insert(String s, byte[] bytes)
	{
		try{   
			// 连接到 mongodb 服务
			MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			MongoDatabase db1 = mongoClient.getDatabase("blockchain");
			MongoCollection<Document> collection = db1.getCollection("bc");
			
			Document document = new Document("name", s).append("value", bytes);
			collection.insertOne(document);
		}
		catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}
	
	public static byte[] find(String s)
	{
		byte[] bytes = null;
		try{   
			// 连接到 mongodb 服务
			MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			MongoDatabase db = mongoClient.getDatabase("blockchain");
			MongoCollection<Document> collection = db.getCollection("bc"); 
			FindIterable<Document> findIterable = collection.find(eq("name", s));
			MongoCursor<Document> mongoCursor = findIterable.iterator();
			Document document=null;
			if(mongoCursor.hasNext())
			{  
				document=mongoCursor.next();
				System.out.println(document); 
				bytes = (byte[])document.get("value");
			}
			else
				return null;
		}
		catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		return bytes;	
	}

	public static void update(String s, byte[] bytes)
	{
		try{   
			// 连接到 mongodb 服务
			MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			MongoDatabase db1 = mongoClient.getDatabase("blockchain");
			MongoCollection<Document> collection = db1.getCollection("bc");		
			collection.updateMany(Filters.eq("name", s), new Document("$set",new Document("value",bytes)));
		}
		catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}
}