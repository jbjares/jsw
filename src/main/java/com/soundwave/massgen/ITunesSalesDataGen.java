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
import org.springframework.stereotype.Service;

import com.soundwave.model.itunessalesdata.ITunesDigitalSalesData;

@Service
public class ITunesSalesDataGen {
	public void gen(String input, String output) {
		try {
			List<ITunesDigitalSalesData> result = new ArrayList();
			ITunesDigitalSalesData itunesDigitalSalesData = null;
			String iTunesFilePath = input;
			FileInputStream fis = null;
			if ((iTunesFilePath == null) || ("".equals(iTunesFilePath))) {
				throw new RuntimeException(
						"Please, input the filepath argument.");
			}
			fis = new FileInputStream(new File(iTunesFilePath));

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					fis));
			reader.readLine();

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
			String line;
			String countryNumber;
			String country;
			while ((line = reader.readLine()) != null) {
				String[] lineAttributes = line.split(";");

				countryNumber = lineAttributes[0];
				country = lineAttributes[1];

				Document doc = Jsoup
						.connect(
								"http://www.digitalsalesdata.com/diydsd.php?Region="
										+ countryNumber)
						.postDataCharset("UTF-8").timeout(0).get();
				for (Element table : doc.select("div").select("table")) {
					for (Element row : table.select("tr")) {
						Elements tds = row.select("td");
						if (tds.size() > 0) {
							if (!"RANK".equals(((Element) tds.get(0)).text())) {
								sb.append(countryNumber);
								sb.append(";");
								sb.append(country);
								sb.append(";");
								sb.append(new SimpleDateFormat("dd/MM/yyyy")
										.format(new Date()));
								sb.append(";");
								sb.append(((Element) tds.get(0)).text());
								sb.append(";");
								sb.append(((Element) tds.get(1)).text());
								sb.append(";");
								sb.append(((Element) tds.get(2)).text());
								sb.append(";");
								sb.append(((Element) tds.get(3)).text());
								sb.append("\n");
							}
						}
					}
				}
			}
			String iTunesFilePathResult = output;
			FileUtils.writeStringToFile(new File(iTunesFilePathResult),
					sb.toString(), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static void main(String[] args) throws Exception {
		ITunesSalesDataGen itunesSalesDataGen = new ITunesSalesDataGen();
		itunesSalesDataGen.gen(args[0], args[1]);
	}
}
