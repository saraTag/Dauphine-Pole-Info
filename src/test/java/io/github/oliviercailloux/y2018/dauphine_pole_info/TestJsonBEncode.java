package io.github.oliviercailloux.y2018.dauphine_pole_info;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Optional;
import java.util.Scanner;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.ClassLoaderUtil;


public class TestJsonBEncode {
	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(TestJsonBEncode.class);
	
	@Test
	public void TestEncodePersonToJson() throws Exception {
		String res="";
		Person per = new Person();
		per.setFirstname("lahsen");
		per.setLastname("jannani");
		per.setEmail("lahsen.jannani@gmil.com");
		per.setPhone("0645326754");

		URL fileUrl = getClass().getResource("/Person.json");
		BufferedReader in = new BufferedReader(new InputStreamReader(fileUrl.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			 res+=inputLine+"\n";
		}
		int truncateIndex = res.length();
		truncateIndex = res.lastIndexOf('\n', truncateIndex - 1);
		String ressub = res.substring(0, truncateIndex);
		in.close();	
		String result=per.toJson();
		assertEquals(result,ressub);
		
	}
	@Test
	public void TestEncodeContentToJson() throws Exception {
		String res="";
		Content cont = new Content();
		cont.setName("name");
		cont.setHourlyVolume(356);
		cont.setEtcs(3);
		cont.setProjectVolume(4);
		URL fileUrl = getClass().getResource("/Content.json");
		BufferedReader in = new BufferedReader(new InputStreamReader(fileUrl.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			 res+=inputLine+"\n";
		}
		int truncateIndex = res.length();
		truncateIndex = res.lastIndexOf('\n', truncateIndex - 1);
		String ressub = res.substring(0, truncateIndex);
		in.close();	
		String result2=cont.toJson();
		assertEquals(result2,ressub);
		}
	
	@Test
	public void TestEncodeMasterToJson() throws Exception {
		String res="";
		Master mast = new Master();
		mast.setName("name");
		mast.setDescription("master");
		URL fileUrl = getClass().getResource("/Master.json");
		BufferedReader in = new BufferedReader(new InputStreamReader(fileUrl.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			 res+=inputLine+"\n";
		}
		int truncateIndex = res.length();
		truncateIndex = res.lastIndexOf('\n', truncateIndex - 1);
		String ressub = res.substring(0, truncateIndex);
		in.close();	
		String result2=mast.toJson();
		assertEquals(result2,ressub);
		}
	
	}


