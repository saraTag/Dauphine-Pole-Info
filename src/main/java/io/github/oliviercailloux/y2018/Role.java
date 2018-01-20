package io.github.oliviercailloux.y2018;

import javax.json.Json;
import javax.json.JsonObject;

public class Role {
	
	private String code;
	private String intitule;
	
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
	
	public JsonObject roleToJson(){
		JsonObject rj = Json.createObjectBuilder()
				.add("code", getCode())
				.add("intitule", getIntitule())
				.build();
		return rj;
			
	}
	
	public Role jsonToRole(JsonObject rj){
		Role role = new Role();
		role.setCode( rj.getString("code"));
		role.setIntitule(rj.getString("intitule"));
		return role;
	}
	

}
