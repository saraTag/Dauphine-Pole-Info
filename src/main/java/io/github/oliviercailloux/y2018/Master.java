package io.github.oliviercailloux.y2018;

import javax.json.Json;
import javax.json.JsonObject;

public class Master {
	
	private int id;
	private String nom;
	private String description;
	
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
	
	public JsonObject masterToJson(){
		JsonObject mj = Json.createObjectBuilder()
				.add("id", getId())
				.add("nom", getNom())
				.add("description", getDescription())
				.build();
		return mj;
	}
	
	public Master jsonToMaster(JsonObject mj){
		Master master = new Master();
		master.setId(mj.getInt("id"));
		master.setNom(mj.getString("nom"));
		master.setDescription(mj.getString("description"));
		return master;
	}
	
}
