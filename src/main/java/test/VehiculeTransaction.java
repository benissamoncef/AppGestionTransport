package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculeTransaction extends BaseTransaction<Vehicule> {
	
	
	public VehiculeTransaction() throws SQLException {
		// TODO Auto-generated constructor stub
	}

	public void save(Vehicule object)  throws SQLException{
		

		String request= "insert into vehicule (numero, model, marque, type, capaciteReservoir, nombrePlaces, idTypeCarburant) values (?, ?, ? , ?, ?, ?, ?)"; 
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		// maooing relatipon et objet table client et objet client 
		this.preparedStatement.setString(1, object.getNumero());
		this.preparedStatement.setString(2, object.getModel());
		this.preparedStatement.setString(3, object.getMarque());	
		this.preparedStatement.setString(4, object.getType());
		this.preparedStatement.setString(5, object.getCapaciteReservoir());
		this.preparedStatement.setString(6, object.getNombrePlaces());
		this.preparedStatement.setInt(7, object.getTypeCarburant());
		
		this.preparedStatement.execute();
		
	} 
	
	public void update(Vehicule object, int id)  throws SQLException{
		String request= "update vehicule set numero = ?, model = ?, marque = ?, type = ?, capaciteReservoir = ?, nombrePlaces = ?, idTypeCarburant = ? where id = ? "; 
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		// maooing relatipon et objet table client et objet client 
		this.preparedStatement.setString(1, object.getNumero());
		this.preparedStatement.setString(2, object.getModel());
		this.preparedStatement.setString(3, object.getMarque());	
		this.preparedStatement.setString(4, object.getType());
		this.preparedStatement.setString(5, object.getCapaciteReservoir());
		this.preparedStatement.setString(6, object.getNombrePlaces());
		this.preparedStatement.setInt(7, object.getTypeCarburant());
		this.preparedStatement.setInt(8, id);
		
		
		this.preparedStatement.execute();
	} 
	public void delete(int id)  throws SQLException{
		
		String request= "delete from vehicule where id = ?";

		this.preparedStatement = this.cnx.prepareStatement(request);
		
		this.preparedStatement.setInt(1, id);
		
		this.preparedStatement.execute();
	
		
	} 
	public List<Vehicule> getAll()  throws SQLException{
		
		List<Vehicule> listeVehicules = new ArrayList<Vehicule>();
		
        String request= "select * from vehicule";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		resultSet = this.preparedStatement.executeQuery(); 
		
		
		while ( this.resultSet.next()) {
 
			listeVehicules.add(new Vehicule(this.resultSet.getInt(1),this.resultSet.getString(2), this.resultSet.getString(3), this.resultSet.getString(4), this.resultSet.getString(5), this.resultSet.getString(6), this.resultSet.getString(7), this.resultSet.getInt(8)));

		}
		
					
		return listeVehicules;
	} 
 
	public Vehicule getByNumero(String numero) throws SQLException {
		
		String request= "select * from vehicule where numero = ?";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		this.preparedStatement.setString(1, numero);
		
		resultSet = this.preparedStatement.executeQuery(); 
		
		Vehicule v = null ;
		
		while ( this.resultSet.next()) {
		
			v = new Vehicule(this.resultSet.getInt(1),this.resultSet.getString(2), this.resultSet.getString(3), this.resultSet.getString(4), this.resultSet.getString(5), this.resultSet.getString(6), this.resultSet.getString(7), this.resultSet.getInt(8));
		
		}
		
		return v;
		
	}
	
	public Vehicule getById(int id) throws SQLException {
		
		String request= "select * from vehicule where id = ?";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		this.preparedStatement.setInt(1, id);
		
		resultSet = this.preparedStatement.executeQuery(); 
		
		Vehicule v = null ;
		
		while ( this.resultSet.next()) {
		
			v = new Vehicule(this.resultSet.getInt(1),this.resultSet.getString(2), this.resultSet.getString(3), this.resultSet.getString(4), this.resultSet.getString(5), this.resultSet.getString(6), this.resultSet.getString(7), this.resultSet.getInt(8));
		
		}
		
		return v;
		
	}
	
	
	

}
