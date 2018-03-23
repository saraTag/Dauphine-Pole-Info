package io.github.oliviercailloux.y2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.*;

/**
 * Please note that this only a temporary solution, pending the creation
 * of the real database.
 * This was done based on the model given in the CDI FakeDB sample.
 */

@ApplicationScoped
public class DatabaseManager {
	private Map<Integer,Course> coursesById;
	private Map<Integer,Person> personsById;
	private Map<Integer,ArrayList<RawPreference>> preferencesByStudentId = new HashMap<>();
	private Map<Integer,ArrayList<RawPreference>> preferencesByCourseId = new HashMap<>();
	
	public DatabaseManager() {
		//init();
		coursesById = new HashMap<>();
		personsById = new HashMap<>();
		personsById.put(1, new Person(1, "Tuti", "Dudi"));
		personsById.put(2, new Person(2, "Toto", "Dodo"));
	}
	
	public Map<Integer,Course> getCoursesById() {
		return coursesById;
	}
	
	public Map<Integer,	Person> getPersonsById() {
		return personsById;
	}
	
	public boolean updateCourse(int id,Course course) {
		coursesById.put(id, course);
		return true;
	}
	
	public boolean updatePerson(int id, Person person) {
		personsById.put(id, person);
		return true;
	}
	
	public ArrayList<RawPreference> getPreferencesByStudentId(int id){
		return preferencesByStudentId.get(id);
	}
	
	public ArrayList<RawPreference> getPreferencesByCourseId(int id){
		return preferencesByCourseId.get(id);
	}
	
	public boolean setPreference(int studentId,RawPreference preference) {
		preferencesByStudentId.get(studentId).add(preference);
		return true;
	}
	
	private void init() {
		coursesById.put(1, new Course("2017", true, "Python"));
		coursesById.put(2, new Course("2018", true, "Java"));
		personsById.put(1, new Person(1, "Tuti", "Dudi"));
		personsById.put(2, new Person(2, "Toto", "Dodo"));
	}
}
