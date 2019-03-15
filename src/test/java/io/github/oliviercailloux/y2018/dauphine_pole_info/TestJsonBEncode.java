package io.github.oliviercailloux.y2018.dauphine_pole_info;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Optional;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestJsonBEncode {
	@Test
	public void TestEncodePersonToJson() throws Exception {
		Person per = new Person();
		Person per2 = new Person();
		String url = "src\\test\\resources\\Person.json";
		per.setId(1);
		per.setFirstname("lahsen");
		per.setLastname("jannani");
		per.setEmail("lahsen.jannani@gmil.com");
		per.setPhone("0645326754");
		per.toJson(per,url );
		per2=per2.fromJson(url);
		assertEquals(per.getId(), per2.getId());
		assertEquals(per.getFirstname(), per2.getFirstname());
		assertEquals(per.getLastname(), per2.getLastname());
		assertEquals(per.getPhone(), per2.getPhone());
		
		
	}
	@Test	
	public void TestEncodeContentToJson() throws Exception {
		Content cont = new Content();
		Content cont2 = new Content();
		String url = "src\\test\\resources\\Content.json";
		cont.setId(1);
		cont.setName("name");
		cont.setHourlyVolume(356);
		cont.setEtcs(3);
		cont.setProjectVolume(4);
		cont.contenuToJson(cont,url);
		cont2=cont2.jsonToContenu(url);
		assertEquals(cont.getId(), cont2.getId());
		assertEquals(cont.getName(), cont2.getName());
		assertEquals(cont.getHourlyVolume(), cont2.getHourlyVolume());
		assertEquals(cont.getProjectVolume(), cont2.getProjectVolume());
		}
	
	}


