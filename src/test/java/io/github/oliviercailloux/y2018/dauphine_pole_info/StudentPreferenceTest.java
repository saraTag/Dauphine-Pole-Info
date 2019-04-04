package io.github.oliviercailloux.y2018.dauphine_pole_info;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;


import org.junit.Before;
import org.junit.Test;
import com.google.common.collect.ImmutableSet;
import com.sun.istack.NotNull;

import io.github.oliviercailloux.y2018.dauphine_pole_info.Master;
import io.github.oliviercailloux.y2018.dauphine_pole_info.Person;
import io.github.oliviercailloux.y2018.dauphine_pole_info.RawPreference;
import io.github.oliviercailloux.y2018.dauphine_pole_info.StudentPreference;

public class StudentPreferenceTest {
	public Person student;
	public Set<RawPreference> les_preferences;
	public StudentPreference oneStudentPreference;

	@Before
	@NotNull
	public void setUp() throws Exception {
		this.student = new Person(1, "firstname", "lastname");
		RawPreference pref = new RawPreference(100);
		Master master = new Master(1, "SITN", "Description");
		pref.setMaster(master);
		List<RawPreference> preferences = new ArrayList<RawPreference>();
		preferences.add(pref);
		this.les_preferences = new HashSet<RawPreference>(ImmutableSet.copyOf(preferences));
		this.oneStudentPreference = new StudentPreference(student, les_preferences);

	}

	@Test
	public void testInit() {
		assertEquals(1, oneStudentPreference.getStudPref().size());
	}

	@Test
	public void getStudPrefTest() {

		assertEquals(1, this.oneStudentPreference.getStudPref().size());
		assertEquals(this.les_preferences.size(), this.oneStudentPreference.getStudPref().size());
	}

	@Test
	public void addPrefTest() {
		RawPreference pref = new RawPreference(200);
		this.oneStudentPreference.addPref(student, pref);
		assertEquals(1, this.oneStudentPreference.getStudPref().size());

	}

	@Test
	public void getPreferenceTest() {
		RawPreference pref = new RawPreference(200);
		this.oneStudentPreference.addPref(student, pref);
		assertEquals(2, this.oneStudentPreference.getPreference(student).size());
	}

	@Test
	public void hasPreferenceWithDistinctLevelsTest() {
		RawPreference pref = new RawPreference(100);
		this.oneStudentPreference.addPref(student, pref);
		assertFalse(this.oneStudentPreference.hasPreferenceWithDistinctLevels(student));
	}

	@Test
	public void studentPreferenceToJson() {

		String jsonResult = this.oneStudentPreference.studentPreferenceToJson();
		assertNotNull(jsonResult);

		JsonReader reader = Json.createReader(new StringReader(jsonResult));
		JsonObject jsonObject = reader.readObject();
		assertTrue(jsonObject.containsKey("studentPreference"));

		String jsonExpected = "{\"studentPreference\":[{\"person\":\"\\n{\\n    \\\"id\\\": 1,\\n    \\\"firstname\\\": \\\"firstname\\\",\\n    \\\"lastname\\\": \\\"lastname\\\",\\n    \\\"year_master\\\": 0\\n}\"},[{\"preference\":\"{\\\"master\\\":{\\\"id\\\":1,\\\"name\\\":\\\"SITN\\\",\\\"description\\\":\\\"Description\\\"},\\\"level\\\":100}\"}]]}";
		assertEquals(jsonExpected, jsonObject.toString());

	}

	@Test
	public void JsonToStudentPreference() {
		String jsonResult = "{\"studentPreference\":[{\"person\":\"{\\\"id\\\":1,\\\"firstname\\\":\\\"firstname\\\",\\\"lastname\\\":\\\"lastname\\\",\\\"year_master\\\":0}\"},[{\"preference\":\"{\\\"master\\\":{\\\"id\\\":1,\\\"name\\\":\\\"SITN\\\",\\\"description\\\":\\\"Description\\\"},\\\"level\\\":100}\"}]]}";
		StudentPreference testDecodeTest = StudentPreference.jsonToStudentPreference(jsonResult);
		assertNotNull(testDecodeTest);
		
	}

}
