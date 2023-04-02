package com.skilldistillery.jets.app;

import java.util.List;
import java.util.Scanner;
import com.skilldistillery.jets.enteties.AirField;
import com.skilldistillery.jets.enteties.Jet;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication j = new JetsApplication();
		j.launch();
	}

	public void launch() { 
		Scanner sc = new Scanner(System.in);
		AirField hangar = new AirField();
		boolean run = true;

		while (run) {
		printMenu();
		String input = sc.nextLine();
		
		if (input.equals("9")) {
			run = false;
			
		} else if (input.equals("1")) {
			hangar.listTheFleet();
			
		} else if (input.equals("2")) {
			hangar.flyTheJets();
		
		} else if (input.equals("3")) {
			hangar.determineFastestJet();

		} else if (input.equals("4")) {
			hangar.determineLongestTravelingJet();

		} else if (input.equals("5")) {

		} else if (input.equals("6")) {

		} else if (input.equals("7")) {

		} else if (input.equals("8")) {

		}
		}
		System.out.println("Exiting App");
		sc.close();
	}

	public void printMenu() {
		System.out.println("**************\n"
				+ "*    Menu    *" +"\n**************" + "\n[1] ListFleet" + "\n[2] Fly all Jets" + "\n[3] View Fastest Jet"
				+ "\n[4] View Jet with fastest range" + "\n[5] Load all Cargo Jets" + "\n[6] Dogfight!"
				+ "\n[7] Add a jet to Fleet" + "\n[8] Remove a jet from Fleet" + "\n[9] Quit");
	}
}
