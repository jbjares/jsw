package com.soundwave.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;

import com.soundwave.model.playaction.Play;

@Repository
public class PlayDAO {
	
	private static final String CASE_INSENSITIVE = "i";

	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired 
	public GridFsTemplate fsTemplate;

	
	public void insert(Play play) throws Exception {
		mongoOperations.insert(play,Play.class.getSimpleName());	
	}	


}
