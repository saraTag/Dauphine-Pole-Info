package io.github.oliviercailloux.y2018.dauphine_pole_info;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class TestJsonBDecode {
	
	@Test	
	public void TestDecodePerson() throws Exception {
		String url = "src\\test\\resources\\Person.json";
		Person pers = new Person();
		pers=pers.fromJson(url);
		assertEquals(1, pers.getId());
		assertEquals("lahsen", pers.getFirstname());
		assertEquals("jannani", pers.getLastname());
	}
	@Test	
	public void TestDecodeContent() throws Exception {
		String url = "src\\test\\resources\\Content.json";
		Content conts = new Content();
		conts=conts.jsonToContenu(url);
		assertEquals(1, conts.getId());
		assertEquals("name", conts.getName());
	}

}
