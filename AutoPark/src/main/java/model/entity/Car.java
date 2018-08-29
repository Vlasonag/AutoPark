package model.entity;

public class Car {
	private String number;
	private String model;
	private boolean isFree;
	
	public Car(String number, String model, boolean isFree) {
		super();
		this.number = number;
		this.model = model;
		this.isFree = isFree;
	}
	public Car(String number, String model) {
		super();
		this.number = number;
		this.model = model;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public boolean isFree() {
		return isFree;
	}
	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	
}
