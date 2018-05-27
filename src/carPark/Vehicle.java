package carPark;

public abstract class Vehicle {

	private String IDPlate;
	private String brandOfTheVehicle;
	private DateTime entryTimeDate;
	private String type;

	public Vehicle(String iDPlate, String brandOfTheVehicle, DateTime entryTimeDate, String type) {
		super();
		IDPlate = iDPlate;
		this.brandOfTheVehicle = brandOfTheVehicle;
		this.entryTimeDate = entryTimeDate;
		this.type = type;
	}

	public String getIDPlate() {
		return IDPlate;
	}

	public String getBrandOfTheVehicle() {
		return brandOfTheVehicle;
	}

	public DateTime getEntryTimeDate() {
		return entryTimeDate;
	}
	
	public String getType() {
		return type;
	}

}
