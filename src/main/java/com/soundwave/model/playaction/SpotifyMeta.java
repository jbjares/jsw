package com.soundwave.model.playaction;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SpotifyMeta {

	private Tracks[] tracks;

	private ObjectId _id;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public Tracks[] getTracks() {
		return tracks;
	}

	public void setTracks(Tracks[] tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "ClassPojo [_id = " + _id + ", tracks = " + tracks + "]";
	}
}