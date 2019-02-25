package io.github.oliviercailloux.y2018;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Strings;

@Entity
@JsonbPropertyOrder({"id", "firstname", "lastname"})
@Table(name = "person")
public class Person {

	@Id
	private int id;
	
	@Column(name = "firstname", unique = false)
	private String firstname;

	@Column(name = "lastname", unique = false)
	private String lastname;

	private String email;

	@Column(name = "telephone", unique = false)
	private String phone;

	private String fax;

	@Column(name = "home_page", unique = false)
	private String homePage;

	private String cv;
	
	@Column(name = "notes", unique = false)
	private String note; // comment renommage !!!

	private String password;

	@Column(name = "roles", unique = false)
	private String role;

	@Column(name = "adresse", unique = false)
	private String address;

	private String mobile;

	@Column(name = "vacataire", unique = false)
	private String temporary;

	@OneToOne
	private Master master;

	private int yearMaster;

	private static Jsonb jsonb = JsonbBuilder.create();

	public Person() {
		super();
		this.firstname = "";
		this.lastname = "";
	}

	/**
	 * Short constructor by design. Use setters to complete the object.
	 * 
	 * @param id
	 *            int
	 * @param firstname
	 *            String
	 * @param lastname
	 *            String
	 */
	public Person(int id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = Strings.nullToEmpty(firstname);
		this.lastname = Strings.nullToEmpty(lastname);
	}

	public int getId() {
		return id;
	}

	public void setId(int idPerson) {
		this.id = idPerson;
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = Strings.nullToEmpty(firstname);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = Strings.nullToEmpty(lastname);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = Strings.nullToEmpty(email);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = Strings.nullToEmpty(phone);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = Strings.nullToEmpty(fax);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getHome_page() {
		return homePage;
	}

	public void setHomePage(String home_page) {
		this.homePage = Strings.nullToEmpty(home_page);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = Strings.nullToEmpty(cv);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = Strings.nullToEmpty(note);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Strings.nullToEmpty(password);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = Strings.nullToEmpty(role);
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master idMaster) {
		this.master = idMaster;
	}

	public int getYear_master() {
		return yearMaster;
	}

	public void setYearMaster(int year_master) {
		this.yearMaster = year_master;
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = Strings.nullToEmpty(address);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = Strings.nullToEmpty(mobile);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getVacataire() {
		return temporary;
	}

	public void setTemporary(String temporary) {
		this.temporary = Strings.nullToEmpty(temporary);
	}

	/**
	 * @return Person not null
	 */
	public String toJson() {
		return jsonb.toJson(this);
	}

	/**
	 * @param jsonPerson
	 *            : String
	 * @return Object : Person
	 */
	public static Person fromJson(String jsonPersonne) {
		return jsonb.fromJson(jsonPersonne, Person.class);
	}
}
