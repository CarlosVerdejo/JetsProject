package com.skilldistillery.jets.enteties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AirField{
	private List<Jet> fleet = new ArrayList<>();
	private List<String> flyFleet = new ArrayList<>();
	public AirField() {
		readFromFile("jets.txt");
	}

	public void readFromFile(String fn) {
		BufferedReader bufIn = null;
		try {
			bufIn = new BufferedReader(new FileReader(fn));
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetDetails = line.split(",");
				String model = jetDetails[0];
				double speed = Double.parseDouble(jetDetails[1]);
				double range = Double.parseDouble(jetDetails[2]);
				double price = Double.parseDouble(jetDetails[3]);
				if (model.contains("Cargo")) {
					Jet cargo = new CargoPlane(model, speed, range, price);
					fleet.add(cargo);
					String flyCargo = cargo.fly(model, speed, range, price);
					flyFleet.add(flyCargo);
				} else if (model.contains("Fighter")) {
					Jet fighter = new FighterJet(model, speed, range, price);
					fleet.add(fighter);
					String flyFighter = fighter.fly(model, speed, range, price);
					flyFleet.add(flyFighter);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	public void listTheFleet() {
		System.out.println("\nHere are the aircrafts in the fleet!");
		for(Jet jets : fleet) {
			System.out.println(jets.toString());
		}
		System.out.println();
	}

	public void flyTheJets() {
		for (Jet jet : fleet) {
			System.out.println(jet.fly(jet.getModel(),jet.getSpeed() , jet.getRange(), jet.getPrice()));
		}
	}

	public void determineFastestJet() {
		double fastestJet = fleet.get(0).getSpeed();
		for (int i = 0; i < fleet.size(); i++) {
			if (fastestJet < fleet.get(i).getSpeed()) {
				fastestJet = fleet.get(i).getSpeed();
			}
		}for(Jet jets : fleet) {
			if(jets.getSpeed() == fastestJet) {
				System.out.println("\nThe Fastest Jet In This Fleet Is: \n" + jets.toString());
			}	
		}
		System.out.println();
	}
	
	public void determineLongestTravelingJet() {
		double bestTravelTime = fleet.get(0).getRange() / fleet.get(0).getSpeed();
		for (int i = 0; i < fleet.size(); i++) {
			if (bestTravelTime < fleet.get(i).getRange() / fleet.get(i).getSpeed()) {
				bestTravelTime =  fleet.get(i).getRange() / fleet.get(i).getSpeed();
			}
		}for (Jet jets : fleet) {
				if (jets.getRange() / jets.getSpeed() == bestTravelTime) {
				System.out.println("\nThe Jet With The Longest Range is: \n" + jets.toString()+ "\nWith A Range Of " + bestTravelTime + "Hours At Max Speed!\n");
				}
			}	
	}

	public void implementCargoMode() {
		for (Jet jet : fleet) {
			if (jet instanceof CargoPlane) {
				System.out.print(jet.getModel() + " ");
				jet.loadCargo();
				System.out.println();
			}
		}
	}
	
	public void implementFightMode() {
		for (Jet jet : fleet) {
			if (jet instanceof FighterJet) {
				System.out.print(jet.getModel() + " ");
				jet.fight();
				System.out.println();
			}
		}
	}		
	
	public void addNewJet(Jet newOne) {
		fleet.add(newOne);
	}
	
	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}
}
