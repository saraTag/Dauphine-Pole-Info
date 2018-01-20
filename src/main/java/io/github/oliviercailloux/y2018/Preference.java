package io.github.oliviercailloux.y2018;

import javax.json.Json;
import javax.json.JsonObject;

public class Preference {
	
	private int id_master;
	private int id_contenu;
	private int id_personne;
	private int niveau;
	
	
	public Preference() {
		super();
	}


	public Preference(int niveau) {
		super();
		this.niveau = niveau;
	}


	public int getId_master() {
		return id_master;
	}


	public void setId_master(int id_master) {
		this.id_master = id_master;
	}


	public int getId_contenu() {
		return id_contenu;
	}


	public void setId_contenu(int id_contenu) {
		this.id_contenu = id_contenu;
	}


	public int getId_personne() {
		return id_personne;
	}


	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}


	public int getNiveau() {
		return niveau;
	}


	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	public JsonObject preferenceToJson(){
		JsonObject pj = Json.createObjectBuilder()
				.add("id_master", getId_master())
				.add("id_contenu", getId_contenu())
				.add("id_personne", getId_personne())
				.add("niveau", getNiveau())
				.build();
		return pj;
	}
	
	public Preference jsonToPrefernece(JsonObject pj){
		Preference preference = new Preference();
		preference.setId_master(pj.getInt("id_master"));
		preference.setId_contenu(pj.getInt("id_contenu"));
		preference.setId_personne(pj.getInt("id_personne"));
		preference.setNiveau(pj.getInt("niveau"));
		return preference;
	}

}
