package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MissionTransaction extends BaseTransaction<Mission>{
		
	public MissionTransaction() throws SQLException {
		// TODO Auto-generated constructor stub
	}
	public void update(Mission object, int id)  throws SQLException{
		
		String request= "update mission set numero = ?, dateDepart = ?, dateArrive = ?, longeurTrajet = ?, consomationDeclare = ?, consomationAttendu = ?, idChauffeur = ?, idVehicule = ?  where id = ? "; 
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		// maooing relatipon et objet table client et objet client 
		this.preparedStatement.setString(1, object.getNumero());
		this.preparedStatement.setDate(2, object.getDateDepart());
		this.preparedStatement.setDate(3, object.getDateArrive());
		this.preparedStatement.setString(4, object.getLongeurTrajet());
		this.preparedStatement.setString(5, object.getConsomationDeclare());
		this.preparedStatement.setString(6, object.getConsomationAttendu());
		this.preparedStatement.setInt(7, object.getIdChauffeur());
		this.preparedStatement.setInt(8, object.getIdVehicule());
		this.preparedStatement.setInt(9, id);
		
		
		this.preparedStatement.execute();
	}
	
	public void save(Mission object)  throws SQLException{
		String request= "insert into mission (numero, dateDepart, dateArrive, longeurTrajet, consomationDeclare, consomationAttendu, idChauffeur, idVehicule) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		// maooing relatipon et objet table client et objet client 
		this.preparedStatement.setString(1, object.getNumero());
		this.preparedStatement.setDate(2, object.getDateDepart());
		this.preparedStatement.setDate(3, object.getDateArrive());
		this.preparedStatement.setString(4, object.getLongeurTrajet());
		this.preparedStatement.setString(5, object.getConsomationDeclare());
		this.preparedStatement.setString(6, object.getConsomationAttendu());
		this.preparedStatement.setInt(7, object.getIdChauffeur());
		this.preparedStatement.setInt(8, object.getIdVehicule());

		this.preparedStatement.execute();
		
		
	}
	public void delete(int id)  throws SQLException{
		
		String request= "delete from mission where id = ?";

		this.preparedStatement = this.cnx.prepareStatement(request);
		
		this.preparedStatement.setInt(1, id);
		
		this.preparedStatement.execute();
		
	}
	public List<Mission> getAll()  throws SQLException{
		
		List<Mission> listeMissions = new ArrayList<Mission>();
		
        String request= "select * from mission";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		resultSet = this.preparedStatement.executeQuery(); 
		
		
		while ( this.resultSet.next()) {
 
			listeMissions.add(new Mission(this.resultSet.getInt(1), this.resultSet.getString(2), this.resultSet.getDate(3), this.resultSet.getDate(4), this.resultSet.getString(5), this.resultSet.getString(6), this.resultSet.getString(7), this.resultSet.getInt(8), this.resultSet.getInt(9)));
		}
		
					
		return listeMissions;	
		

		
	}
	
	public Mission getOne(Integer id)  throws SQLException{
		return null;
	}
	
	
	public Mission getByNumero(String numero)  throws SQLException{
		
		String request= "select * from mission where numero = ?";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		this.preparedStatement.setString(1, numero);
		
		resultSet = this.preparedStatement.executeQuery(); 
		
		Mission mission = null ;
		
		while ( this.resultSet.next()) {
		
			mission = (new Mission(this.resultSet.getInt(1),this.resultSet.getString(2), this.resultSet.getDate(3), this.resultSet.getDate(4), this.resultSet.getString(5), this.resultSet.getString(6), this.resultSet.getString(7), this.resultSet.getInt(8), this.resultSet.getInt(9)));
		
		}
		
		return mission;
		
	}
	

	public Mission getById(int id)  throws SQLException{
		String request= "select * from mission where id = ?";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		this.preparedStatement.setInt(1, id);
		
		resultSet = this.preparedStatement.executeQuery(); 
		
		Mission mission = null ;
		
		while ( this.resultSet.next()) {
		
			mission = (new Mission(this.resultSet.getInt(1),this.resultSet.getString(2), this.resultSet.getDate(3), this.resultSet.getDate(4), this.resultSet.getString(5), this.resultSet.getString(6), this.resultSet.getString(7), this.resultSet.getInt(8), this.resultSet.getInt(9)));
		
		}
		
		return mission;
		
	}
	
	
	

}
