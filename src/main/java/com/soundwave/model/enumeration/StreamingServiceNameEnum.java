package com.soundwave.model.enumeration;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum StreamingServiceNameEnum {
	
	RDIO(0),
	SPOTIFY(1),
	YOUTUBE(2),
	SOUNDCLOUD(3), 
	DEEZER(4), 
	PLAYER_PRO(5),
	WINAMP(6),
	AMAZON_MUSIC(7), 
	TIDAL_LOSSLESS_AUDIO(8);
	
	private int code;


	private static final Map<Integer, StreamingServiceNameEnum> lookup = new HashMap<Integer, StreamingServiceNameEnum>();

	static {
		for (StreamingServiceNameEnum w : EnumSet.allOf(StreamingServiceNameEnum.class))
			lookup.put(w.getCode(), w);
	}


	private StreamingServiceNameEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static StreamingServiceNameEnum get(int code) {
		return lookup.get(code);
	}
	
	
}
