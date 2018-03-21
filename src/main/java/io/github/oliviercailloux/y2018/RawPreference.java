package io.github.oliviercailloux.y2018;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.google.common.base.Strings;

public class RawPreference {
	
	private Master idMaster;
	private Content idContents;
	private Person idPerson;
	/**
	 * default value
	 */
	private int level; 
	private static Jsonb jsonb = JsonbBuilder.create();
	
	
	public RawPreference() {
		super();
	}

	/**
	 * 
	 * obliger le user à fournir toutes les infos
	 */
	public RawPreference(int niveau) {
		super();
		this.level = 0;
	}
	

	public int getIdMaster() {
		return idMaster.getId();
	}
	

	public int getIdContent() {
		return idContents.getId();
	}

	public int getIdPerson() {
		return idPerson.getId();
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
	public static RawPreference jsonToPrefernecy(String jsonPreference){
		return jsonb.fromJson(Strings.nullToEmpty(jsonPreference), RawPreference.class);
	}

	public void setIdContent(int idContent) {
		this.idContents.setId(idContent);
		
	}

	public void setIdMaster(int idMaster) {
		this.idMaster.setId(idMaster);
	}

	public void setIdPerson(int idPerson) {
		this.idPerson.setIde(idPerson);
	}

}
