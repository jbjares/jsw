package com.soundwave.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RandomSongDataUtil {
	  public static void main(String[] args) throws FileNotFoundException {
		  System.out.println(getSoundSample()[4]);
		  System.out.println(getSoundSample()[5]);
		  }
	  
	  public static String[] getSoundSample(){
		  try{
			  String s = choose(new File("src/main/resources/itunessalesdata2.csv"));	
			  return s.split(";");			  
		  }catch(Exception e){
			  throw new RuntimeException(e.getMessage(),e);
		  }
	  }

		  public static String choose(File f) throws FileNotFoundException
		  {
		     String result = null;
		     Random rand = new Random();
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
