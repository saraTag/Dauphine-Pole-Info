package io.github.oliviercailloux.y2018;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.google.common.base.Strings;

public class Preference {
	
	private int id_master;
	private int id_contents;
	private int id_person;
	/**
	 * default value
	 */
	private int level; 
	private static Jsonb jsonb = JsonbBuilder.create();
	
	
	public Preference() {
		super();
	}

	/**
	 * 
	 * obliger le user à fournir toutes les infos
	 */
	public Preference(int niveau) {
		super();
		this.level = 0;
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


	public int getId_person() {
		return id_person;
	}


	public void setId_person(int id_personne) {
		this.id_person = id_personne;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * 
	 * @return not null
	 */
	public String preferenceToJson(){
		return jsonb.toJson(this);
		
	}
	/**
	 * 
	 * @param jsonPreference : String
	 * @return Preference not null
	 */
	public static Preference jsonToPrefernecy(String jsonPreference){
		return jsonb.fromJson(Strings.nullToEmpty(jsonPreference), Preference.class);
	}

}
