package io.github.oliviercailloux.y2018;


public class Contenu {
	
	private int id;
	private String nom;
	private String description;
	private String apprentissage;
	private int volume_horaire;
	private float etcs;
	private int volume_projet;
	private String objectives;
	private String contents;
	private String biblio;
	
	
	public Contenu() {
		super();
	}


	public Contenu(int id, String nom, String description, String apprentissage, int volume_horaire, float etcs,
			int volume_projet, String objectives, String contents, String biblio) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.apprentissage = apprentissage;
		this.volume_horaire = volume_horaire;
		this.etcs = etcs;
		this.volume_projet = volume_projet;
		this.objectives = objectives;
		this.contents = contents;
		this.biblio = biblio;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getApprentissage() {
		return apprentissage;
	}


	public void setApprentissage(String apprentissage) {
		this.apprentissage = apprentissage;
	}


	public int getVolume_horaire() {
		return volume_horaire;
	}


	public void setVolume_horaire(int volume_horaire) {
		this.volume_horaire = volume_horaire;
	}


	public float getEtcs() {
		return etcs;
	}


	public void setEtcs(float etcs) {
		this.etcs = etcs;
	}


	public int getVolume_projet() {
		return volume_projet;
	}


	public void setVolume_projet(int volume_projet) {
		this.volume_projet = volume_projet;
	}


	public String getObjectives() {
		return objectives;
	}


	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getBiblio() {
		return biblio;
	}


	public void setBiblio(String biblio) {
		this.biblio = biblio;
	}
	

}
