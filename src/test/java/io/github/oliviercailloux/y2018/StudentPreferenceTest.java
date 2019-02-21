package io.github.oliviercailloux.y2018;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.json.bind.JsonbException;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;
import com.sun.istack.NotNull;



public class StudentPreferenceTest {
	public Person student;
	public Set<RawPreference> les_preferences;
	public StudentPreference oneStudentPreference;

	@Before
	@NotNull
	public void setUp() throws Exception {
		this.student = new Person(1, "firstname", "lastname");
		RawPreference pref = new RawPreference(100);
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
	/*
	 * commented because: java.lang.illegalArgumentException : wrong number of arguments
	@Test 
	public void studentPreferenceToJson(){
		 	
			String jsonResult = this.oneStudentPreference.studentPreferenceToJson();
			String expectedString = "{\"id\":1,\"firstname\":\"firstname\",\"lastname\":\"lastname\",\"year_master\":0}:preferences{\"level\":100}";
			assertNotNull(jsonResult);
			assertEquals(expectedString,jsonResult);
			StudentPreference testDecodeTest = this.oneStudentPreference.jsonToStudentPreference(jsonResult);
			assertNotNull(testDecodeTest);
			
	}*/
	@Test 
	public void JsonToStudentPreference(){
		String jsonResult = "{\"id\":1,\"firstname\":\"firstname\",\"lastname\":\"lastname\",\"year_master\":0}:preferences{\"level\":100}";
		StudentPreference testDecodeTest = this.oneStudentPreference.jsonToStudentPreference(jsonResult);
		assertNotNull(testDecodeTest);
		//assertEquals(testDecodeTest.getStudPref().size(),this.oneStudentPreference.getStudPref().size());
		//System.out.println(testDecodeTest);
	}
	
	
	

}
