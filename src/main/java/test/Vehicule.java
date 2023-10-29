package test;

public class Vehicule {
	
	private int id;
	private String numero;
	private String model;
	private String marque;
	private String capaciteReservoir ;
	private String type;
	private String nombrePlaces;
	private int idTypeCarburant;
	
	
	
	public Vehicule(String numero, String model, String marque, String type,String capaciteReservoir,String nombrePlaces, int idTypeCarburant){
		this.numero = numero;
		this.idTypeCarburant = idTypeCarburant;
		this.model = model;
		this.marque = marque;
		this.type = type;
		this.capaciteReservoir = capaciteReservoir;
		this.nombrePlaces = nombrePlaces;
	}
	

	public Vehicule(int id, String numero, String model, String marque, String type,String capaciteReservoir,String nombrePlaces, int idTypeCarburant){
		this.id = id;
		this.numero = numero;
		this.idTypeCarburant = idTypeCarburant;
		this.model = model;
		this.marque = marque;
		this.type = type;
		this.capaciteReservoir = capaciteReservoir;
		this.nombrePlaces = nombrePlaces;
	}
	
	
	
	public String getCapaciteReservoir() {
		return capaciteReservoir;
	}



	public void setCapaciteReservoir(String capaciteReservoir) {
		this.capaciteReservoir = capaciteReservoir;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	public String getNombrePlaces() {
		return nombrePlaces;
	}



	public void setNombrePlaces(String nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getTypeCarburant() {
		return idTypeCarburant;
	}


	public void setTypeCarburant(int idTypeCarburant) {
		this.idTypeCarburant = idTypeCarburant;
	}


	public String getModel() {
		return model;
	}
	public void setModel(String Model) {
		this.model = Model;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
