package com.soundwave.massgen;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

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
public class PlayActionRandomGen {

	@Autowired
	private PlayDAO playDao;
	
	private static final String XYZ_V = "XYZ v_";
	private static final String ANDROID_X_X = "Android x.x.";
	private static final String PLAY = "PLAY";
	
	public static void main(String[] args) {
		System.out.println("started");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("./src/main/resources/applicationContext.xml");
		PlayActionRandomGen playActionRandomGen = (PlayActionRandomGen) ctx.getBean(PlayActionRandomGen.class.getSimpleName());
		String songPath = args[0];
		String latLngPath = args[1]; 
		long seed  = new Long(args[2]);
		playActionRandomGen.gen(songPath,latLngPath,seed);
		System.out.println("finished");
	}


	public void gen(String songPath, String latLngPath,long seed) {
		try{
			/**
			 * 		//SIZE OF THE UNIVERSE -> 175000000
					//HETEROGENEITY -> 50%
					//MARGIN OF ERROR -> 5%
					//CONFIDENCE LEVEL -> 95%
					//SAMPLE -> 385
			 */
					for(int i=0;i<=385;i++){
						Play play = new Play();
						play.setActionType(PLAY);
						String anyDayFromTheLastTwoYears = RandomDateDataUtil.getFormatedAnyDayFromTheLastTwoYears(seed);
						play.setCreateTime(anyDayFromTheLastTwoYears);
						play.setTime(anyDayFromTheLastTwoYears);
						Random r = new Random();
						r.setSeed(seed);
						int randomInt = r.nextInt(385^2) + 1;
						String id = Integer.toString(randomInt);
						play.setUserId(id);
						play.setLocation(getLocation(latLngPath,seed));
						play.setSong(getSong(songPath,seed));
						play.setSource(getSource(seed));
						
						//Gson gson = new GsonBuilder().create();
						//String jsonStr = gson.toJson(play);
						//FileUtils.writeStringToFile(new File("src/main/resources/sample/"+id+".json"),jsonStr,"UTF-8");
						//playDao.insert(play);
						ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("./src/main/resources/applicationContext.xml");
						PlayDAO dao = (PlayDAO) ctx.getBean(PlayDAO.class.getSimpleName());
						dao.insert(play);
						//playDao.insert(play);
						//insertWithoutSpring(play,seed);
					}
					

		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e);
		}
	}

//	private void insertWithoutSpring(Play play, long seed) {
//		PlayDAO dao = new PlayDAO();
//		dao.insertWithoutSpring(play, seed);
//		
//	}


	private Source getSource(long seed) {
		Source source = new Source();
		Random rand= new Random();
		rand.setSeed(seed);
		source.setAutoPlay(rand.nextBoolean());
		source.setBackgrounded(rand.nextBoolean());
		int sourceNameInt = rand.nextInt(SourceNamesEnum.values().length);
		source.setPlatform(ANDROID_X_X+sourceNameInt);
		source.setName(SourceNamesEnum.get(sourceNameInt).name());
		source.setDevice(XYZ_V+sourceNameInt);
		return source;
	}

	private Song getSong(String songPath, long seed) {
		Song song = new Song();
		song.setArtist(RandomSongDataUtil.getSoundSample(songPath,seed)[4]);
		song.setTitle(RandomSongDataUtil.getSoundSample(songPath,seed)[5]);
		return song;
	}

	private Location getLocation(String latLngPath, long seed) {
		String[] result = RandomCountryLatLngDataUtil.choose(latLngPath,seed);
		Location location = new Location();
		location.setCountry(result[0]);
		location.setLat(result[1]);
		location.setLon(result[2]);
		return location;
	}
	

}
