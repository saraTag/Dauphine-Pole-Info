package io.github.oliviercailloux.y2018.dauphine_pole_info;

import static org.junit.Assert.assertEquals;

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
		@SuppressWarnings("unused")
		final Logger LOGGER = LoggerFactory.getLogger(TestJsonBEncode.class);
		final Person per = new Person(1,"lahsen","jannani","lahsen.jannani@gmail.com","0645326754","fax","","","","pwd","adm","pantin","","");
		try (Jsonb jsonb = JsonbBuilder.create(new JsonbConfig().withFormatting(true))) {
			final String json = jsonb.toJson(per);
			LOGGER.info("Serialized pretty json: {}.", json);
			assertEquals("\n{\n    \"id\": 1,\n    \"firstname\": \"lahsen\",\n    \"lastname\": \"jannani\",\n    \"email\": \"lahsen.jannani@gmail.com\",\n    \"phone\": \"0645326754\",\n    \"fax\": \"fax\",\n    \"cv\": \"\",\n    \"note\": \"\",\n    \"role\": \"adm\",\n    \"address\": \"pantin\",\n    \"mobile\": \"\",\n    \"temporary\": \"\",\n    \"year_master\": 0,\n    \"home_page\": \"\",\n    \"password\": \"pwd\"\n}", json);
			
		}
		
	}
	@Test	
	public void TestEncodeContentToJson() throws Exception {
		
		@SuppressWarnings("unused")
		final Logger LOGGER = LoggerFactory.getLogger(TestJsonBEncode.class);
		Content cont = new Content(1,"name",Optional.of("description"),Optional.of("training"),38,4,5,Optional.of("objectives"),Optional.of("contents"),Optional.of("biblio"));
		try (Jsonb jsonb = JsonbBuilder.create(new JsonbConfig().withFormatting(true))) {
			final String json = jsonb.toJson(cont);
			LOGGER.info("Serialized pretty json: {}.", json);
			assertEquals("\n{\n    \"id\": 1,\n    \"name\": \"name\",\n    \"description\": \"description\",\n    \"training\": \"training\",\n    \"hourlyVolume\": 38,\n    \"etcs\": 4.0,\n    \"projectVolume\": 5,\n    \"objectives\": \"objectives\",\n    \"contents\": \"contents\",\n    \"biblio\": \"biblio\"\n}", json);
		}
	}

}
