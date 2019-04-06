package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.Optional;

import javax.json.bind.Jsonb;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Strings;

@Entity
@JsonbPropertyOrder({ "id", "name", "description" })
public class Master {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonbProperty("id")
	private int id;

	@JsonbProperty("name")
	@Column(name = "nom")
	private String name;

	@JsonbProperty("description")
	private String description;

	private static Jsonb jsonb = JsonUtilFomat.getInstance();

	public Master() {
		super();
		this.name = "";

	}

	public Master(int id, String nom, String description) {
		super();
		this.id = id;
		this.name = Strings.nullToEmpty(nom);
		this.description = description;
	}

	public Master(String nom, String description) {
		super();
		this.name = Strings.nullToEmpty(nom);
		this.description = description;
	}
	
	public int getId() {
		return id;
	}

	/**
	 * @return not null.
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Strings.nullToEmpty(name);
	}

	/**
	 * @return not null.
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return Master : json
	 * 
	 */
	public String toJson() {
		return jsonb.toJson(this);
	}

	/**
	 * @param jsonMaster
	 *            : String
	 * @return Object : Master not null
	 */
	public static Master fromJson(String jsonbMaster) {
		return jsonb.fromJson(Strings.nullToEmpty(jsonbMaster), Master.class);
	}
}
