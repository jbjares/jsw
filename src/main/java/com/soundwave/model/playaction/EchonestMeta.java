package com.soundwave.model.playaction;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EchonestMeta {
	private String title;

	private String artistId;

	private String artistName;

	private AudioSummary audioSummary;

	private ObjectId _id;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public AudioSummary getAudioSummary() {
		return audioSummary;
	}

	public void setAudioSummary(AudioSummary audioSummary) {
		this.audioSummary = audioSummary;
	}

	@Override
	public String toString() {
		return "ClassPojo [title = " + title + ", _id = " + _id
				+ ", artistId = " + artistId + ", artistName = " + artistName
				+ ", audioSummary = " + audioSummary + "]";
	}
}