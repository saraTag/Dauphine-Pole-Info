package io.github.oliviercailloux.y2018;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.google.common.base.Strings;

public class StudentsPreference {

	private Map<Person, Set<RawPreference>> studPref;
	
	private static Jsonb jsonb = JsonbBuilder.create();

	public StudentsPreference() {
		studPref = new HashMap<>();
	}
	
	public StudentsPreference(Person student, Set<RawPreference> les_preferences) {
		this.studPref = new HashMap<>();
		this.studPref.put(student, les_preferences);
				
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
	
	public String studentsPreferenceToJson() {
		return jsonb.toJson(this);
	}
	
	public static StudentsPreference jsonToStudentsPreference(String jsonPreference) {
		return jsonb.fromJson(Strings.nullToEmpty(jsonPreference), StudentsPreference.class);
	}

}
