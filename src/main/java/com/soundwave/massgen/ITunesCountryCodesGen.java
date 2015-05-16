package com.soundwave.massgen;

import com.soundwave.model.itunessalesdata.ITunesDigitalSalesData;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class ITunesCountryCodesGen {
	public void gen(String output) {
		try {
			List<ITunesDigitalSalesData> result = new ArrayList();
			ITunesDigitalSalesData itunesCountriesCode = null;

			StringBuffer sb = new StringBuffer();
			sb.append("COUNTRY_CODE");
			sb.append(";");
			sb.append("COUNTRY_NAME");
			sb.append("\n");

			Document doc = Jsoup
					.connect("http://www.digitalsalesdata.com/diydsd.php")
					.postDataCharset("UTF-8").timeout(0).get();

			Elements options = doc.select("select > option");
			for (Element element : options) {
				String countryName = "";
				String countryNumber = "";
				if (!"<Select>".equals(element.text())) {
					if (element.text().contains("&")) {
						countryName = element.text().replace("&", "and");
					}
					if ((element.text().contains("("))
							&& (element.text().contains(")"))) {
						countryName = element.text().substring(
								element.text().indexOf("(") + 1,
								element.text().indexOf(")"));
					}
					if ((countryName == null) || ("".equals(countryName))) {
						countryName = element.text();
					}
					countryNumber = element.attr("value");

					sb.append(countryNumber);
					sb.append(";");
					sb.append(countryName);
					sb.append("\n");
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
		ITunesCountryCodesGen itunesCountryCodesGen = new ITunesCountryCodesGen();
		itunesCountryCodesGen.gen(args[0]);
	}
}