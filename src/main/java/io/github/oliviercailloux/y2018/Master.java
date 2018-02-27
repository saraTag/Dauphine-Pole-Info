package io.github.oliviercailloux.y2018;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.google.common.base.Strings;

public class Master {
	
	private int id;
	private String name;
	private String description;
	private static Jsonb jsonb = JsonbBuilder.create();
	
	public Master() {
		super();
	}

	public Master(int id, String nom, String description) {
		super();
		this.id = id;
		this.name = Strings.nullToEmpty(nom);
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		this.description = Strings.nullToEmpty(description);
	}
	
	/**
	 * @return Master : json
	 */
	public String masterToJson(){
		return jsonb.toJson(this);
	}
	
	/**
	 * @param jsonMaster : String
	 * @return Object : Master not null
	 */
	public static Master jsonToMaster(String jsonbMaster){
		return jsonb.fromJson(Strings.emptyToNull(jsonbMaster), Master.class);
	}
}
