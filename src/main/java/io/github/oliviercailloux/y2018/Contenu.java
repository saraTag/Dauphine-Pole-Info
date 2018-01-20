package io.github.oliviercailloux.y2018;

import javax.json.Json;
import javax.json.JsonObject;

public class Contenu {
	
	private int id;
	private String nom;
	private String description;
	private String apprentissage;
	private int volume_horaire;
	private float etcs;
	private int volume_projet;
	private String objectives;
	private String contents;
	private String biblio;
	
	
	public Contenu() {
		super();
	}


	public Contenu(int id, String nom, String description, String apprentissage, int volume_horaire, float etcs,
			int volume_projet, String objectives, String contents, String biblio) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.apprentissage = apprentissage;
		this.volume_horaire = volume_horaire;
		this.etcs = etcs;
		this.volume_projet = volume_projet;
		this.objectives = objectives;
		this.contents = contents;
		this.biblio = biblio;
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


	public String getApprentissage() {
		return apprentissage;
	}


	public void setApprentissage(String apprentissage) {
		this.apprentissage = apprentissage;
	}


	public int getVolume_horaire() {
		return volume_horaire;
	}


	public void setVolume_horaire(int volume_horaire) {
		this.volume_horaire = volume_horaire;
	}


	public float getEtcs() {
		return etcs;
	}


	public void setEtcs(float etcs) {
		this.etcs = etcs;
	}


	public int getVolume_projet() {
		return volume_projet;
	}


	public void setVolume_projet(int volume_projet) {
		this.volume_projet = volume_projet;
	}


	public String getObjectives() {
		return objectives;
	}


	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getBiblio() {
		return biblio;
	}


	public void setBiblio(String biblio) {
		this.biblio = biblio;
	}
	
	public JsonObject contenuToJson(){
		JsonObject cj = Json.createObjectBuilder()
				.add("id", getId())
				.add("nom", getNom())
				.add("description", getDescription())
				.add("apprentissage", getApprentissage())
				.add("volume_horaire", getVolume_horaire())
				.add("ects", getEtcs())
				.add("volume_projet", getVolume_projet())
				.add("objectives", getObjectives())
				.add("contents", getContents())
				.add("biblio", getBiblio())
				.build();
		return cj;
	}
	
	public Contenu jsonToContenu(JsonObject cj){
		Contenu contenu = new Contenu();
		contenu.setId(cj.getInt("id"));
		contenu.setNom(cj.getString("nom"));
		contenu.setDescription(cj.getString("description"));
		contenu.setApprentissage(cj.getString("apprentissage"));
		contenu.setVolume_horaire(cj.getInt("volume_horaire"));
		contenu.setEtcs(Float.parseFloat(cj.getString("ects")));
		contenu.setVolume_projet(cj.getInt("volume_projet"));
		contenu.setObjectives(cj.getString("objectives"));
		contenu.setContents(cj.getString("contents"));
		contenu.setBiblio(cj.getString("biblio"));
		return contenu;
	}
	

}
