package com.soundwave.model.enumeration;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum SourceNamesEnum {

	ANDROID(0),
	RDIO(1),
	SPOTIFY(2),
	YOUTUBE(3),
	SOUNDCLOUD(4), 
	DEEZER(5), 
	PLAYER_PRO(6),
	WINAMP(7),
	AMAZON_MUSIC(8), 
	TIDAL_LOSSLESS_AUDIO(9);
	
	private int code;


	private static final Map<Integer, SourceNamesEnum> lookup = new HashMap<Integer, SourceNamesEnum>();

	static {
		for (SourceNamesEnum w : EnumSet.allOf(SourceNamesEnum.class)){
			lookup.put(w.getCode(), w);			
		}
	}


	private SourceNamesEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static SourceNamesEnum get(int code) {
		return lookup.get(code);
	}
	
}
