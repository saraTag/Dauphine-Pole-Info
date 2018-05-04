package io.github.oliviercailloux.y2018;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentsPreference {

	private Map<Person, Set<RawPreference>> studPref;

	public StudentsPreference() {
		studPref = new HashMap<>();
	}

	public Map<Person, Set<RawPreference>> getStudPref() {
		return this.studPref;
	}

	public void addPref(Person student, RawPreference pref) {
		studPref.get(student).add(pref);
	}

	public Set<RawPreference> getPreference(Person student) {
		return studPref.get(student);
	}

}
