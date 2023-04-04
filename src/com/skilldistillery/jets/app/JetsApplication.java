package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.enteties.AirField;
import com.skilldistillery.jets.enteties.CargoPlane;
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
				hangar.implementCargoMode();

			} else if (input.equals("6")) {
				hangar.implementFightMode();

			} else if (input.equals("7")) {
				System.out.println("Input The type of jet you would like to add(Fighter or Cargo): ");
				String newType = sc.nextLine();
				if (newType.toUpperCase().equals("CARGO")) {
					System.out.println("What Is The Model Of Your Jet? ");
					String newModel = sc.nextLine();
					System.out.println("What Is The Speed Of Your Jet? ");
					String newSpeed = sc.nextLine();
					double speed = Double.parseDouble(newSpeed);
					System.out.println("What Is The Range Of Your Jet? ");
					String newRange = sc.nextLine();
					double range = Double.parseDouble(newRange);
					System.out.println("What Is The Price Of Your Jet? ");
					String newPrice = sc.nextLine();
					double price = Double.parseDouble(newPrice);
					Jet newCargoJet = new CargoPlane("Cargo " + newModel, speed, range, price);
					hangar.addNewJet(newCargoJet);

				} else if (newType.toUpperCase().equals("FIGHTER")) {
					System.out.println("What Is The Model Of Your Jet? ");
					String newModel = sc.nextLine();
					System.out.println("What Is The Speed Of Your Jet? ");
					String newSpeed = sc.nextLine();
					double speed = Double.parseDouble(newSpeed);
					System.out.println("What Is The Range Of Your Jet? ");
					String newRange = sc.nextLine();
					double range = Double.parseDouble(newRange);
					System.out.println("What Is The Price Of Your Jet? ");
					String newPrice = sc.nextLine();
					double price = Double.parseDouble(newPrice);
					Jet newFighterJet = new CargoPlane("Fighter " + newModel, speed, range, price);
					hangar.addNewJet(newFighterJet);

				}

			} else if (input.equals("8")) {
				int i = 0;
				for (Jet jets : hangar.getFleet()) {
					System.out.println("[" + i++ + "]" + " " + jets);
				}
				System.out.println("\n Input The Line Number Of The Jet You Would Like To Remove: ");
				String remove = sc.nextLine();
				int r = Integer.parseInt(remove);
				hangar.getFleet().remove(r);
				}
		}
		System.out.println("Exiting App");
		sc.close();
	}

	public void printMenu() {
		System.out.println("**************\n" + "*    Menu    *" + "\n**************" + "\n[1] ListFleet"
				+ "\n[2] Fly all Jets" + "\n[3] View Fastest Jet" + "\n[4] View Jet with fastest range"
				+ "\n[5] Load all Cargo Jets" + "\n[6] Dogfight!" + "\n[7] Add a jet to Fleet"
				+ "\n[8] Remove a jet from Fleet" + "\n[9] Quit");
	}
}
