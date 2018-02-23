package io.github.oliviercailloux.y2018;

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
	private Map<Integer,Cours> coursesById = new HashMap<>();
	private Map<Integer,Person> personsById = new HashMap<>();
	
	public DatabaseManager() {
		init();
	}
	
	public Map<Integer,Cours> getCoursesById() {
		return coursesById;
	}
	
	public Map<Integer,	Person> getPersonsById() {
		return personsById;
	}
	
	public boolean updateCourse(int id,Cours course) {
		coursesById.put(id, course);
		return true;
	}
	
	public boolean updatePersonne(int id, Person person) {
		personsById.put(id, person);
		return true;
	}
	
	private void init() {
		coursesById.put(1, new Cours());
		coursesById.put(2, new Cours());
		coursesById.put(3, new Cours());
		personsById.put(1, new Person());
		personsById.put(2, new Person());
		personsById.put(3, new Person());
	}
}
