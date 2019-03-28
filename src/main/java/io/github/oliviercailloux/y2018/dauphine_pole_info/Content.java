package io.github.oliviercailloux.y2018.dauphine_pole_info;


import java.util.Optional;
import javax.json.bind.Jsonb;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Strings;

@Entity
@XmlRootElement
@JsonbPropertyOrder({ "id", "name","description","training","hourlyVolume","etcs","projectVolume","objectives","contents","biblio"})
@Table(name = "Contenu")
public class Content {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonbProperty("id")
	private int id;

	
	@Column(name = "name") @JsonbProperty("name")
	private String name;

	@Column(name = "description")@JsonbProperty("description")
	private String description;

	@Column(name = "apprentissage")@JsonbProperty("apprentissage")
	private String training;

	@Column(name = "volume_horaire")@JsonbProperty("volume_horaire")
	private int hourlyVolume;

	@Column(name = "ects")@JsonbProperty("etcs")
	private float etcs;

	@Column(name = "volume_projet")@JsonbProperty("volume_Project")
	private int projectVolume;

	@Column(name = "objectives")@JsonbProperty("objectives")
	private String objectives;

	@Column(name = "contents")@JsonbProperty("contents")
	private String contents;

	@Column(name = "biblio")@JsonbProperty("biblio")
	private String biblio;

	private static Jsonb jsonb = JsonUtilFomat.getInstance();

	public Content(int id, String name, int hourly_volume, float etcs) {
		super();
		this.id = id;
		this.name = Strings.nullToEmpty(name);
		this.hourlyVolume = hourly_volume;
		this.etcs = etcs;
	}
	

	public Content(String name) {
		super();
		this.name = name;
	}


	public Content() {
		super();
		this.name = "";
	}

	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return not null.
	 */
	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Strings.nullToEmpty(name);
	}

	/**
	 * @return not null.
	 */
	@XmlAttribute(name = "description")
	public Optional<String> getDescription() {
		return Optional.ofNullable(description);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return not null.
	 */
	@XmlAttribute(name = "training")
	public Optional<String> getTraining() {
		return Optional.ofNullable(training);
	}

	public void setTraining(String training) {
		this.training = training;
	}

	@XmlAttribute(name = "hourlyVolume")
	public int getHourlyVolume() {
		return hourlyVolume;
	}

	public void setHourlyVolume(int hourly_volume) {
		this.hourlyVolume = hourly_volume;
	}

	@XmlAttribute(name = "etcs")
	public float getEtcs() {
		return etcs;
	}

	public void setEtcs(float etcs) {
		this.etcs = etcs;
	}

	@XmlAttribute(name = "projectVolume")
	public int getProjectVolume() {
		return projectVolume;
	}

	public void setProjectVolume(int project_volume) {
		this.projectVolume = project_volume;
	}

	/**
	 * @return not null.
	 */
	@XmlAttribute(name = "objectives")
	public Optional<String> getObjectives() {
		return Optional.ofNullable(objectives);
	}

	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	/**
	 * @return not null.
	 */
	@XmlAttribute(name = "contents")
	public Optional<String> getContents() {
		return Optional.ofNullable(contents);
	}

	@XmlAttribute(name = "contents")
	public void setContents(String contents) {
		this.contents = contents;
	}

	@XmlAttribute(name = "biblio")
	public Optional<String> getBiblio() {
		return Optional.ofNullable(biblio);
	}

	public void setBiblio(String biblio) {
		this.biblio = biblio;
	}

	public static void setJsonb(Jsonb jsonb) {
		Content.jsonb = jsonb;
	}

	/**
	 * @return Contenu not null
	 */
	public String toJson() {
		return jsonb.toJson(this);
	}

	/**
	 * @param jsonContenu
	 *            : String
	 * @return Object : Contenu not null
	 */
	public static Content fromJson(String jsonbContenu) {
		return jsonb.fromJson(Strings.nullToEmpty(jsonbContenu), Content.class);
	}
}