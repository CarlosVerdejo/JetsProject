package com.skilldistillery.jets.enteties;

public class CargoPlane extends Jet implements LoadCargo{
	

	public CargoPlane(String model, double speed, double range, double price) {
	super(model, speed, range, price);
		
	}

	@Override
	public void loadCargo() {
		System.out.println("Cargo Loaded");
		
	}
	
	

	
	
}
