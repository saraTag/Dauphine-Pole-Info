package io.github.oliviercailloux.y2018;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;

import com.google.common.base.Strings;

@Entity
@JsonbPropertyOrder({ "idMaster", "idContents", "idPerson"})
public class RawPreference {
	
	@ManyToOne
	@JoinColumn(name = "idMaster")
	@XmlElement
	private Master idMaster;
	
	@OneToMany
	@JoinColumn(name = "idContents")
	@XmlElement
	private Content idContents;
	
	@OneToMany
	@JoinColumn(name = "idPerson")
	@XmlElement
	private Person idPerson;

	/**
	 * default value
	 */
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

	public int getIdMaster() {
		return idMaster.getId();
	}

	public int getIdContent() {
		return idContents.getId();
	}

	public int getIdPerson() {
		return idPerson.getId();
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

	public void setIdContent(Content idContent) {
		this.idContents = idContent;
	}

	public void setIdMaster(Master idMaster) {
		this.idMaster = idMaster;
	}

	public void setIdPerson(Person idPerson) {
		this.idPerson = idPerson;
	}
	//commented this part just to do a new proper pull request
}
