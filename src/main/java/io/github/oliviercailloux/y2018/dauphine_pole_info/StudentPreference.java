package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

import javax.json.JsonWriterFactory;
import javax.json.bind.Jsonb;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.stream.JsonGenerator;

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
	 * @param student         not <code>null</code>.
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
			if (!levels.contains(pref.getLevel())) {
				levels.add(pref.getLevel());
			}
		}
		return levels.size() == preferences.size();
	}

	/**
	 * JSON non correct à revoir lors de la prochaine séance.
	 * à en strictement parler avec le professeur
	 * @return not <code>null</code>.
	 */
	public String studentPreferenceToJson() {
		JsonArrayBuilder jarr = Json.createArrayBuilder();

		for (Person person : this.studPref.keySet()) {
			String personAsTring = person.toJson();
			jarr.add(Json.createObjectBuilder().add("person", personAsTring));

			JsonArrayBuilder jarForRow = Json.createArrayBuilder();
			Set<RawPreference> preferences = getPreference(person);

			for (RawPreference pref : preferences) {
				String preferenceAsTring = pref.preferenceToJson();
				jarForRow.add(Json.createObjectBuilder().add("preference", preferenceAsTring));
			}

			jarr.add(jarForRow);
		}

		JsonObject jsonObj = Json.createObjectBuilder().add("studentPreference", jarr).build();
		Map<String, Boolean> config = new HashMap<>();
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		JsonWriterFactory writerFactory = Json.createWriterFactory(config);
		StringWriter stringWriter = new StringWriter();
		writerFactory.createWriter(stringWriter).write(jsonObj);

		return stringWriter.toString();
	}

	public static StudentPreference jsonToStudentPreference(String jsonPreference) {
		return jsonb.fromJson(Strings.nullToEmpty(jsonPreference), StudentPreference.class);

	}

}
