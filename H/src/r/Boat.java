package r;

import java.util.stream.Collectors;

public class Boat extends Vehicle{
	String type;
	int draft;
	boolean hasEngines;

	public Boat(String brand, int seatCount, int maxSpeed, int fuelConsumption, String type, int draft) {
		super(brand, seatCount, maxSpeed, fuelConsumption);
		this.type = type;
		this.draft = draft;
	}
	public String toString() {
		return "This " + brand + " has " + seatCount + " seats and it can go up to " + maxSpeed + "km/h while burning " + fuelConsumption + " litres of fuel per 100 km!";
	}
	boolean isFaster(Vehicle b) {
		if(b instanceof Plane) return false;
		if(b instanceof Boat && this.draft >= ((Boat) b).draft) return false;
		return true;
	}
	int getPaddleCount() {
		if(hasEngines) return 0;
		return draft;
	}
	static long getBoatCount() {
		return Vehicle.all
				.stream()
				.filter(v -> v instanceof Boat)
				.count();
	}
	static double getAvgPaddleCount() {
		long paddles = Vehicle.all
					.stream()
					.filter(v -> v instanceof Boat)
					.map(v -> ((Boat) v).getPaddleCount())
					.collect(Collectors.summingInt(Integer::intValue));
		return 1.0 * paddles / getBoatCount();
	}
}