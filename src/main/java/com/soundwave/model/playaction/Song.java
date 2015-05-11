package com.soundwave.model.playaction;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Song {
	private DeezerMeta deezerMeta;

	private SpotifyMeta spotifyMeta;

	private String title;

	private String isrc;

	private String itunesBuyURL;

	private ExternalMetaStats externalMetaStats;

	private EchonestMeta echonestMeta;

	private String artist;

	private String imageURL;

	private String clipURL;

	private String imageURL_200;

	private ObjectId _id;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public DeezerMeta getDeezerMeta() {
		return deezerMeta;
	}

	public void setDeezerMeta(DeezerMeta deezerMeta) {
		this.deezerMeta = deezerMeta;
	}

	public SpotifyMeta getSpotifyMeta() {
		return spotifyMeta;
	}

	public void setSpotifyMeta(SpotifyMeta spotifyMeta) {
		this.spotifyMeta = spotifyMeta;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsrc() {
		return isrc;
	}

	public void setIsrc(String isrc) {
		this.isrc = isrc;
	}

	public String getItunesBuyURL() {
		return itunesBuyURL;
	}

	public void setItunesBuyURL(String itunesBuyURL) {
		this.itunesBuyURL = itunesBuyURL;
	}

	public ExternalMetaStats getExternalMetaStats() {
		return externalMetaStats;
	}

	public void setExternalMetaStats(ExternalMetaStats externalMetaStats) {
		this.externalMetaStats = externalMetaStats;
	}

	public EchonestMeta getEchonestMeta() {
		return echonestMeta;
	}

	public void setEchonestMeta(EchonestMeta echonestMeta) {
		this.echonestMeta = echonestMeta;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getClipURL() {
		return clipURL;
	}

	public void setClipURL(String clipURL) {
		this.clipURL = clipURL;
	}

	public String getImageURL_200() {
		return imageURL_200;
	}

	public void setImageURL_200(String imageURL_200) {
		this.imageURL_200 = imageURL_200;
	}

	@Override
	public String toString() {
		return "ClassPojo [deezerMeta = " + deezerMeta + ", spotifyMeta = "
				+ spotifyMeta + ", title = " + title + ", isrc = " + isrc
				+ ", _id = " + _id + ", itunesBuyURL = " + itunesBuyURL
				+ ", externalMetaStats = " + externalMetaStats
				+ ", echonestMeta = " + echonestMeta + ", artist = " + artist
				+ ", imageURL = " + imageURL + ", clipURL = " + clipURL
				+ ", imageURL_200 = " + imageURL_200 + "]";
	}
}