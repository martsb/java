package r;

import java.util.ArrayList;

public class Plane extends Vehicle{
	int engineCount;
	String type;
	ArrayList<Plane> planes = new ArrayList<>();
	
	public Plane(String brand, int seatCount, int maxSpeed, int fuelConsumption, int engineCount, String type) {
		super(brand, seatCount, maxSpeed, fuelConsumption);
		this.engineCount = engineCount;
		this.type = type;
		planes.add(this);
	}
	public String toString() {
		return "This " + brand + " has " + seatCount + " seats and it can go up to " + maxSpeed + "km/h while burning " + fuelConsumption + " litres of fuel per 100 km!";
	}
	double getFuelPerPassenger() {
		return super.getFuelPerPassenger() * engineCount;
	}
	boolean canLandOnWater() {
		if(this.type.equals("Seaplane") || 
		   this.type.equals("Amphibian")) {
			return true;
		}
		return false;
	}
	boolean canLandOnLand(String type) {
		if(type.equals("Landplane") ||
		   type.equals("Amphibian")) {
			return true;
		}
		return false;
	}
	long canLandOnWaterCount() {
		return planes
				.stream()
				.filter(v -> v.canLandOnWater())
				.count();
	}
	
}