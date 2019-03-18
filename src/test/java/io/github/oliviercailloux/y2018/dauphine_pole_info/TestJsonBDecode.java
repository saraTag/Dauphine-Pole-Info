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
		Person per = new Person();
		per.setId(1);
		per.setFirstname("lahsen");
		per.setLastname("jannani");
		per.setEmail("lahsen.jannani@gmil.com");
		per.setPhone("0645326754");
		String result=per.toJson();
		per=per.fromJson(result);
		assertEquals(1, per.getId());
		assertEquals("lahsen", per.getFirstname());
		assertEquals("jannani", per.getLastname());
		
	}
	@Test
	public void TestDecodeContent() throws Exception {
		
		Content cont = new Content();
		cont.setId(1);
		cont.setName("name");
		cont.setHourlyVolume(356);
		cont.setEtcs(3);
		cont.setProjectVolume(4);
		String result=cont.ToJson();
		cont=cont.FromJson(result);
		assertEquals(1, cont.getId());
		assertEquals("name", cont.getName());
	}

	
}
