package io.github.oliviercailloux.y2018;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.bind.Jsonb;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;

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
	 * 
	 * @return not <code>null</code>.
	 */
	public String toJson() {
		String result = "";
		for (Person person : this.studPref.keySet()) {
			result += person.toJson();
			result += ":[";

			jsonb.toJson(this.studPref.get(person));
			result += "]";
		}
		result += "}";
		return result;
	}

	/**
	 * 
	 * @return not <code>null</code>.
	 */
	public String studentPreferenceToJson() {
		JsonArrayBuilder jarr = Json.createArrayBuilder();
		for (Person person : this.studPref.keySet())
		{
			String personAsTring = person.toJson();
			jarr.add(Json.createObjectBuilder().add("student", personAsTring));
			
			JsonArrayBuilder jarForRow = Json.createArrayBuilder();
			Set<RawPreference> preferences = getPreference(person);
			for (RawPreference pref : preferences) {
				String preferenceAsTring = pref.preferenceToJson();
				jarForRow.add(Json.createObjectBuilder().add("preference", preferenceAsTring));
			}
			jarr.add(jarForRow);
		}
		    JsonObject jsonObj = Json.createObjectBuilder().add("studentPreference",jarr).build();
		    StringWriter stringWriter = new StringWriter();
		    try (JsonWriter writer = Json.createWriter(stringWriter)) {
		    writer.writeObject(jsonObj);
		    System.out.println(stringWriter.toString());
		    } catch (Exception e) {
		    e.printStackTrace();
		    }
		    return stringWriter.toString();
	}
	
	/**
	 * 
	 * @return not <code>null</code>.
	 */
	/*public String studentPreferenceToJsonBis() {
		JsonObjectBuilder jsonObj = Json.createObjectBuilder();
		JsonArrayBuilder jarr = Json.createArrayBuilder();
		for (Person person : this.studPref.keySet())
		{
			String personAsTring = person.toJson();
			jsonObj.add("", Json.createObjectBuilder().add("student", personAsTring));
			
			JsonArrayBuilder jarForRow = Json.createArrayBuilder();
			Set<RawPreference> preferences = getPreference(person);
			for (RawPreference pref : preferences) {
				String preferenceAsTring = pref.preferenceToJson();
				jarForRow.add(Json.createObjectBuilder().add("preference", preferenceAsTring));
			}
			jsonObj.add(jarForRow);
		}
		    JsonObject jsonObj = Json.createObjectBuilder().add("",jarr).build();
		    StringWriter stringWriter = new StringWriter();
		    try (JsonWriter writer = Json.createWriter(stringWriter)) {
		    writer.writeObject(jsonObj);
		    System.out.println(stringWriter.toString());
		    } catch (Exception e) {
		    e.printStackTrace();
		    }
		    return stringWriter.toString();
	}*/
		

	/**
	 * @return StudentPreference not null
	 */
	public static StudentPreference jsonToStudentPreference(String jsonPreference) {
		return jsonb.fromJson(Strings.nullToEmpty(jsonPreference), StudentPreference.class);
	}

	
	public static void main(String[] args) {
		Person student = new Person(1, "firstname", "lastname");
		RawPreference pref = new RawPreference(100);
		Master master = new Master(1,"SITN","Description");
		pref.setMaster(master);
		List<RawPreference> preferences = new ArrayList<RawPreference>();
		preferences.add(pref);
		Set<RawPreference> les_preferences = new HashSet<RawPreference>(ImmutableSet.copyOf(preferences));
		StudentPreference oneStudentPreference = new StudentPreference(student, les_preferences);

		String json = oneStudentPreference.studentPreferenceToJson();
		
		System.out.println(json);
		
		JsonReader jsonReader = Json.createReader(new StringReader(json));
		JsonObject jobj = jsonReader.readObject();        
		System.out.println(jobj);
		
		//StudentPreference result = StudentPreference.jsonToStudentPreference(json);
		//System.out.println(result.getStudPref().toString());
		

	}

}
