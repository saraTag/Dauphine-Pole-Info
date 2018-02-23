package io.github.oliviercailloux.y2018;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class Master {
	
	private int id;
	private String nom;
	private String description;
	private static Jsonb jsonb = JsonbBuilder.create();
	
	public Master() {
		super();
	}

	public Master(int id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return Master : json
	 */
	public String masterToJson(){
		return jsonb.toJson(this);
	}
	
	/**
	 * @param jsonMaster : String
	 * @return Object : Master
	 */
	public static Master jsonToMaster(String jsonbMaster){
		return jsonb.fromJson(jsonbMaster, Master.class);
	}
}
