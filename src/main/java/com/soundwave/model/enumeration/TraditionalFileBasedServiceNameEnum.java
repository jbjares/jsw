package com.soundwave.model.enumeration;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TraditionalFileBasedServiceNameEnum {

	ANDROID(0);

	private int code;


	private static final Map<Integer, TraditionalFileBasedServiceNameEnum> lookup = new HashMap<Integer, TraditionalFileBasedServiceNameEnum>();

	static {
		for (TraditionalFileBasedServiceNameEnum w : EnumSet.allOf(TraditionalFileBasedServiceNameEnum.class))
			lookup.put(w.getCode(), w);
	}


	private TraditionalFileBasedServiceNameEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TraditionalFileBasedServiceNameEnum get(int code) {
		return lookup.get(code);
	}

}
