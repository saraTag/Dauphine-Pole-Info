package io.github.oliviercailloux.y2018;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.google.common.base.Strings;

public class Contents {
	
	private int id;
	private String name;
	private String description;
	private String training;
	private int hourly_volume;
	private float etcs;
	private int project_volume;
	private String objectives;
	private String contents;
	private String biblio;
	private static Jsonb jsonb = JsonbBuilder.create();
	
	
	
	
	public Contents(int id, String name, int hourly_volume, float etcs) {
		super();
		this.id = id;
		this.name = Strings.nullToEmpty(name);
		this.hourly_volume = hourly_volume;
		this.etcs = etcs;
	}


	public Contents() {
		super();
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
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = Strings.nullToEmpty(description);
	}

	/**
	 * @return not null.
	 */
	public String getTraining() {
		return training;
	}


	public void setTraining(String training) {
		this.training = Strings.nullToEmpty(training);
	}


	public int getHourly_volume() {
		return hourly_volume;
	}


	public void setHourly_volume(int hourly_volume) {
		this.hourly_volume = hourly_volume;
	}


	public float getEtcs() {
		return etcs;
	}


	public void setEtcs(float etcs) {
		this.etcs = etcs;
	}


	public int getProject_volume() {
		return project_volume;
	}


	public void setProject_volume(int project_volume) {
		this.project_volume = project_volume;
	}

	/**
	 * @return not null.
	 */
	public String getObjectives() {
		return objectives;
	}


	public void setObjectives(String objectives) {
		this.objectives = Strings.nullToEmpty(objectives);
	}

	/**
	 * @return not null.
	 */
	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = Strings.nullToEmpty(contents);
	}


	public String getBiblio() {
		return biblio;
	}


	public void setBiblio(String biblio) {
		this.biblio = Strings.nullToEmpty(biblio);
	}


	public static Jsonb getJsonb() {
		return jsonb;
	}


	public static void setJsonb(Jsonb jsonb) {
		Contents.jsonb = jsonb;
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
	public static Contents jsonToContenu(String jsonbContenu){
		return jsonb.fromJson(Strings.nullToEmpty(jsonbContenu), Contents.class);
	}
}
