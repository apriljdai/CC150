/*
Design a parking lot using object-oriented principles.
*/

//what type of vehicles it can support
//whether the parking lot has multiple levels
//-> make assumptions
//the parking lot has multiple levels, each level has multiple rows of spots
//the parking lot can park motorcycles, cars, and buses
//the parking lot chas motorcycle spots, compact spots, and large spots
//a motorcycle could park in any spots
//a car can park in either a single compact spot or a single large spot
//a bus can park in five large spots that are consecutive and within the same row, it cannot park in small spots

//abstract class for vehicle, car, bus and motorcycle inherit.
//parkingspot to handle the different parking spot size

public enum VehicleSize{
	Motorcycle, Compact, Large,
}

public abstract class Vehicle{
	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	protected String licensePlate;
	protected int spotsNeeded;
	protected VehicleSize size;

	public int getSpotsNeeded(){
		return spotsNeeded;
	}
	public VehicleSize getSize(){
		return size;
	}

	public void parkInSpot(parkingSpot s){
		parkingSpots.add(s);
	}

	public void clearSpots(){
		//remove car from spot, and notify spot that it's gone
		for (int i = 0; i < parkingSpots.size(); i++){
			parkingSpots.get(i).removeVehicle();
		}
		parkingSpots.clear();
	}

	public abstract boolean canFitInSpot(ParkingSpot spot);
}

public class Bus extends Vehicle{
	public Bus(){
		spotsNeeded = 5;
		size = VehicleSize.Large;
	}

	public boolean canFitInSpot(ParkingSpot spot){
		//checks if the spot is a Large, does NOT check num of spots
		return spot.getSize() == VehicleSize.Large;
	}
}

public class Car extends Vehicle{
	public Car(){
		spotsNeeded = 1;
		size = VehicleSize.Compact;
	}

	public boolean canFitInSpot(parkingSpot spot){
		//checks if the spot is a compact or a large
		return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
	}
}

public class Motorcycle extends Vehicle{
	public Motorcycle(){
		spotsNeeded = 1;
		size = VehicleSize.Motorcycle;
	}

	public boolean canFitInSpot(parkingSpot spot){
		//checks if the spot is a compact, motorcycle or a large
		return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact || spot.getSize() == VehicleSize.Motorcycle;
	}
}

//a wrapper class for class of Levels
public class ParkingLot{
	private Level[] levels;
	private final int NUM_LEVELS = 5;

	public ParkingLot(){
		levels = new Level[NUM_LEVELS];
		for (int i = 0; i < NUM_LEVELS; i++){
			levels[i] = new Level(i, 30);
		}
	}

	public boolean parkVehicle(Vehicle vehicle){
		for (int i = 0; i < levels.length; i++){
			if (levels[i].parkVehicle(vehicle))
				return true;
		}
		return false;
	}
}

//represent a level in a parking garage
public class Level{
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0;
	private static final int SPOT_PER_ROW = 10;

	public Level(int flr, int numberSpots){
		floor = flr;
		availableSpots = numberSpots;
	}

	public int availableSpots(){
		return availableSpots;
	}

	public boolean parkVehicle(Vehicle vehicle){
		//find a place to park this vehicle, return false if failed
	}

	private boolean parkStartingAtSpot(int num, Vehicle v){
		//park a vehicle starting at the spot spotNumber, and continuing until vehicle.spotsNeeded
	}
}

//implemented by having just a variable which represents the size of the spot
public class ParkingSpot{
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;

	public ParkingSpot(Level lvl, int r, int n, VehicleSize s){
		level = lvl;
		row = r;
		spotNumber = n;
		spotSize = s;
	}

	public boolean isAvailable(){
		return vehicle == null;
	}

	public boolean canFitVehicle(Vehicle vehicle){
		//check if the spot is big enough and is available
		return isAvailable() && vehicle.canFitInSpot(this);
	}

}