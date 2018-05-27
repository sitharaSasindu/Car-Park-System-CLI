package carPark;

public class Car extends Vehicle {

	private int noOfDoors;
	private String color;

	public Car(String iDPlate, String brandOfTheVehicle, DateTime entryTimeDate, int noOfDoors, String color, String type) {
		super(iDPlate, brandOfTheVehicle, entryTimeDate, type);
		this.noOfDoors = noOfDoors;
		this.color = color;
	}

	public int getNoOfDoors() {
		return noOfDoors;
	}

	public String getColor() {
		return color;
	}

}
