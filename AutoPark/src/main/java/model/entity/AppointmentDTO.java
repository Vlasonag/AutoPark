package model.entity;

public class AppointmentDTO {

	
	private String route_name;
	private int route_distance;
	private String car_number;
	private String car_model;
	private int driver_id;
	private String driver_login;
	private boolean isConfirmed;
	
	public AppointmentDTO(String route_name, int route_distance, String car_number,
			String car_model, int driver_id, String driver_login) {
		this.route_name= route_name;
		this.route_distance =route_distance;
		this.car_number = car_number;
		this.car_model = car_model;
		this.driver_id = driver_id;
		this.driver_login = driver_login;
	}

	public AppointmentDTO(String route_name, int route_distance, String car_number,
			String car_model, int driver_id, String driver_login, boolean isConfirmed) {
		this.route_name= route_name;
		this.route_distance =route_distance;
		this.car_number = car_number;
		this.car_model = car_model;
		this.driver_id = driver_id;
		this.driver_login = driver_login;
		this.isConfirmed = isConfirmed;
	}

	public String getRoute_name() {
		return route_name;
	}

	public void setRoute_name(String route_name) {
		this.route_name = route_name;
	}

	public int getRoute_distance() {
		return route_distance;
	}

	public void setRoute_distance(int route_distance) {
		this.route_distance = route_distance;
	}

	public String getCar_number() {
		return car_number;
	}

	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}

	public String getCar_model() {
		return car_model;
	}

	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}

	public int getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}

	public String getDriver_login() {
		return driver_login;
	}

	public void setDriver_login(String driver_login) {
		this.driver_login = driver_login;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
	
	
		
}
