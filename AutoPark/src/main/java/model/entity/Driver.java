package model.entity;

public class Driver {
	private int id;
	private String login;
	private String password;
	private boolean confirmed;
	private boolean isFree;
	
	public Driver(String login, String password) {
		this.login = login;
		this.password = password;
	}
	public Driver(int id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}
	public Driver(int id, String login, String password, boolean confirmed) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.confirmed = confirmed;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	public boolean isFree() {
		return isFree;
	}
	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	
}
