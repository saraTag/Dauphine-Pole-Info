package io.github.oliviercailloux.y2018;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.google.common.base.Strings;

public class Cours {
	
	private int id_master;
	private int id_contenu;
	private int id_enseignant;
	private String periode;
	private boolean obligatoire; //bool
	/**
	 * description correspond to note in db.
	 */
	private String description; 
	private static Jsonb jsonb = JsonbBuilder.create();

	public Cours() {
		super();
	}

	/**
	 * @param periode
	 * @param obligatoire
	 * @param note
	 */
	public Cours(String periode, boolean obligatoire, String note) {
		super();
		if(periode == null)
			this.periode = "";
		else 
			this.periode = periode;
		this.obligatoire = obligatoire;
		this.description = note;
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
	
	/**
	 * @return  not null.
	 */
	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		if(periode == null)
			this.periode = "";
		else 
			this.periode = periode;
	}

	public boolean getObligatoire() {
		return obligatoire;
	}

	public void setObligatoire(boolean obligatoire) {
		this.obligatoire = obligatoire;
	}

	public String getNote() {
		return description;
	}

	public void setNote(String note) {	
		this.description = Strings.nullToEmpty(note);
	}
	
	/**
	 * @return Cours : Json
	 */
	public String coursToJson(){
		return	jsonb.toJson(this);
	}
	
	/**
	 * @param jsonCours : String
	 * @return Object : Cours
	 */
	public static Cours JsonToCours(String jsonbCours){
		return jsonb.fromJson(jsonbCours, Cours.class);
	}
}
