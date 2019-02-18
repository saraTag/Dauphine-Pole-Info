package io.github.oliviercailloux.y2018;


import java.util.Map;
import java.util.Set;

import javax.json.bind.Jsonb;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

import com.google.common.base.Strings;

@JsonbPropertyOrder({"studPref"})

public class StudentsPreference {
	@JsonbProperty("studPref")
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
	 *             <code>null</code>.      
	 */
	public StudentsPreference(Person student, Set<RawPreference> les_preferences) {
		this.studPref = null;
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
	/**
	 * this method has been added to transform StudentsPreference into json
	 * the order is inherited from the order of RawPreference 
	 * */
	public String studentsPreferenceToJson() {
		return jsonb.toJson(this);
	}
	/**
	 * this method has been added to transform json into StudentsPreference
	 * */
	public static StudentsPreference jsonToStudentsPreference(String jsonPreference) {
		return jsonb.fromJson(Strings.nullToEmpty(jsonPreference), StudentsPreference.class);
	}

}
