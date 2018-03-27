package io.github.oliviercailloux.y2018;

import java.util.Optional;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Strings;

// 
@XmlRootElement
public class Course {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idMaster")
	private Master idMaster;
	
	@OneToMany
	@JoinColumn(name = "idContents")
	private Content idContents;
	
	@OneToMany
	@JoinColumn(name = "idTeacher")
	private Person idTeacher;
	
	@Column(name = "periode")
	private String periode;
	
	@Column(name = "compulsory", nullable = false)
	private Optional<Boolean> compulsory;
	/**
	 * description correspond to note in db.
	 */
	private String description; 
	private static Jsonb jsonb = JsonbBuilder.create();

	public Course() {
		super();
		this.periode = ""; 
		this.compulsory = Optional.empty();
		this.description = "";
	}

	/**
	 * @param periode
	 * @param compulsory
	 * @param note
	 */
	public Course(String periode, boolean compulsory, String description) {
		super();
		this.periode = Strings.nullToEmpty(periode);
		this.compulsory = Optional.of(compulsory) ;
		this.description = Strings.nullToEmpty(description);
	}

	@XmlElement(name = "master")
	public Master getIdMaster() {
		return idMaster;
	}
	@XmlElement(name = "id")
	public int getId() {
		return id;
	}

	@XmlElement(name = "content")
	public Content getIdContents() {
		return idContents;
	}
	
	@XmlElement(name = "person")
	public Person getIdTeacher() {
		return idTeacher;
	}
	
	/**
	 * @return  not null.
	 */
	@XmlAttribute(name = "periode")
	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		periode = Strings.nullToEmpty(periode);
	}

	@XmlAttribute(name = "compulsory")
	public Optional<Boolean> getCompulsory() {
		return compulsory;
	}

	public void setCompulsory(boolean compulsory) {
		this.compulsory = Optional.of(compulsory);
	}
	
	/**
	 * 
	 * @return not null
	 */
	@XmlAttribute(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {	
		this.description = Strings.nullToEmpty(description);
	}

	/**
	 * @return Cours not null
	 */
	public String toJson(){
		return	jsonb.toJson(this);
	}
	
	/**
	 * @param jsonCours :String
	 * @return Object : Cours not null
	 */
	public static Course fromJson(String jsonbCours){
		return jsonb.fromJson(Strings.nullToEmpty(jsonbCours), Course.class);
	}
}
