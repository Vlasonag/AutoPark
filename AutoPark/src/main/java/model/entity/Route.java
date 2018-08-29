package model.entity;

public class Route {
	private int id;
	private String distance;
	private String name;
	
	
	
	public Route(String distance, String name) {
		this.distance = distance;
		this.name = name;
	}
	public Route(int id, String distance, String name) {
		this.id = id;
		this.distance = distance;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
