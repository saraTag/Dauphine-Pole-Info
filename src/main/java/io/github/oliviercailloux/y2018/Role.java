package io.github.oliviercailloux.y2018;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class Role {
	
	private String code;
	private String intitule;
	private static Jsonb jsonb = JsonbBuilder.create();
	
	public Role() {
		super();
	}

	public Role(String code, String intitule) {
		super();
		this.code = code;
		this.intitule = intitule;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	public String roleToJson(){
		return jsonb.toJson(this);
	}
	
	public static Role jsonToRole(String jsonRole){
		return jsonb.fromJson(jsonRole, Role.class);
	}
	
}
