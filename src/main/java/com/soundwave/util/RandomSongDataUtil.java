package com.soundwave.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class RandomSongDataUtil {
	  
	  public static String[] getSoundSample(String path, long seed){
		  try{
			  String s = choose(new File(path),seed);	
			  return s.split(";");			  
		  }catch(Exception e){
			  throw new RuntimeException(e.getMessage(),e);
		  }
	  }

		  public static String choose(File f,long seed) throws FileNotFoundException
		  {
		     String result = null;
		     Random rand = new Random();
		     rand.setSeed(seed);
		     int n = 0;
		     for(Scanner sc = new Scanner(f); sc.hasNext(); )
		     {
		        ++n;
		        String line = sc.nextLine();
		        if(rand.nextInt(n) == 0)
		           result = line;         
		     }

		     return result;      
		  }
}
