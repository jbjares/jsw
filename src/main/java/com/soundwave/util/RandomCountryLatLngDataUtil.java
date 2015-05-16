package com.soundwave.util;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class RandomCountryLatLngDataUtil {

	public static String[] choose(String path,long seed) {
		String result = null;
		try{
			File f = new File(path);
			Random rand = new Random();
			rand.setSeed(seed);
			int n = 0;
			for (Scanner sc = new Scanner(f); sc.hasNext();) {
				++n;
				String line = sc.nextLine();
				if (rand.nextInt(n) == 0)
					result = line;
			}
			
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e);
		}

		return result.split(";");
	}
}
