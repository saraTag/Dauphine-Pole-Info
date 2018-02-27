package io.github.oliviercailloux.y2018;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.google.common.base.Strings;

public class Role {
	
	private String code;
	private String entitled;
	private static Jsonb jsonb = JsonbBuilder.create();
	
	public Role() {
		super();
	}

	public Role(String code, String entitled) {
		super();
		this.code = Strings.nullToEmpty(code);
		this.entitled = Strings.nullToEmpty(entitled);
	}

	/**
	 * 
	 * @return not null
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = Strings.nullToEmpty(code);
	}

	/**
	 * 
	 * @return not null
	 */
	public String getEntitled() {
		return entitled;
	}

	public void setEntitled(String entitled) {
		this.entitled = Strings.nullToEmpty(entitled);
	}
	
	/**
	 * 
	 * @return not null
	 */
	public String roleToJson(){
		return jsonb.toJson(this);
	}
	
	/**
	 * 
	 * @param jsonRole : String 
	 * @return Role not null
	 */
	public static Role jsonToRole(String jsonRole){
		return jsonb.fromJson(Strings.nullToEmpty(jsonRole), Role.class);
	}
	
}
