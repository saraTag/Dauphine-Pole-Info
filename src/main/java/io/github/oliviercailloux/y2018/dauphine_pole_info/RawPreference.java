//Excusez-moi Monsieur je n'ai toujours pas compris l'erreur sur le package, merci de me le préciser
//merci
package io.github.oliviercailloux.y2018.dauphine_pole_info;



import javax.json.bind.Jsonb;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;

import com.google.common.base.Strings;

@JsonbPropertyOrder({
	"id",
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonbProperty("id")
	private int id;
	@OneToOne
	@JsonbProperty("master")
	private Master master;
	/**
	 * Not <code>null</code>.
	 */
	@OneToOne
	@JsonbProperty("content")
	private Content content;
	/**
	 * Not <code>null</code>.
	 */
	@OneToOne
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
