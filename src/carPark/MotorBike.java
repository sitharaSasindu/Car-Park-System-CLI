package carPark;

public class MotorBike extends Vehicle {

	private String engineSize;

	public MotorBike(String iDPlate, String brandOfTheVehicle, DateTime entryTimeDate, String engineSize, String type) {
		super(iDPlate, brandOfTheVehicle, entryTimeDate, type);
		this.engineSize = engineSize;
	}

	public String getEngineSize() {
		return engineSize;
	}

}
