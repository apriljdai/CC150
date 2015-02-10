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
	private ParkingSpot[] spots;	//number of spots in each level, including large, compact and motorcycle size
	private int availableSpots = 0;	//number of free spots
	private static final int SPOT_PER_ROW = 10;

	public Level(int flr, int numberSpots){
		floor = flr;
		availableSpots = numberSpots;
		spots = new ParkingSpot[numberSpots];

		int largeSpots = numberSpots / 4;
		int bikeSpots = numberSpots / 4;
		int compactSpots = numberSpots - largeSpots - bikeSpots;

		for (int i = 0; i < numberSpots; i++){
			VehicleSize sz = VehicleSize.Motorcycle;
			if (i < largeSpots){
				sz = VehicleSize.Large;
			}
			else if (i < largeSpots + compactSpots){
				sz = VehicleSize.Compact;
			}
			int row = i / SPOT_PER_ROW;
			spots[i] = new ParkingSpot(this, row, i, sz);
		}
	}

	public int availableSpots(){
		return availableSpots;
	}

	public boolean parkVehicle(Vehicle vehicle){
		//find a place to park this vehicle, return false if failed
		if (availableSpots() < vehicle.getSpotsNeeded())
			return false;

		int spotNumber = findAvailableSpots(vehicle);
		if (spotNumber < 0)
			return false;
		return parkStartingAtSpot(spotNumber, vehicle);
	}

	private boolean parkStartingAtSpot(int num, Vehicle v){
		//park a vehicle starting at the spot spotNumber, and continuing until vehicle.spotsNeeded
		vehicle.clearSpots();
		boolean success = true;
		for (int i = num; i < num + vehicle.spotsNeeded; i++){
			success &= spots[i].park(vehicle);
		}
		availableSpots -= vehicle.spotsNeeded;
		return success;
	}

	private int findAvailableSpots(Vehicle vehicle){
		int spotsNeeded = vehicle.getSpotsNeeded();
		int lastRow = -1;
		int spotsFound = 0;

		for (int i = 0; i < spots.length; i++){
			ParkingSpot spot = spots[i];
			if (lastRow != spots.getRow()){
				spotsFound = 0;
				lastRow = spots.getRow();
			}
			if (spots.canFitVehicle(vehicle)){
				spotsFound++;
			}
			else{
				spotsFound = 0;
			}
			if (spotsFound == spotsNeeded){
				return i - (spotsNeeded - 1);
			}
		}
		return -1;
	}

	public void spotFreed(){
		availableSpots++;
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

	public boolean park(Vehicle v){
		if (!canFitVehicle(v))
			return false;

		vehicle = v;
		vehicle.parkInSpot(this);
		return true;
	}

	public int getRow(){
		return row;
	}
	public int getSpotNumber(){
		return spotNumber;
	}
	public VehicleSize getSize(){
		return spotSize;
	}

	public void removeVehicle(){
		level.spotFreed();
		vehicle = null;
	}
}