package test;

import java.sql.Date;

public class Mission {
	private int id;
	private String numero;
	private Date dateDepart =  new Date(System.currentTimeMillis());  
	private Date dateArrive =  new Date(System.currentTimeMillis());  
	private String longeurTrajet;
	private String consomationDeclare;
	private String consomationAttendu;
	private int idchauffeur;
	private int idvehicule;
	
	public Mission(int id, String numero,  Date dateDepart, Date dateArrive, String longeurTrajet, String consomationDeclare,
			String consomationAttendu, int idchauffeur, int idvehicule) {
		this.id = id;
		this.numero = numero;
		this.dateDepart = dateDepart;
		this.dateArrive = dateArrive;
		this.longeurTrajet = longeurTrajet;
		this.consomationDeclare = consomationDeclare;
		this.consomationAttendu = consomationAttendu;
		this.idchauffeur = idchauffeur;
		this.idvehicule = idvehicule;
	}
	
	
	
	
	
	public Mission(String numero, Date dateDepart, Date dateArrive, String longeurTrajet, String consomationDeclare,
			String consomationAttendu, int idchauffeur, int idvehicule) {
		this.numero = numero;
		this.dateDepart = dateDepart;
		this.dateArrive = dateArrive;
		this.longeurTrajet = longeurTrajet;
		this.consomationDeclare = consomationDeclare;
		this.consomationAttendu = consomationAttendu;
		this.idchauffeur = idchauffeur;
		this.idvehicule = idvehicule;
	}

	
	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public Date getDateArrive() {
		return dateArrive;
	}
	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}
	public String getLongeurTrajet() {
		return longeurTrajet;
	}
	public void setLongeurTrajet(String longeurTrajet) {
		this.longeurTrajet = longeurTrajet;
	}
	public String getConsomationDeclare() {
		return consomationDeclare;
	}
	public void setConsomationDeclare(String consomationDeclare) {
		this.consomationDeclare = consomationDeclare;
	}
	public String getConsomationAttendu() {
		return consomationAttendu;
	}
	public void setConsomationAttendu(String consomationAttendu) {
		this.consomationAttendu = consomationAttendu;
	}
	public int getIdChauffeur() {
		return idchauffeur;
	}
	public void setIdChauffeur(int idchauffeur) {
		this.idchauffeur = idchauffeur;
	}
	public int getIdVehicule() {
		return idvehicule;
	}
	public void setIdVehicule(int idvehicule) {
		this.idvehicule = idvehicule;
	}
	

	

}
