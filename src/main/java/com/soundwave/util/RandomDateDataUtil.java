package com.soundwave.util;

/*
 * RandomDateGenerator.java
 *
 */

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author  zzynx
 */
public class RandomDateDataUtil {
    
    private Date dMin = null;
    private Date dMax = null;
    /** Creates a new instance of RandomDateGenerator */
    public RandomDateDataUtil(Date min, Date max) {
        dMin = min;
        dMax = max;
    }
    
    public Date generate() {
        long MILLIS_PER_DAY = 1000*60*60*24;
        GregorianCalendar s = new GregorianCalendar();
        s.setTimeInMillis(dMin.getTime());
        GregorianCalendar e = new GregorianCalendar();
        e.setTimeInMillis(dMax.getTime());
        
        // Get difference in milliseconds
        long endL   =  e.getTimeInMillis() +  e.getTimeZone().getOffset(e.getTimeInMillis());
        long startL = s.getTimeInMillis() + s.getTimeZone().getOffset(s.getTimeInMillis());
        long dayDiff = (endL - startL) / MILLIS_PER_DAY;
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(dMin);
        cal.add(Calendar.DATE, new Random().nextInt((int)dayDiff));          
        return cal.getTime();
    }
    
    public static Date getAnyDayFromTheLastTwoYears(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -2); // today minus two years
        Date dMin = cal.getTime();
        //cal.add(Calendar.YEAR, 2); // today plus one year
        cal.add(Calendar.YEAR, 1); // today
        Date dMax = cal.getTime();
        
        RandomDateDataUtil rnd = new RandomDateDataUtil(dMin, dMax);
        return rnd.generate();
    }
    
    // =========
    // Test it:
    // =========
    public static void main(String args[]) {
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.YEAR, -2); // today minus two years
//        Date dMin = cal.getTime();
//        //cal.add(Calendar.YEAR, 2); // today plus one year
//        cal.add(Calendar.YEAR, 1); // today
//        Date dMax = cal.getTime();
//        
//        RandomDateGenerator rnd = new RandomDateGenerator(dMin, dMax);
//        for (int i=1; i<=10; i++)
//            System.out.println("Date = " + rnd.generate());
    	System.out.println(getAnyDayFromTheLastTwoYears());
    }

	public static String getFormatedAnyDayFromTheLastTwoYears() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		String anyDayFromTheLastTwoYears = sdf.format(RandomDateDataUtil.getAnyDayFromTheLastTwoYears());
		return anyDayFromTheLastTwoYears;
	}
}