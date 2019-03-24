package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.Optional;

import javax.json.bind.Jsonb;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Strings;

// 

@Entity
@JsonbPropertyOrder({ "id", "description", "compulsory", "periode", "master", "teacher", "contents" })
@XmlRootElement
public class Course {

	@EmbeddedId
    private CourseId id;
	
	@OneToOne
	@JoinColumn(name = "id_enseignant", referencedColumnName = "id")
	@XmlElement
	private Person teacher;

	private String periode;

	/**
	 * description correspond to note in db.
	 */
	private String description;

	private static Jsonb jsonb = JsonUtils.getInstance();

	public Course() {
		super();
		this.periode = "";
		this.description = "";
	}

	/**
	 * @param periode
	 * @param compulsory
	 * @param note
	 */
	public Course(String periode, String description) {
		super();
		this.periode = Strings.nullToEmpty(periode);
		this.description = Strings.nullToEmpty(description);
		
	}

	/**
	 * @param periode
	 * @param compulsory
	 * @param note
	 */
	public Course(CourseId id, String periode, String description) {
		super();
		this.id = id;
		this.periode = Strings.nullToEmpty(periode);
		this.description = Strings.nullToEmpty(description);
	}

	public CourseId getId() {
		return id;
	}

	public void setId(CourseId id) {
		this.id = id;
	}


	public Person getTeacher() {
		return teacher;
	}

	/**
	 * @return not null.
	 */
	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		periode = Strings.nullToEmpty(periode);
	}

	/**
	 * 
	 * @return not null
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = Strings.nullToEmpty(description);
	}

	/**
	 * @return Cours not null
	 */
	public String toJson() {
		return jsonb.toJson(this);
	}

	/**
	 * @param jsonCours
	 *            is not null nor empty
	 * @return Object : Cours not null
	 * 
	 */
	public static Course fromJson(String jsonbCours) throws IllegalArgumentException, NullPointerException {
		if (jsonbCours == null || jsonbCours.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return jsonb.fromJson(jsonbCours, Course.class);
	}
}
