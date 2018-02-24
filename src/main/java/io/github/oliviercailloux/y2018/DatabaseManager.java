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
	private Map<Integer,Course> coursesById = new HashMap<>();
	private Map<Integer,Person> personsById = new HashMap<>();
	
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
	
	public boolean updatePersonne(int id, Person person) {
		personsById.put(id, person);
		return true;
	}
	
	private void init() {
		coursesById.put(1, new Course());
		coursesById.put(2, new Course());
		coursesById.put(3, new Course());
		personsById.put(1, new Person());
		personsById.put(2, new Person());
		personsById.put(3, new Person());
	}
}
