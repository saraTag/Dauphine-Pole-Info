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
	private Map<Integer,Course> coursesById = new HashMap<>();
	private Map<Integer,Person> personsById = new HashMap<>();
	private Map<Integer,ArrayList<Preference>> preferencesByStudentId = new HashMap<>();
	private Map<Integer,ArrayList<Preference>> preferencesByCourseId = new HashMap<>();
	
	public DatabaseManager() {
		init();
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
	
	public ArrayList<Preference> getPreferencesByStudentId(int id){
		return preferencesByStudentId.get(id);
	}
	
	public ArrayList<Preference> getPreferencesByCourseId(int id){
		return preferencesByCourseId.get(id);
	}
	
	public boolean setPreference(int studentId,Preference preference) {
		preferencesByStudentId.get(studentId).add(preference);
		return true;
	}
	
	private void init() {
		coursesById.put(1, new Course());
		coursesById.put(2, new Course("2017", true, "Java"));
		coursesById.put(3, new Course());
		personsById.put(1, new Person());
		personsById.put(2, new Person(2, "Tuti", "Dudi"));
		personsById.put(3, new Person());
	}
}
