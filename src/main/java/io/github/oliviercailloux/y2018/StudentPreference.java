package io.github.oliviercailloux.y2018;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.json.bind.Jsonb;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

import com.google.common.base.Strings;

public class StudentPreference {
	/**
	 * Not <code>null</code>.
	 */
	@JsonbProperty("studPref")
	private Map<Person, Set<RawPreference>> studPref;

	private static Jsonb jsonb = JsonUtils.getInstance();

	public StudentPreference() {
		studPref = null;
	}

	/**
	 * CONSTRUCTOR
	 *
	 * @param student  not <code>null</code>.
	 * @param les_preferences
	 * 
	 */
	public StudentPreference(Person student, Set<RawPreference> les_preferences) {
		this.studPref = new HashMap<Person, Set<RawPreference>>();
		this.studPref.put(student, les_preferences);
	}

	/**
	 * @return not <code>null</code>.
	 */
	public Map<Person, Set<RawPreference>> getStudPref() {
		return this.studPref;
	}

	/**
	 * @param student not <code>null</code>.
	 * 
	 */
	public void addPref(Person student, RawPreference pref) {
		studPref.get(student).add(pref);
	}

	/**
	 * @param student not <code>null</code>.
	 * @return not <code>null</code>.
	 */
	public Set<RawPreference> getPreference(Person student) {
		return studPref.get(student);
	}
	
	/**
	 * @param student not <code>null</code>.
	 * @return not <code>null</code>.
	 */
	public boolean hasPreferenceWithDistinctLevels(Person student) {
		Set<RawPreference> preferences = getPreference(student);
		Set<Integer> levels = new HashSet<>();
		for (RawPreference pref : preferences) {
			if(!levels.contains(pref.getLevel())) {
			levels.add(pref.getLevel());
		    }
		  }
		  return levels.size() == preferences.size();
	}

	/**
	 * 
	 * @return not <code>null</code>.
	 */
	public String studentPreferenceToJson() {
		return jsonb.toJson(this);
	}

	/**
	 * @return StudentPreference not null
	 */
	public static StudentPreference jsonToStudentPreference(String jsonPreference) {
		return jsonb.fromJson(Strings.nullToEmpty(jsonPreference), StudentPreference.class);
	}

	

}
