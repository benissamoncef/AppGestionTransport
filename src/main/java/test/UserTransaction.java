package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserTransaction extends BaseTransaction<User> {
	
	
	public UserTransaction() throws SQLException {
		// TODO Auto-generated constructor stub
	}

	public void save(User object)  throws SQLException{
		

		String request= "insert into user (nom, prenom, login, password, code, grade, type) values (?, ?, ? , ?, ?, ?, ?)"; 
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		// maooing relatipon et objet table client et objet client 
		this.preparedStatement.setString(1, object.getNom());
		this.preparedStatement.setString(2, object.getPrenom());
		this.preparedStatement.setString(3, object.getLogin());	
		this.preparedStatement.setString(4, object.getPassword());
		this.preparedStatement.setString(5, object.getCode());
		this.preparedStatement.setString(6, object.getGrade());
		this.preparedStatement.setString(7, object.getType());
		
		this.preparedStatement.execute();
		
	} 
	
	public void update(User object, int id)  throws SQLException{
		

		String request= "update user set nom = ?, prenom = ?, code = ?, grade = ? where id = ?";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		
		this.preparedStatement.setString(1, object.getNom());
		this.preparedStatement.setString(2, object.getPrenom());
		this.preparedStatement.setString(3, object.getCode());
		this.preparedStatement.setString(4, object.getGrade());		
		this.preparedStatement.setInt(5, id);
		
		this.preparedStatement.execute();
		
		
	} 
	public void delete(int id)  throws SQLException{
		String request= "delete from user where id = ?";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
	
		this.preparedStatement.setInt(1, id);
		
		this.preparedStatement.execute();
	} 
	public List<User> getAll()  throws SQLException{
		
		List<User> listeUsers = new ArrayList<User>();
		
        String request= "select * from user";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		resultSet = this.preparedStatement.executeQuery(); 
		
		
		while ( this.resultSet.next()) {
 
			listeUsers.add(new User(this.resultSet.getInt(1),this.resultSet.getString(2), this.resultSet.getString(3), this.resultSet.getString(4), this.resultSet.getString(5), this.resultSet.getString(6), this.resultSet.getString(7), this.resultSet.getString(8)));
		}
		
					
		return listeUsers;

	} 
	public User getByCode(String code)  throws SQLException{
		String request= "select * from user where code = ?";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		this.preparedStatement.setString(1, code);
		
		resultSet = this.preparedStatement.executeQuery(); 
		
		User user = null ;
		
		while ( this.resultSet.next()) {
		
			user = new User(this.resultSet.getInt(1),this.resultSet.getString(2), this.resultSet.getString(3), this.resultSet.getString(4), this.resultSet.getString(5), this.resultSet.getString(6), this.resultSet.getString(7), this.resultSet.getString(8));
		
		}
		
		return user;
		
	} 
	
	public User getById(int id)  throws SQLException{
		String request= "select * from user where id = ?";
		
		this.preparedStatement = this.cnx.prepareStatement(request);
		
		this.preparedStatement.setInt(1, id);
		
		resultSet = this.preparedStatement.executeQuery(); 
		
		User user = null ;
		
		while ( this.resultSet.next()) {
		
			user = new User(this.resultSet.getInt(1),this.resultSet.getString(2), this.resultSet.getString(3), this.resultSet.getString(4), this.resultSet.getString(5), this.resultSet.getString(6), this.resultSet.getString(7), this.resultSet.getString(8));
		
		}
		
		return user;
		
	} 
	
	public List<User> getAll(String type)  throws SQLException{
		
		if(!type.isEmpty()) {
		List<User> listeUsers = new ArrayList<User>();
		
        String request= "select * from user where type = ?";
        this.preparedStatement = this.cnx.prepareStatement(request);
        
        this.preparedStatement.setString(1, type);
		
		
		resultSet = this.preparedStatement.executeQuery(); 
		
		
		while ( this.resultSet.next()) {
 
			listeUsers.add(new User(this.resultSet.getInt(1),this.resultSet.getString(2), this.resultSet.getString(3), this.resultSet.getString(4), this.resultSet.getString(5), this.resultSet.getString(6), this.resultSet.getString(7), this.resultSet.getString(8)));
		}
		
					
		return listeUsers;
		}else {
			return null;
		}
		
	} 
	
	
	
	
	

}
