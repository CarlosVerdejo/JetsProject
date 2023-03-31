package com.skilldistillery.jets.enteties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> fleet;
	public AirField() {
		// populate its fleet from file
	}
	
	
	
	public List<Jet> readFromFile(String fn) {
		List<Jet> jets = new ArrayList<>();
		BufferedReader bufIn = null;
		try {
		  bufIn = new BufferedReader(new FileReader("jets.txt"));
		  String aJet;
		  while ((aJet = bufIn.readLine()) != null) {
		    String[] jetDetails = aJet.split(",");
		    
		    //if the jetDetails[0] happens to be a DCV, then create a DilithiumPowered jet
		    //if the jetDetails[0] happens to be a Fighter, then create a Fighter jet
		  }
		}
		catch (IOException e) {
		  System.err.println(e);
		}
		
		// read in the various types from the file
		
		
		
		
		// as you read in a jet, create a Jet
		// and add that specific Jet type to your jets list
		
		
		return jets;
	}
}
