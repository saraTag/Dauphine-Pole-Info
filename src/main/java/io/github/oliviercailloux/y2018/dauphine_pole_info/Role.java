package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.Optional;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Strings;

@Entity
@JsonbPropertyOrder({ "id", "code", "entitled" })
@XmlRootElement
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	private int id;

	private String code;

	private String entitled;

	private static Jsonb jsonb = JsonbBuilder.create();

	public Role() {
		super();
		this.code = "";
		this.entitled = null;
	}

	public Role(String code, String entitled) {
		super();
		this.code = Strings.nullToEmpty(code);
		this.entitled = entitled;
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
		this.entitled = entitled;
	}

	/**
	 * 
	 * @return not null
	 */
	public String toJson() {
		return jsonb.toJson(this);
	}

	/**
	 * 
	 * @param jsonRole
	 *            : String
	 * @return Role not null
	 */
	public static Role fromJson(String jsonRole) {
		return jsonb.fromJson(Strings.nullToEmpty(jsonRole), Role.class);
	}

}
