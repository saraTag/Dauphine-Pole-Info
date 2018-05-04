package io.github.oliviercailloux.y2018;

import java.util.Optional;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.annotation.JsonbPropertyOrder;

import com.google.common.base.Strings;

@JsonbPropertyOrder({ "id", "description", "compulsory", "periode", "idMaster", "idTeacher", "idContents" })
public class CourseShort {

	private String periode;

	private Optional<Boolean> compulsory;

	private String description;

	private int idMaster;

	private int idContent;

	private int idTeacher;

	private static Jsonb jsonb = JsonbBuilder.create();

	public CourseShort() {
		super();
		this.periode = "";
		this.compulsory = Optional.empty();
		this.description = "";
	}

	public CourseShort(String periode, boolean compulsory, String description) {
		super();
		this.periode = Strings.nullToEmpty(periode);
		this.compulsory = Optional.of(compulsory);
		this.description = Strings.nullToEmpty(description);
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public Optional<Boolean> getCompulsory() {
		return compulsory;
	}

	public void setCompulsory(Optional<Boolean> compulsory) {
		this.compulsory = compulsory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdMaster() {
		return idMaster;
	}

	public void setIdMaster(int idMaster) {
		this.idMaster = idMaster;
	}

	public int getIdContent() {
		return idContent;
	}

	public void setIdContent(int idContent) {
		this.idContent = idContent;
	}

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	/**
	 * @return CourseShort not null
	 */
	public String toJson() {
		return jsonb.toJson(this);
	}

	/**
	 * @param jsonCours
	 *            :String
	 * @return Object : CourseShort not null
	 */
	public static CourseShort fromJson(String jsonbCourseShort) {
		return jsonb.fromJson(Strings.nullToEmpty(jsonbCourseShort), CourseShort.class);
	}

}
