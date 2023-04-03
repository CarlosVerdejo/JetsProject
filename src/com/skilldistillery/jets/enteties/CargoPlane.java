package com.skilldistillery.jets.enteties;

public class CargoPlane extends Jet {
	

	public CargoPlane(String model, double speed, double range, double price) {
	super(model, speed, range, price);
		
	}

	public abstract interface LoadTheCargo {
		void loadCargo();
	
	}

	
	
}
