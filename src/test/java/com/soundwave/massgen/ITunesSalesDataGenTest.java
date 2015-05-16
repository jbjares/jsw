package com.soundwave.massgen;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ITunesSalesDataGenTest {

	@Autowired
	private ITunesSalesDataGen iTunesSalesDataGen;
	
	@Test
	public void testPlayDI(){
		Assert.assertNotNull(iTunesSalesDataGen);
	}
	
	@Ignore
	@Test
	public void testGen() throws Exception{
		System.out.println("started");
		iTunesSalesDataGen.gen("src/main/resources/iTunesCodesAndCountries.csv","src/main/resources/itunessalesdata2.csv");
		System.out.println("finished");
	}
	
}
