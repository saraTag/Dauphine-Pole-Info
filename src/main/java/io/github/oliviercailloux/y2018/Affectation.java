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
public class Affectation {
	
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
	private int annee;

	private float note;
	
	
	private static Jsonb jsonb = JsonbBuilder.create();

	public Affectation() {
		super();
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

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}
	/**
	 * 
	 * @return not null
	 */
	public String preferenceToJson() {
		return jsonb.toJson(this);
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
}

