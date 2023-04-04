package com.skilldistillery.jets.enteties;

public abstract class Jet{
	private String model;
	private double speed;
	private double range;
	private double price;
	
	
	public String fly(String model, double speed, double range, double price) {
		double flightTime = range / speed; 
		String flightTimeString  =toString() + "\nThis Aircraft Can Travel " + flightTime + " Hours At Maximum Speed Before Running Out Of Fuel.\n";
		return flightTimeString;
	}

	
	@Override
	public String toString() {
		return "[Model = " + model + ", Speed = " + speed + ", Range = " + range + ", Price = " + price + "]";
	}


	public Jet(String model, double speed, double range, double price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getRange() {
		return range;
	}
	public void setRange(double range) {
		this.range = range;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
	

}
