package com.soundwave.massgen;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.soundwave.model.itunessalesdata.ITunesDigitalSalesData;

public class ITunesSalesDataGen implements GenInterface{
	
	public void gen() throws Exception{
		List<ITunesDigitalSalesData> result = new ArrayList<ITunesDigitalSalesData>();
		ITunesDigitalSalesData itunesDigitalSalesData = null;
		FileInputStream fis = new FileInputStream(getClass().getClassLoader().getResource("iTunesCodesAndCountries.csv").getFile());

            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            reader.readLine();
            String line;
            CsvSchema csvSchema = CsvSchema.builder()
                    .addColumn("name")
                    .addColumn("description")
                    .setUseHeader( true )
                    .build()
                    .withLineSeparator("\r\n");

            StringBuffer sb = new StringBuffer();
            sb.append("ID");
            sb.append(";");
            sb.append("COUNTRY");
            sb.append(";");
            sb.append("DATE");
            sb.append(";");
            sb.append("RANK");
            sb.append(";");
            sb.append("ARTIST");
            sb.append(";");
            sb.append("TITLE");
            sb.append(";");
            sb.append("SALES");
            sb.append("\n");
            while ((line = reader.readLine()) != null) {
            	
            	String[] lineAttributes = line.split(";");
            	
            	String countryNumber = lineAttributes[0];
            	String country = lineAttributes[1];
            	
                Document doc = Jsoup.connect("http://www.digitalsalesdata.com/diydsd.php?Region="+countryNumber).postDataCharset("UTF-8").timeout(0).get();
                
                for (Element table : doc.select("div").select("table")) {
                    for (Element row : table.select("tr")) {
                        Elements tds = row.select("td");
                        if (tds.size() > 0) {
//                        	itunesDigitalSalesData = new ITunesDigitalSalesData();
//                        	itunesDigitalSalesData.setId(countryNumber);
//                        	itunesDigitalSalesData.setCountry(country);
//                        	itunesDigitalSalesData.setDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
//                        	itunesDigitalSalesData.setRank(tds.get(0).text());
//                        	itunesDigitalSalesData.setArtist(tds.get(1).text());
//                        	itunesDigitalSalesData.setTitle(tds.get(2).text());
//                        	itunesDigitalSalesData.setSales(tds.get(3).text());
//                        	result.add(itunesDigitalSalesData);
                        	if("RANK".equals(tds.get(0).text())){
                        		continue;
                        	}
                        	
                        	sb.append(countryNumber);
                        	sb.append(";");
                        	sb.append(country);
                        	sb.append(";");
                        	sb.append(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
                        	sb.append(";");
                        	sb.append(tds.get(0).text());
                        	sb.append(";");
                        	sb.append(tds.get(1).text());
                        	sb.append(";");
                        	sb.append(tds.get(2).text());
                        	sb.append(";");
                        	sb.append(tds.get(3).text());
                        	sb.append("\n");
                        }
                    }
                }
                
            }
            FileUtils.writeStringToFile(new File("src/main/resources/itunessalesdata2.csv"),sb.toString(),"UTF-8");
	}

	public static void main(String[] args) throws Exception {
		new ITunesSalesDataGen().gen();
	}
	
}
