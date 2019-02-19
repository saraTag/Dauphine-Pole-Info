package io.github.oliviercailloux.y2018;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



import org.junit.Before;
import org.junit.Test;

import com.sun.istack.NotNull;

public class StudentsPreferenceTest {
	public Person student;
	public Set<RawPreference> les_preferences;
	public StudentsPreference oneStudentPreference;

	@Before
	@NotNull
	public void setUp() throws Exception {
		this.student = new Person(1, "firstname", "lastname");
		RawPreference pref = new RawPreference(100);
		this.les_preferences = new HashSet<RawPreference>(Arrays.asList(pref));
		this.oneStudentPreference = new StudentsPreference(student, les_preferences);
		
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
		this.oneStudentPreference.addPref(this.student,pref);
		assertEquals(1, this.oneStudentPreference.getStudPref().size());
		assertEquals(2, this.oneStudentPreference.getPreference(student).size());
		}

	@Test
	public void studentsPreferenceToJson() {
		/*String jsonResult = this.oneStudentPreference.studentsPreferenceToJson();
		//assertNotNull(jsonResult);
		System.out.println(jsonResult);

		StudentsPreference testDecodeTest = this.oneStudentPreference.jsonToStudentsPreference(jsonResult);
		//assertNotNull(testDecodeTest);
		//assertEquals(testDecodeTest, this.oneStudentPreference);*/
	}

}
