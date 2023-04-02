package com.skilldistillery.jets.enteties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AirField {
	private List<Jet> fleet = new ArrayList<>();
	private List<String> flyFleet = new ArrayList<>();

	public AirField() {
		// populate its fleet from file
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

	public void flyTheJets() {
		for(int i = 0; i < flyFleet.size(); i++) {
			System.out.println(flyFleet.get(i));

		}

	}

	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}
}
