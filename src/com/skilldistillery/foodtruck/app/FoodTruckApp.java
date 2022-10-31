package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp{


		
		private static final int totalTrucks = 5;
		FoodTruck[] trucks = new FoodTruck[totalTrucks];
		private int amount = 0;
	
		public static void main(String[] args ) {
			FoodTruckApp fT = new FoodTruckApp();
			System.out.println("Welcome to food truck!");
			fT.run();
		}
				
private void run() {			
	Scanner scan = new Scanner(System.in);
	String selection;

	do {
		displayMenu();
		selection = scan.nextLine();
		
		switch (selection) {
		case "1":
			if (amount == trucks.length) {
				System.out.println("Can not hold any more trucks. Press any key to return to main menu: ");
				scan.nextLine();
				break;
			} else {
				newTruck(scan);
				break;
			}
		case "2":
			displayTrucks();
			System.out.print("\nEnter any key to return: ");
			scan.nextLine();
			System.out.println("");
			break;
		case "3":
			displayAvg();
			System.out.print("\nEnter any key to return: ");
			scan.nextLine();
			break;
		case "4":
			displayHighRated();
			System.out.print("\nEnter any key to return: ");
			scan.nextLine();
			break;
		case "5":
			System.out.println("thanks for using this program.");
			break;
		default:
			System.out.print("\nNot Valid. Enter any key to return to main menu: ");
			scan.nextLine();
		}
	} while (!selection.equals("5"));
	
	scan.close();
}

private void displayMenu() {
	System.out.println("**************************");
	System.out.println("* 1 : Enter Food Truck   *");
	System.out.println("* 2 : All Trucks Present *");
	System.out.println("* 3 : Food Truck Average *");
	System.out.println("* 4 : Best Food Truck    *");
	System.out.println("* 5 : Quit               *");
	System.out.println("**************************");
	
}

private void displayMenu2() {
	System.out.print("\n1. Add another truck\n2. Return");
}

private void newTruck(Scanner scan) {
	int selection2;
	String name;
	String food;
	int score;
	do {
		System.out.println("Enter name of a food truck!:  \nOr *quit* to main menu. ");
		name = scan.nextLine();
		if(checkQuit(name)) {
			break;
		}
		
		System.out.println("What type of *ahem* 'food' does " + name + " have?: ");
		food = scan.nextLine();

		System.out.print("What would you score " + name + "?: \nOn a scale from 1-5.");
		score = scan.nextInt();
		scan.nextLine();

		FoodTruck newTruck = new FoodTruck(name, food, score);
		addTruck(newTruck);
		newTruck.setNextTruckID();

		if (amount < trucks.length) {
			displayMenu2();
			selection2 = scan.nextInt();
			scan.nextLine();
			switch (selection2) {
			case 1:
				continue;
			case 2:
				break;
			}
		} else {
			System.out.print("Lots full ");
			scan.nextLine();
			break;
		}
	} while (selection2 == 1); 
} 

private void addTruck(FoodTruck truck) {
	trucks[amount] = truck;
	amount++;	
}

private void displayTrucks() {
	System.out.println("");
	for (FoodTruck truck : trucks) {
		if (truck != null) {
			System.out.println(truck.toString());
		}

	}
}

private void displayAvg() {
	double totScore = 0.0;
	double avgScore = 0.0;
	for (FoodTruck truck : trucks) {
		if (truck != null) {
			totScore += truck.getScore();
		}
	}
	avgScore = (totScore) / (amount);
	System.out.println("Average rating for all food trucks is " + avgScore);

}

private void displayHighRated() {
	int highest = 0;
	for (FoodTruck truck : trucks) {
		if (truck != null) {
			if (truck.getScore() > highest) {
				highest = truck.getScore();
			}
		}
	}
	for (FoodTruck truck : trucks) {
		if (truck != null) {
			if (truck.getScore() == highest) {
				System.out.println(truck.toString());
			}
		}
	}
}

boolean checkQuit( String name) {
	boolean result = false;
	switch (name) {
	case "q":
		result = true;
		break;
	case "quit":
		result = true;
		break;
	case "QUIT":
		result = true;
		break;
	}

	return result;
}
	
	}