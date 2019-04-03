package io.github.oliviercailloux.y2018.dauphine_pole_info;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class TestJsonBDecode {
	
	@Test
	public void TestDecodePerson() throws Exception {
		String res="";
		Person per = new Person();
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
		per=per.fromJson(ressub);
		assertEquals("lahsen",per.getFirstname());
		assertEquals("jannani",per.getLastname());
		assertEquals("lahsen.jannani@gmil.com",per.getEmail());
		assertEquals("0645326754",per.getPhone());
	}
	@Test
	public void TestDecodeContent() throws Exception {
		
		String res="";
		Content cont = new Content();
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
		cont=cont.fromJson(ressub);
		assertEquals("name", cont.getName());
		assertEquals(356, cont.getHourlyVolume());
	}

	
}
