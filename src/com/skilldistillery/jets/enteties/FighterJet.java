package com.skilldistillery.jets.enteties;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, double range, double price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println("In Fight Mode");
	
	
	}
	
	
	
	
	

}
