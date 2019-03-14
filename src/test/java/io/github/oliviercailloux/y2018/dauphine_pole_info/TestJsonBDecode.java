package io.github.oliviercailloux.y2018.dauphine_pole_info;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class TestJsonBDecode {
	
	@Test	
	public void TestDecodePerson() throws Exception {
		String JsonR = "\n{\n    \"id\": 1,\n    \"firstname\": \"lahsen\",\n    \"lastname\": \"jannani\",\n    \"email\": \"lahsen.jannani@gmail.com\",\n    \"phone\": \"0645326754\",\n    \"fax\": \"fax\",\n    \"cv\": \"\",\n    \"note\": \"\",\n    \"role\": \"adm\",\n    \"address\": \"pantin\",\n    \"mobile\": \"\",\n    \"temporary\": \"\",\n    \"year_master\": 0,\n    \"home_page\": \"\",\n    \"password\": \"pwd\"\n}";
		Person per = new Person();
		Person pers = new Person();
		pers=per.fromJson(JsonR);
		assertEquals(1, pers.getId());
		assertEquals("lahsen", pers.getFirstname());
		assertEquals("jannani", pers.getLastname());
	}

	@Test	
	public void TestDecodeContent() throws Exception {
		String JsonR = "\n{\n    \"id\": 1,\n    \"name\": \"name\",\n    \"hourlyVolume\": 38,\n    \"etcs\": 4.0,\n    \"projectVolume\": 5\n}";
		Content cont = new Content();
		Content conts = new Content();
		conts = cont.jsonToContenu(JsonR);
		assertEquals(1, conts.getId());
		assertEquals("name", conts.getName());
	}
}
