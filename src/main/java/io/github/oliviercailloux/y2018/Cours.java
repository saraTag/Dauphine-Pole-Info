package io.github.oliviercailloux.y2018;

import javax.json.Json;
import javax.json.JsonObject;

public class Cours {
	
	private int id_master;
	private int id_contenu;
	private int id_enseignant;
	private String periode;
	private String obligatoire;
	private String note;
	

	public Cours() {
		super();
	}

	public Cours(String periode, String obligatoire, String note) {
		super();
		this.periode = periode;
		this.obligatoire = obligatoire;
		this.note = note;
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

	public int getId_enseignant() {
		return id_enseignant;
	}

	public void setId_enseignant(int id_enseignant) {
		this.id_enseignant = id_enseignant;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public String getObligatoire() {
		return obligatoire;
	}

	public void setObligatoire(String obligatoire) {
		this.obligatoire = obligatoire;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public JsonObject CoursToJson(){
		JsonObject jc = Json.createObjectBuilder()
				.add("periode", getPeriode())
				.add("obligatoire", getObligatoire())
				.add("note", getNote())
				.build();
		return jc;
	}
	
	public Cours jsonToCours(JsonObject jc){
		Cours cours = new Cours();
		cours.setPeriode(jc.getString("periode"));
		cours.setObligatoire(jc.getString("obligatoire"));
		cours.setNote(jc.getString("note"));
		return cours;
	}
	
}
