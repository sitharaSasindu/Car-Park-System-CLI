package carPark;

public class Van extends Vehicle {

	private int cargoVolume;
	
	public Van(String iDPlate, String brandOfTheVehicle, DateTime entryTimeDate, int cargoVolume, String type) {
		super(iDPlate, brandOfTheVehicle, entryTimeDate, type);
		this.cargoVolume = cargoVolume;
	}

	public int getCargoVolume() {
		return cargoVolume;
	}

}
