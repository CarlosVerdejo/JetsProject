package com.skilldistillery.jets.enteties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AirField {
	private List<Jet> fleet = new ArrayList<>();



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
			    Jet Cargo = new CargoPlane(model, speed, range, price);
			    fleet.add(Cargo);
			    }
			    else if (model.contains("Fighter")) { 
			    	Jet Fighter = new FighterJet(model, speed, range, price);
			    	fleet.add(Fighter);
			    }
			  }
		}
			catch (IOException e) {
			  System.err.println(e);
			}
		    
		    //if the jetDetails[0] happens to be a DCV, then create a DilithiumPowered jet
		    //if the jetDetails[0] happens to be a Fighter, then create a Fighter jet
		  }

		

		
		// read in the various types from the file
		// as you read in a jet, create a Jet
		// and add that specific Jet type to your jets list
		
	
	public List<Jet> getFleet() {	
		return fleet;
	}
	
	
	
	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}
}
