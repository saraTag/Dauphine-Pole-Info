package io.github.oliviercailloux.y2018;

import java.util.Optional;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.google.common.base.Strings;

public class Content {
	
	private int id;
	private String name;
	private Optional<String> description;
	private Optional<String> training;
	private int hourlyVolume;
	private float etcs;
	private int projectVolume;
	private Optional<String> objectives;
	private Optional<String> contents;
	private Optional<String> biblio;
	private static Jsonb jsonb = JsonbBuilder.create();
	
	
	
	
	public Content(int id, String name, int hourly_volume, float etcs) {
		super();
		this.id = id;
		this.name = Strings.nullToEmpty(name);
		this.hourlyVolume = hourly_volume;
		this.etcs = etcs;
	}


	public Content() {
		super();
		this.name =  "";
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return not null.
	 */
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = Strings.nullToEmpty(name);
	}

	/**
	 * @return not null.
	 */
	public Optional<String> getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = Optional.of(description);
	}

	/**
	 * @return not null.
	 */
	public Optional<String> getTraining() {
		return training;
	}


	public void setTraining(String training) {
		this.training = Optional.of(training);
	}


	public int getHourlyVolume() {
		return hourlyVolume;
	}


	public void setHourlyVolume(int hourly_volume) {
		this.hourlyVolume = hourly_volume;
	}


	public float getEtcs() {
		return etcs;
	}


	public void setEtcs(float etcs) {
		this.etcs = etcs;
	}


	public int getProjectVolume() {
		return projectVolume;
	}


	public void setProjectVolume(int project_volume) {
		this.projectVolume = project_volume;
	}

	/**
	 * @return not null.
	 */
	public Optional<String> getObjectives() {
		return objectives;
	}


	public void setObjectives(String objectives) {
		this.objectives = Optional.of(objectives);
	}

	/**
	 * @return not null.
	 */
	public Optional<String> getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = Optional.of(contents);
	}


	public Optional<String> getBiblio() {
		return biblio;
	}


	public void setBiblio(String biblio) {
		this.biblio = Optional.of(biblio);
	}


	public static Jsonb getJsonb() {
		return jsonb;
	}


	public static void setJsonb(Jsonb jsonb) {
		Content.jsonb = jsonb;
	}


	/**
	 * @return Contenu not null
	 */
	public String contenuToJson(){
		return jsonb.toJson(this);
	}
	
	/**
	 * @param jsonContenu : String
	 * @return Object : Contenu not null
	 */
	public static Content jsonToContenu(String jsonbContenu){
		return jsonb.fromJson(Strings.nullToEmpty(jsonbContenu), Content.class);
	}
}
