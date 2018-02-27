package io.github.oliviercailloux.y2018;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.google.common.base.Strings;

public class Person {
	
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String fax;
	private String home_page;
	private String cv;
	private String note;
	private String password;
	private String role;
	private int id_master;
	private int year_master;
	private String address;
	private String mobile;
	private String temporary;
	private static Jsonb jsonb = JsonbBuilder.create();
	
	
	public Person() {
		super();
	}

	/**
	 * Short constructor by design.
	 * Use setters to complete the object.
	 * @param id int
	 * @param firstname String
	 * @param lastname String
	 */
	public Person(int id, String firstname, String lastname) {
		super();
		this.id=id;
		this.firstname=firstname;
		this.lastname=lastname;
	}
	
	public int getId() {
		return id;
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
		return home_page;
	}

	public void setHome_page(String home_page) {
		this.home_page = Strings.nullToEmpty(home_page);
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


	public int getId_master() {
		return id_master;
	}


	public void setId_master(int id_master) {
		this.id_master = id_master;
	}


	public int getYear_master() {
		return year_master;
	}


	public void setYear_master(int year_master) {
		this.year_master = year_master;
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
	public  String personneToJson(){
		return jsonb.toJson(this);
	}
	
	/**
	 * @param jsonPerson : String
	 * @return Object : Person
	 */
	public static Person jsonToPerson(String jsonPersonne){
		return jsonb.fromJson(jsonPersonne, Person.class);
	}
}
