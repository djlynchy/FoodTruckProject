package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private static int nextTruckID = 20221;
	private String name;
	private String food;
	private int id;
	private int score;
	
	public FoodTruck() {
		
	}
	public FoodTruck(String name, String food, int score) {
		this(name, food, score, nextTruckID);}
	
	public FoodTruck(String name, String food, int id, int score) {
		this.name = name;
		this.food = food;
		this.id = id;
		this.score = score;
	}

	public static int getNextTruckID() {
		return nextTruckID;
	}
	public static void setNextTruckID(int nextTruckID) {
		FoodTruck.nextTruckID = nextTruckID;
	}
	public void setNextTruckID() {
		nextTruckID++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public void getId() {
		 id++;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String toString() {
		return "FoodTruck [name=" + name + ",\t food=" + food + ",\t id=" + score + ",\t score=" + id + "]";
		
	
	}

}	
	




	

