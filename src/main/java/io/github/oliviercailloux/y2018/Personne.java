package io.github.oliviercailloux.y2018;

public class Personne {
	
	private int id;
	private String prenom;
	private String nom;
	private String email;
	private String telephone;
	private String 	fax;
	private String home_page;
	private String cv;
	private String note;
	private String password;
	private String role;
	private int id_master;
	private int annee_master;
	private String adresse;
	private String mobile;
	private String vacataire;
	
	
	public Personne() {
		super();
	}

	public Personne(int id, String prenom, String nom, String email, String telephone, String fax, String home_page,
			String cv, String note, String password, String role, int annee_master, String adresse, String mobile,
			String vacataire) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.fax = fax;
		this.home_page = home_page;
		this.cv = cv;
		this.note = note;
		this.password = password;
		this.role = role;
		this.annee_master = annee_master;
		this.adresse = adresse;
		this.mobile = mobile;
		this.vacataire = vacataire;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public String getHome_page() {
		return home_page;
	}


	public void setHome_page(String home_page) {
		this.home_page = home_page;
	}


	public String getCv() {
		return cv;
	}


	public void setCv(String cv) {
		this.cv = cv;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public int getId_master() {
		return id_master;
	}


	public void setId_master(int id_master) {
		this.id_master = id_master;
	}


	public int getAnnee_master() {
		return annee_master;
	}


	public void setAnnee_master(int annee_master) {
		this.annee_master = annee_master;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getVacataire() {
		return vacataire;
	}


	public void setVacataire(String vacataire) {
		this.vacataire = vacataire;
	}
}
