package io.github.oliviercailloux.y2018;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.google.common.base.Strings;

public class Course {
	
	private int id_master;
	private int id_contents;
	private int id_teacher;
	private String periode;
	private boolean obligatoire;
	/**
	 * description correspond to note in db.
	 */
	private String description; 
	private static Jsonb jsonb = JsonbBuilder.create();

	public Course() {
		super();
	}

	/**
	 * @param periode
	 * @param obligatoire
	 * @param note
	 */
	public Course(String periode, boolean obligatoire, String note) {
		super();
		this.periode = Strings.nullToEmpty(periode);
		this.obligatoire = obligatoire;
		this.description = note;
	}

	public int getId_master() {
		return id_master;
	}

	public void setId_master(int id_master) {
		this.id_master = id_master;
	}

	public int getId_contents() {
		return id_contents;
	}

	public void setId_contents(int id_contenu) {
		this.id_contents = id_contenu;
	}

	public int getId_teacher() {
		return id_teacher;
	}

	public void setId_teacher(int id_enseignant) {
		this.id_teacher = id_enseignant;
	}
	
	/**
	 * @return  not null.
	 */
	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		periode = Strings.nullToEmpty(periode);
	}

	public boolean getObligatoire() {
		return obligatoire;
	}

	public void setObligatoire(boolean obligatoire) {
		this.obligatoire = obligatoire;
	}
	
	/**
	 * 
	 * @return not null
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {	
		this.description = Strings.nullToEmpty(description);
	}

	/**
	 * @return Cours not null
	 */
	public String coursToJson(){
		return	jsonb.toJson(this);
	}
	
	/**
	 * @param jsonCours :String
	 * @return Object : Cours not null
	 */
	public static Course JsonToCours(String jsonbCours){
		return jsonb.fromJson(Strings.nullToEmpty(jsonbCours), Course.class);
	}
}
