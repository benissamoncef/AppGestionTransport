package test;

public class TypeCarburant {
	
	private String libelle;
	private String prix;
	private int id;
	
	public TypeCarburant(int id, String libelle, String prix) {
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
	}
	public TypeCarburant(String libelle, String prix) {
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	
	

}
