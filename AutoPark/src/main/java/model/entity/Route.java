package model.entity;

public class Route {
	private int id;
	private int distance;
	private String name;
	
	
	
	public Route(int distance, String name) {
		
		this.distance = distance;
		this.name = name;
		
	}
	public Route(int id, int distance, String name) {
		
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
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
