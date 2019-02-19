package io.github.oliviercailloux.y2018;


import javax.json.bind.Jsonb;
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
	/**
	 * Not <code>null</code>.
	 */
	@JsonbProperty("master")
	private Master master;
	/**
	 * Not <code>null</code>.
	 */
	@JsonbProperty("content")
	private Content content;
	/**
	 * Not <code>null</code>.
	 */
	@JsonbProperty("person")
	private Person person;
	/**
	 * Not <code>null</code>.
	 */
	@JsonbProperty("level")
	private int level;

	private static Jsonb jsonb = JsonUtils.getInstance();

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
	
	/**
	 * @return not <code>null</code>.
	 * */
	public Master getMaster() {
		return master;
	}
	/**
	 * @return not <code>null</code>.
	 * */
	public Content getContent() {
		return content;
	}
	/**
	 * @return not <code>null</code>.
	 * */
	public Person getPerson() {
		return person;
	}
	/**
	 * @return not <code>null</code>.
	 * */
	public int getLevel() {
		return level;
	}
	/**
	 * 
	 *
	 * @param level
	 *            not <code>null</code>.
	 */
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
	public static RawPreference jsonToRawPreference(String jsonPreference) {
		return jsonb.fromJson(Strings.nullToEmpty(jsonPreference), RawPreference.class);
	}
	/**
	 * 
	 *
	 * @param content
	 *            not <code>null</code>.
	 */
	public void setContent(Content content) {
		this.content = content;
	}
	/**
	 * 
	 *
	 * @param master
	 *            not <code>null</code>.
	 */
	public void setMaster(Master master) {
		this.master = master;
	}
	/**
	 * 
	 *
	 * @param person
	 *            not <code>null</code>.
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
