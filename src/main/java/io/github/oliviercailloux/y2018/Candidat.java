package io.github.oliviercailloux.y2018;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Strings;

@Entity
@JsonbPropertyOrder({ "id", "firstname", "lastname" })
@XmlRootElement
public class Candidat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	private int id;

	private String firstname;

	private String lastname;

	private String email;

	private String phone;
	
	private String address;
	
	private String ville;

	private String codePostal;

	private String pays;

	@OneToOne
	private Master master;

	private int yearMaster;
	
	private int diplome;

	private String etablissement; // comment renommage !!!

	private String ville_diplome;
	
	private String pays_diplome;

	private int mois_obtention;
	
	private int annee_obtention;

	private int affectation;

	private String genre;

	private static Jsonb jsonb = JsonbBuilder.create();

	public Candidat() {
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
	public Candidat(int id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = Strings.nullToEmpty(firstname);
		this.lastname = Strings.nullToEmpty(lastname);
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	public int getYearMaster() {
		return yearMaster;
	}

	public void setYearMaster(int yearMaster) {
		this.yearMaster = yearMaster;
	}

	public int getDiplome() {
		return diplome;
	}

	public void setDiplome(int diplome) {
		this.diplome = diplome;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public String getVille_diplome() {
		return ville_diplome;
	}

	public void setVille_diplome(String ville_diplome) {
		this.ville_diplome = ville_diplome;
	}

	public String getPays_diplome() {
		return pays_diplome;
	}

	public void setPays_diplome(String pays_diplome) {
		this.pays_diplome = pays_diplome;
	}

	public int getMois_obtention() {
		return mois_obtention;
	}

	public void setMois_obtention(int mois_obtention) {
		this.mois_obtention = mois_obtention;
	}

	public int getAnnee_obtention() {
		return annee_obtention;
	}

	public void setAnnee_obtention(int annee_obtention) {
		this.annee_obtention = annee_obtention;
	}

	public int getAffectation() {
		return affectation;
	}

	public void setAffectation(int affectation) {
		this.affectation = affectation;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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
