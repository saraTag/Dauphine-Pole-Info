package io.github.oliviercailloux.y2018;

import java.util.Optional;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


import com.google.common.base.Strings;



@Entity
@XmlRootElement
public class Role {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int id;
	
	@Column(name = "code")
	private String code; 
	
	@Column(name = "entitled")
	private Optional<String> entitled;
	
	private static Jsonb jsonb = JsonbBuilder.create();
	
	public Role() {
		super();
		this.code = "";
		this.entitled = Optional.empty();
	}

	public Role(String code, String entitled) {
		super();
		this.code = Strings.nullToEmpty(code);
		this.entitled = Optional.of(entitled);
	}

	/**
	 * 
	 * @return not null
	 */
	@XmlAttribute(name = "code")
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
	@XmlAttribute(name = "entitled")
	public Optional<String> getEntitled() {
		return entitled;
	}

	public void setEntitled(String entitled) {
		this.entitled = Optional.of(entitled);
	}
	
	
	/**
	 * 
	 * @return not null
	 */
	public String toJson(){
		return jsonb.toJson(this);
	}
	
	/**
	 * 
	 * @param jsonRole : String 
	 * @return Role not null
	 */
	public static Role fromJson(String jsonRole){
		return jsonb.fromJson(Strings.nullToEmpty(jsonRole), Role.class);
	}
	
}
