package com.soundwave.model.playaction;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Tracks {

	private String regions;

    private ObjectId _id;

    

    public ObjectId get_id() {
		return _id;
	}



	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getRegions() {
		return regions;
	}

	public void setRegions(String regions) {
		this.regions = regions;
	}

	@Override
	public String toString() {
		return "ClassPojo [_id = " + _id + ", regions = " + regions + "]";
	}
}
