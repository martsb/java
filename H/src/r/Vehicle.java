package r;

import java.util.ArrayList;

public class Vehicle {
	String brand;
	int seatCount;
	int maxSpeed;
	int fuelConsumption;
	static ArrayList<Vehicle> all = new ArrayList<>();
	
	Vehicle(String brand, int seatCount, int maxSpeed, int fuelConsumption) {
		this.brand = brand;
		this.seatCount = seatCount;
		this.maxSpeed = maxSpeed;
		this.fuelConsumption = fuelConsumption;
		all.add(this);
	}
	public String toString() {
		return "This " + brand + " has " + seatCount + " seats and it can go up to " + maxSpeed + "km/h while burning " + fuelConsumption + " litres of fuel per 100 km!";
	}
	double getFuelPerPassenger() {
		return 1.0 * fuelConsumption / seatCount;
	}
	boolean isFaster(Vehicle b) {
		return this.maxSpeed > b.maxSpeed;
	}
}
