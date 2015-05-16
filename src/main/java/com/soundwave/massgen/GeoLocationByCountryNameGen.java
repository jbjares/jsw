package com.soundwave.massgen;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.soundwave.model.googlegeo.GoogleGeoJson;

public class GeoLocationByCountryNameGen  {
	
	public static void main(String[] args) throws Exception {
		GeoLocationByCountryNameGen geoLocationByCountryNameGen = new GeoLocationByCountryNameGen();
		geoLocationByCountryNameGen.gen(args[0],args[1]);
	}

	public void gen(String input, String output) throws Exception{
		  CloseableHttpClient httpClient = null;

		  StringBuilder resultCSV = new StringBuilder();
		  try{
			  List<String> countries = getCountryNamesAsList(new File(input));
			  resultCSV.append("COUNTRY");
			  resultCSV.append(";");
			  resultCSV.append("LAT");
			  resultCSV.append(";");
			  resultCSV.append("LNG");
			  resultCSV.append("\n");
			  for(String countryname:countries){
				  StringBuilder result = new StringBuilder();
				  httpClient = HttpClients.createDefault();

	    			HttpGet getRequest = new HttpGet("http://maps.google.com/maps/api/geocode/json?components=country:"+java.net.URLEncoder.encode(countryname, "UTF-8").toString()+"&sensor=false");
	    			getRequest.addHeader("accept", "application/json");
	    	 
	    			HttpResponse response = httpClient.execute(getRequest);
	    	 
	    			if (response.getStatusLine().getStatusCode() != 200) {
	    				throw new RuntimeException("Failed : HTTP error code : "
	    				   + response.getStatusLine().getStatusCode());
	    			}
	    	 
	    			BufferedReader br = new BufferedReader(
	    	                         new InputStreamReader((response.getEntity().getContent())));
	    	 
	    			String out;
	    			System.out.println("Output from Server .... \n");
	    			while ((out = br.readLine()) != null) {
	    				result.append(out);
	    			}
		    	 Gson gson = new GsonBuilder().create();
		    	 JsonReader reader = new JsonReader(new StringReader(result.toString()));
		    	 reader.setLenient(true);
	    		 GoogleGeoJson googleGeo =  gson.fromJson(reader,GoogleGeoJson.class);
	    		 if(googleGeo.getResults()==null || googleGeo.getResults().length==0){
	    			 continue;
	    		 }
	    		 resultCSV.append(countryname);
	    		 resultCSV.append(";");
	    		 resultCSV.append(googleGeo.getResults()[0].getGeometry().getLocation().getLat());
	    		 resultCSV.append(";");
	    		 resultCSV.append(googleGeo.getResults()[0].getGeometry().getLocation().getLng());
	    		 resultCSV.append("\n");
			}
		  }catch(Exception e){
			  throw new RuntimeException(e.getMessage(),e);
		  }finally{
			  httpClient.close();
		  }
		  FileUtils.writeStringToFile(new File(output),resultCSV.toString(),"UTF-8");
	  }

	public static List<String> getCountryNamesAsList(File f)
			throws FileNotFoundException {
		List<String> resultList = new ArrayList<String>();
		for (Scanner sc = new Scanner(f); sc.hasNext();) {
			String line = null;
			while (sc.hasNext()) {
				line = sc.nextLine();
				resultList.add(line.split(";")[1]);
			}
		}

		return resultList;
	}

	

}
