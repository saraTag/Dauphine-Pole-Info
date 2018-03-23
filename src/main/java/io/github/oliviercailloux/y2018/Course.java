package io.github.oliviercailloux.y2018;

import java.util.Optional;

//import javax.json.bind.Jsonb;
//import javax.json.bind.JsonbBuilder;

import com.google.common.base.Strings;

// 
public class Course {
	
	private Master idMaster;
	private Content idContents;
	private Person idTeacher;
	private String periode;
	private Optional<Boolean> compulsory;
	/**
	 * description correspond to note in db.
	 */
	private String description; 
	//private static Jsonb jsonb = JsonbBuilder.create();

	public Course() {
		super();
		this.periode = ""; 
		this.compulsory = Optional.empty();
		this.description = "";
	}

	/**
	 * @param periode
	 * @param compulsory
	 * @param note
	 */
	public Course(String periode, boolean compulsory, String description) {
		super();
		this.periode = Strings.nullToEmpty(periode);
		this.compulsory = Optional.of(compulsory) ;
		this.description = Strings.nullToEmpty(description);
	}

	public Master getIdMaster() {
		return idMaster;
	}

	public Content getIdContents() {
		return idContents;
	}

	public Person getIdTeacher() {
		return idTeacher;
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

	public Optional<Boolean> getCompulsory() {
		return compulsory;
	}

	public void setCompulsory(boolean compulsory) {
		this.compulsory = Optional.of(compulsory);
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
//	public String toJson(){
//		return	jsonb.toJson(this);
//	}
//	
//	/**
//	 * @param jsonCours :String
//	 * @return Object : Cours not null
//	 */
//	public static Course fromJson(String jsonbCours){
//		return jsonb.fromJson(Strings.nullToEmpty(jsonbCours), Course.class);
//	}
}
