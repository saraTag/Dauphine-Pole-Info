package io.github.oliviercailloux.y2018;


import java.util.Set;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.*;

import com.google.common.base.Strings;

@JsonbPropertyOrder({
    "person",
    "master",
    "content",
    "level"
})

@Entity
public class RawPreference {
	
	@JsonbProperty("master")
	private Master master;
	
	@JsonbProperty("master")
	private Content content;
	
	@JsonbProperty("person")
	private Person person;
	
	@JsonbProperty("level")
	private int level;

	private static Jsonb jsonb = JsonbBuilder.create();

	public RawPreference() {
		super();
	}

	/**
	 * 
	 * obliger le user à fournir toutes les infos
	 */
	public RawPreference(int level) {
		this.level = level;
	}

	public int getMasterId() {
		return master.getId();
	}

	public int getContentId() {
		return content.getId();
	}

	public int getPersonId() {
		return person.getId();
	}
	
	public Master getMaster() {
		return master;
	}

	public Content getContent() {
		return content;
	}

	public Person getPerson() {
		return person;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * 
	 * @return not null
	 */
	public String preferenceToJson() {
		return jsonb.toJson(this);
	}

	/**
	 * 
	 * @param jsonPreference
	 *            : String
	 * @return Preference not null
	 */
	public static RawPreference jsonToPrefernecy(String jsonPreference) {
		return jsonb.fromJson(Strings.nullToEmpty(jsonPreference), RawPreference.class);
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public StudentsPreference rawPreferenceToStudentsPreference(Person student) {
		Set<RawPreference> preferences = null;
		preferences.add(this);
		return new StudentsPreference(student,preferences);
	}
}
