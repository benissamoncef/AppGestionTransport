package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseTransaction<T> {
	
	
	protected Connection cnx ;
	
	protected Statement statement ;
	
	
	protected PreparedStatement preparedStatement ;
	
	
	protected ResultSet resultSet ;
	
	private String url = "jdbc:mysql://localhost:3306/test";
	private String login = "root";
	private String pass = "";
	
	
	public BaseTransaction() throws SQLException {
		
		this.cnx = DriverManager.getConnection(url, login,pass );
		
	}
	
	
	public abstract void save(T object)  throws SQLException ;
	public abstract void update(T object, int id)  throws SQLException ;
	public abstract void delete(int id)  throws SQLException ;
	public abstract List<T> getAll()  throws SQLException ;
	
	
	

}
