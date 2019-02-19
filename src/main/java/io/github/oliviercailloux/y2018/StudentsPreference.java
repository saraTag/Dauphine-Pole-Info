package io.github.oliviercailloux.y2018;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.json.bind.Jsonb;


import com.google.common.base.Strings;



public class StudentsPreference {
	
	private Map<Person, Set<RawPreference>> studPref;
	
	private static Jsonb jsonb = JsonUtils.getInstance();

	public StudentsPreference() {
		studPref = null;
	}
	
	/**
	 * CONSTRUCTOR
	 *
	 * @param student
	 *            not <code>null</code>.
	 * @param les_preferences
	 *                 
	 */
	public StudentsPreference(Person student, Set<RawPreference> les_preferences) {
		this.studPref = new HashMap<Person, Set<RawPreference>>();
		this.studPref.put(student, les_preferences);
				
	}

	public Map<Person, Set<RawPreference>> getStudPref() {
		return this.studPref;
	}
	
	public void addPref(Person student, RawPreference pref) {
		studPref.get(student).add(pref);
	}
	/**
	 * @param student not <code>null</code>.
	 * @return not <code>null</code>.
	 * */
	public Set<RawPreference> getPreference(Person student) {
		return studPref.get(student);
	}
	
	/**
	 * this method has been added to transform StudentsPreference into json
	 * the order is inherited from the order of RawPreference 
	 * */
	public String studentsPreferenceToJson() {
		String result ="";
		for(Person person : this.studPref.keySet()) {
			result+=person.toJson();
			result+= ":preferences";
			for(RawPreference preference : this.studPref.get(person)) {
				result+=preference.preferenceToJson();
			}
		}
		return result;
	}
	/**
	 * this method has been added to transform json into StudentsPreference
	 * */
	public static StudentsPreference jsonToStudentsPreference(String jsonPreference) {
		return jsonb.fromJson(Strings.nullToEmpty(jsonPreference), StudentsPreference.class);
	}



}
