package com.soundwave.massgen;


import java.io.File;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.soundwave.dao.PlayDAO;
import com.soundwave.model.enumeration.SourceNamesEnum;
import com.soundwave.model.playaction.Location;
import com.soundwave.model.playaction.Play;
import com.soundwave.model.playaction.Song;
import com.soundwave.model.playaction.Source;
import com.soundwave.util.RandomCountryLatLngDataUtil;
import com.soundwave.util.RandomDateDataUtil;
import com.soundwave.util.RandomSongDataUtil;

@Service
public class PlayActionRandomGen implements GenInterface{

	@Autowired
	private PlayDAO playDao;
	
	private static final String XYZ_V = "XYZ v_";
	private static final String ANDROID_X_X = "Android x.x.";
	private static final String PLAY = "PLAY";
	


	public void gen() throws Exception {
		//SIZE OF THE UNIVERSE -> 175000000
		//HETEROGENEITY -> 50%
		//MARGIN OF ERROR -> 5%
		//CONFIDENCE LEVEL -> 95%
		//SAMPLE -> 385
		for(int i=0;i<=385;i++){
			Play play = new Play();
			play.setActionType(PLAY);
			String anyDayFromTheLastTwoYears = RandomDateDataUtil.getFormatedAnyDayFromTheLastTwoYears();
			play.setCreateTime(anyDayFromTheLastTwoYears);
			play.setTime(anyDayFromTheLastTwoYears);
			String id = UUID.randomUUID().toString();
			play.setUserId(id);
			play.setLocation(getLocation());
			play.setSong(getSong());
			play.setSource(getSource());
			
			Gson gson = new GsonBuilder().create();
			String jsonStr = gson.toJson(play);
			//FileUtils.writeStringToFile(new File("src/main/resources/sample/"+id+".json"),jsonStr,"UTF-8");
			playDao.insert(play);
		}
		
	}

	private Source getSource() {
		Source source = new Source();
		source.setAutoPlay(new Random().nextBoolean());
		source.setBackgrounded(new Random().nextBoolean());
		int sourceNameInt = new Random().nextInt(SourceNamesEnum.values().length);
		source.setPlatform(ANDROID_X_X+sourceNameInt);
		source.setName(SourceNamesEnum.get(sourceNameInt).name());
		source.setDevice(XYZ_V+sourceNameInt);
		return source;
	}

	private Song getSong() {
		Song song = new Song();
		song.setArtist(RandomSongDataUtil.getSoundSample()[4]);
		song.setTitle(RandomSongDataUtil.getSoundSample()[5]);
		return song;
	}

	private Location getLocation() {
		String[] result = RandomCountryLatLngDataUtil.choose();
		Location location = new Location();
		location.setCountry(result[0]);
		location.setLat(result[1]);
		location.setLon(result[2]);
		return location;
	}
	

}
