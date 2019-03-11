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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Strings;

@Entity
<<<<<<< HEAD:src/main/java/io/github/oliviercailloux/y2018/Content.java
@Table(name = "Contenu")
=======
@XmlRootElement
@JsonbPropertyOrder({ "id", "name","etcs","description","training","hourlyVolume","projectVolume","objectives","contents","biblio"})
>>>>>>> 21ed6c18e620f39cb119f0d638b53b8e101dc41e:src/main/java/io/github/oliviercailloux/y2018/dauphine_pole_info/Content.java
public class Content {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonbProperty("id")
	private int id;

	
	@Column(name = "name") @JsonbProperty("name")
	private String name;

	@Column(name = "description")
	private Optional<String> description;

	@Column(name = "training")
	private Optional<String> training;

	@Column(name = "hourlyVolume")
	private int hourlyVolume;

	@Column(name = "etcs")
	private float etcs;

	@Column(name = "projectVolume")
	private int projectVolume;

	@Column(name = "objectives")
	private Optional<String> objectives;

	@Column(name = "contents")
	private Optional<String> contents;

	@Column(name = "biblio")
	private Optional<String> biblio;

	private static Jsonb jsonb = JsonUtils.getInstance();

	public Content(int id, String name, int hourly_volume, float etcs) {
		super();
		this.id = id;
		this.name = Strings.nullToEmpty(name);
		this.hourlyVolume = hourly_volume;
		this.etcs = etcs;
	}

	
	public Content(String name, Optional<String> training, int hourlyVolume) {
		super();
		this.name = name;
		this.training = training;
		this.hourlyVolume = hourlyVolume;
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
		return description;
	}

	public void setDescription(String description) {
		this.description = Optional.of(description);
	}

	/**
	 * @return not null.
	 */
	@XmlAttribute(name = "training")
	public Optional<String> getTraining() {
		return training;
	}

	public void setTraining(String training) {
		this.training = Optional.of(training);
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
		return objectives;
	}

	public void setObjectives(String objectives) {
		this.objectives = Optional.of(objectives);
	}

	/**
	 * @return not null.
	 */
	@XmlAttribute(name = "contents")
	public Optional<String> getContents() {
		return contents;
	}

	@XmlAttribute(name = "contents")
	public void setContents(String contents) {
		this.contents = Optional.of(contents);
	}

	@XmlAttribute(name = "biblio")
	public Optional<String> getBiblio() {
		return biblio;
	}

	public void setBiblio(String biblio) {
		this.biblio = Optional.of(biblio);
	}

	public static void setJsonb(Jsonb jsonb) {
		Content.jsonb = jsonb;
	}

	/**
	 * @return Contenu not null
	 */
	public String contenuToJson() {
		return jsonb.toJson(this);
	}

	/**
	 * @param jsonContenu
	 *            : String
	 * @return Object : Contenu not null
	 */
	public static Content jsonToContenu(String jsonbContenu) {
		return jsonb.fromJson(Strings.nullToEmpty(jsonbContenu), Content.class);
	}
}
