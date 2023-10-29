package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeCarburantTransaction extends BaseTransaction<TypeCarburant>{
		
	public TypeCarburantTransaction() throws SQLException {
		// TODO Auto-generated constructor stub
	}
	public void update(TypeCarburant object, int id)  throws SQLException{
		
		String request= "update typecarburant set libelle = ?, prix = ? where id = ?";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		
		this.preparedStatement.setString(1, object.getLibelle());
		this.preparedStatement.setString(2, object.getPrix());
		this.preparedStatement.setInt(3, id);
		
		this.preparedStatement.execute();
		
	}
	
	public void save(TypeCarburant object)  throws SQLException{
		String request= "insert into typecarburant (libelle, prix) values (?, ?)";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		// maooing relatipon et objet table client et objet client 
		
		this.preparedStatement.setString(1, object.getLibelle());
		this.preparedStatement.setString(2, object.getPrix());


		this.preparedStatement.execute();
			
	}
	
	public void delete(String Libelle)  throws SQLException{ 

		
		String request= "delete from typecarburant where libelle = ?";

		this.preparedStatement = this.cnx.prepareStatement(request);
		
		this.preparedStatement.setString(1, Libelle);
		
		this.preparedStatement.execute();

		
	}
	
	
	
	public void delete(int id)  throws SQLException{
		
		String request= "delete from typecarburant where id = ?";

		this.preparedStatement = this.cnx.prepareStatement(request);
		
		this.preparedStatement.setInt(1, id);
		
		this.preparedStatement.execute();

		
		
	}
	
	
	public List<TypeCarburant> getAll()  throws SQLException{
		List<TypeCarburant> listeCarb = new ArrayList<TypeCarburant>();
		
        String request= "select * from typecarburant";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		resultSet = this.preparedStatement.executeQuery(); 
		
		
		while ( this.resultSet.next()) {
 
			 listeCarb.add(new TypeCarburant(this.resultSet.getInt(1),this.resultSet.getString(2), this.resultSet.getString(3)));
		}
		
					
		return listeCarb;
		
	}

	
	public TypeCarburant getByLibelle(String Libelle) throws SQLException{
		
		String request= "select * from typecarburant where Libelle = ?";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		this.preparedStatement.setString(1, Libelle);
		
		resultSet = this.preparedStatement.executeQuery(); 
		
		TypeCarburant TC = null ;
		
		while ( this.resultSet.next()) {
		
		TC = new TypeCarburant(this.resultSet.getInt(1),this.resultSet.getString(2), this.resultSet.getString(3));
		
		}
		
		return TC;
		
	}

	
	public TypeCarburant getById(int id) throws SQLException{
		
		String request= "select * from typecarburant where id = ?";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		this.preparedStatement.setInt(1, id);
		
		resultSet = this.preparedStatement.executeQuery(); 
		
		TypeCarburant TC = null ;
		
		while ( this.resultSet.next()) {
		
		TC = new TypeCarburant(this.resultSet.getInt(1),this.resultSet.getString(2), this.resultSet.getString(3));
		
		}
		
		return TC;
		
	}

	
	
	
}
