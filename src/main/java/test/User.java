package test;

public class User {
	
	private int id = 0;
	private String nom;
	private String prenom;
	private	String login;
	private	String password;
	private String code;
	private String grade;
	private String type;
	
	
	public User(int id, String nom, String prenom, String login, String password, String code, String grade, String type) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.code = code;
		this.grade = grade;
		this.type = type;
	}

	
	public User(String nom, String prenom, String login, String password, String code, String grade, String type) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.code = code;
		this.grade = grade;
		this.type = type;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
}
