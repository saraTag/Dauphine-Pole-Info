package io.github.oliviercailloux.y2018;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;


public class StudentsPreferenceTest {
		
	public Person student;
	public Set<RawPreference> les_preferences;
	public StudentsPreference oneStudentPreference;
	
	public StudentsPreferenceTest() {
		this.student = new Person(1, "firstname", "lastname");
		this.les_preferences = null;
		RawPreference pref = new RawPreference(100);
		les_preferences.add(pref);
		this.oneStudentPreference = new StudentsPreference(this.student,this.les_preferences);
	}
	
	@Test
	public void getStudPrefTest() {
		assertEquals(this.les_preferences,this.oneStudentPreference.getStudPref());
	}
}
