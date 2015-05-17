package com.soundwave.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;
import com.soundwave.model.playaction.Play;

@Service
public class PlayDAO {
	
	private static final String PLAY = "Play";

	private static final String CASE_INSENSITIVE = "i";

	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired 
	public GridFsTemplate fsTemplate;

	
	public void insert(Play play) throws Exception {
		mongoOperations.insert(play,Play.class.getSimpleName());	
	}	
	
	public void insertWithoutSpring(Play play,long seed){
		DB db = getMongoDB();
		if(!db.collectionExists(PLAY)){
			DBObject options = BasicDBObjectBuilder.start().add("capped", true).add("size", 2000000000l).get();
			db.createCollection(PLAY, options);			
		}
		DBCollection collection = db.getCollection(PLAY);
		Gson gson = new GsonBuilder().create();
		String jsonStr = gson.toJson(play,Play.class);
		DBObject dbObject = (DBObject) JSON.parse(jsonStr);
		collection.insert(dbObject);
	}	

	private static MongoClient client;
	
	public static DB getMongoDB(){
		if(client==null){
			//TODO Adjust the code below to remove static resource into texturi
			String textUri = "mongodb://localhost:27017/soundwave";
			MongoClientURI uri = new MongoClientURI(textUri);
			MongoClient m = new MongoClient(uri);
			return m.getDB("soundwave");
		}
		return client.getDB("soundwave");
	}
}
