package carPark;

import java.util.Scanner;

public class WestminsterCarParkManager implements CarParkManager {

	public static Scanner sc = new Scanner(System.in);
	public static Vehicle[] vehicles = new Vehicle[20];
	static int carCount = 0;
	static int vanCount = 0;
	static int motorBikeCount = 0;
	// static int totalVehicles;
	static int mainMenu;
	static int addCount;
	static int bookedSlots;
	static int indexOfID = 0;
	static int totalVehicles = 0;

	public static void main(String[] args) {

		boolean menuCheck = true;
		while (menuCheck) {

			mainMenu();
			switch (mainMenu) {

			case 1:
				addNewVehicle();
				break;

			case 2:
				deleteVehicle();
				break;

			case 3:
				currentlyParkedVehicles();
				break;

			case 4:
				statictics();
				break;

			case 5:
				specificVehicles();
				break;

			case 6:
				parkingCharge();
				break;

			default:
				System.out.println("Please enter a Vaild Number");

			}
		}
	}

	public static void mainMenu() {

		System.out.println("------------------------------------------\n"
				+ "               Westminster Car Parking System                 \n"
				+ "------------------------------------------\n" + "MAIN MENU (Enter the Corresponding Number)\n"
				+ "------------------------------------------" + "\n1.Add a New Vehicle\n" + "\n2.Delete a Vehicle\n"
				+ "\n3.Display Currently Parked Vehicles\n" + "\n4.View Presentage of the Currently Parked Vehicles\n"
				+ "\n5.Vehicles Parked in a Specific Day\n" + "\n6.Final Chargers for Parking\n");
		System.out.println("Enter the Corresponding Number to Select a Option : ");
		mainMenu = sc.nextInt();
	}

	public static void addNewVehicle() {

		if (bookedSlots == 20) {
			System.out.println("Car Park is Full");
		} else {

			System.out.println("There are " + (20 - bookedSlots) + " Slots Available\n");

			System.out.println("Select the type of the Vehicle\n");
			System.out.println("1.Car\n");
			System.out.println("2.Van\n");
			System.out.println("3.Moter Bike\n");
			System.out.println("Enter the Corresponding Number to Select a Option : ");
			int vehicleType = sc.nextInt();

			if (vehicleType == 1) {

				addCar();

			} else if (vehicleType == 2) {

				addVan();

			} else if (vehicleType == 3) {

				addMotorBike();

			}
		}

	}

	public static void addCar() {

		System.out.println("Enter the Vehicle " + " ID Number : ");
		String vehicleID = sc.next();

		System.out.println("Enter the Vehicle " + " Brand : ");
		String brand = sc.next();

		System.out.println("Enter the Date and the time : ");
		System.out.println("Day : ");
		int day = sc.nextInt();
		System.out.println("Month : ");
		int month = sc.nextInt();
		System.out.println("Year : ");
		int year = sc.nextInt();
		System.out.println("Hours : ");
		int hours = sc.nextInt();
		System.out.println("Minutes : ");
		int minutes = sc.nextInt();

		DateTime datetime = new DateTime(day, month, year, hours, minutes);

		System.out.println("Enter Number of Doors of the Vehicle " + " : ");
		int noOfDoors = sc.nextInt();
		System.out.println("Enter the color of the Vehicle " + " : ");
		String color = sc.next();

		vehicles[bookedSlots] = new Car(vehicleID, brand, datetime, noOfDoors, color, "Car");
		System.out.println(vehicles[bookedSlots].getType() + " Successfully Added");
		carCount++;
		bookedSlots++;

	}

	public static void addVan() {

		System.out.println("Enter the Vehicle " + " ID Number : ");
		String vehicleID = sc.next();

		System.out.println("Enter the Vehicle " + " Brand : ");
		String brand = sc.next();

		System.out.println("Enter the Date and the time : ");
		System.out.println("Day : ");
		int day = sc.nextInt();
		System.out.println("Month : ");
		int month = sc.nextInt();
		System.out.println("Year : ");
		int year = sc.nextInt();
		System.out.println("Hours : ");
		int hours = sc.nextInt();
		System.out.println("Minutes : ");
		int minutes = sc.nextInt();

		DateTime datetime = new DateTime(day, month, year, hours, minutes);

		System.out.println("Enter Cargo Volume of the Vehicle " + " : ");
		int cargoVolume = sc.nextInt();

		vehicles[bookedSlots] = new Van(vehicleID, brand, datetime, cargoVolume, "Van");
		vanCount++;
		bookedSlots += 2;
	}

	public static void addMotorBike() {

		System.out.println("Enter the Vehicle " + " ID Number : ");
		String vehicleID = sc.next();

		System.out.println("Enter the Vehicle " + " Brand : ");
		String brand = sc.next();

		System.out.println("Enter the Date and the time : ");
		System.out.println("Day : ");
		int day = sc.nextInt();
		System.out.println("Month : ");
		int month = sc.nextInt();
		System.out.println("Year : ");
		int year = sc.nextInt();
		System.out.println("Hours : ");
		int hours = sc.nextInt();
		System.out.println("Minutes : ");
		int minutes = sc.nextInt();

		DateTime datetime = new DateTime(day, month, year, hours, minutes);

		System.out.println("Enter Engine Capacity of the Vehicle " + " : ");
		String engineCapacity = sc.next();

		vehicles[bookedSlots] = new MotorBike(vehicleID, brand, datetime, engineCapacity, "MotorBike");
		motorBikeCount++;
		bookedSlots++;

	}

	public static void deleteVehicle() {

		totalVehicles = carCount + vanCount + motorBikeCount;

		String type;

		if (totalVehicles <= 0) {
			System.out.println("Car Park is Empty");
		} else {

			System.out.println("Enter the Plate ID you want removed : ");
			String removedID = sc.next();

			for (int x = 0; x < totalVehicles; x++) {
				if (vehicles[x].getIDPlate().equals(removedID)) {
					if (vehicles[x].getType().equals("Car")) {
						carCount--;
					} else if (vehicles[x].getType().equals("Van")) {
						vanCount--;
					} else if (vehicles[x].getType().equals("MotorBike")) {
						motorBikeCount--;
					}
					type = vehicles[x].getType();
					vehicles[x] = null;

					for (int y = 0; y < totalVehicles; y++) {
						vehicles[y] = vehicles[y + 1];
					}

					vehicles[totalVehicles - 1] = null;
					totalVehicles--;

					System.out.println(type + " has left the Car Park");

				}

				else {
					System.out.println("No Record Of Vehicle " + removedID);
				}
			}
		}
	}

	public static void currentlyParkedVehicles() {

		totalVehicles = carCount + vanCount + motorBikeCount;

		if (totalVehicles <= 0) {
			System.out.println("Car Park is Empty");
		} else {

			for (int i = 0; i < totalVehicles; i++) {
				System.out.println("Vehicle Plate ID :" + vehicles[i].getIDPlate());
				System.out.println("Vehicle Brand : " + vehicles[i].getBrandOfTheVehicle());
				System.out.println("Vehicle Parked Date and Time : " + vehicles[i].getEntryTimeDate().getDate());
			}
		}

	}

	public static void statictics() {

		totalVehicles = carCount + vanCount + motorBikeCount;

		if (totalVehicles <= 0) {
			System.out.println("Car Park is Empty");
		} else {

			double carPresentage = (((double) carCount / totalVehicles) * 100);
			System.out.println("Presentage of the Cars out of Currently Parked Vehicles : " + carPresentage + " %");

			double vanPresentage = (((double) vanCount / totalVehicles) * 100);
			System.out.println("Presentage of the Vans out of Currently Parked Vehicles : " + vanPresentage + " %");

			double motorBikePresentage = (((double) motorBikeCount / totalVehicles) * 100);
			System.out.println(
					"Presentage of the Motor Bikes out of Currently Parked Vehicles : " + motorBikePresentage + " %");
		}
	}

	public static void specificVehicles() {

		totalVehicles = carCount + vanCount + motorBikeCount;

		if (totalVehicles <= 0) {
			System.out.println("Car Park is Empty");
		} else {

			System.out.println("Enter Current date and Time : ");
			System.out.println("Day : ");
			int day = sc.nextInt();
			System.out.println("Month : ");
			int month = sc.nextInt();
			System.out.println("Year : ");
			int year = sc.nextInt();

			for (int i = 0; i < totalVehicles; i++) {
				if (day == vehicles[i].getEntryTimeDate().getDay() && month == vehicles[i].getEntryTimeDate().getMonth()
						&& year == vehicles[i].getEntryTimeDate().getYear()) {
					System.out.println("Vehicle ID " + vehicles[i].getIDPlate() + " Date & Time : "
							+ vehicles[i].getEntryTimeDate().getDate());
				} else {
					System.out.println("There were no Vehicles Parked on this Day");
				}
			}
		}
	}

	public static void parkingCharge() {

		totalVehicles = carCount + vanCount + motorBikeCount;

		if (totalVehicles <= 0) {
			System.out.println("Car Park is Empty");
		} else {
			System.out.println("Enter Current date and Time : \n");

			System.out.println("Day : ");
			int day = sc.nextInt();
			System.out.println("Month : ");
			int month = sc.nextInt();
			System.out.println("Year : ");
			int year = sc.nextInt();
			System.out.println("Hours : ");
			int hours = sc.nextInt();
			System.out.println("Minutes : ");
			int minutes = sc.nextInt();

			int currentTime = (year * 365 * 24 * 60) + (month * 30 * 24 * 60) + (day * 24 * 60) + (hours * 60)
					+ minutes;

			for (int y = 0; y < totalVehicles; y++) {

				int totalYears = vehicles[y].getEntryTimeDate().getYear();
				int totalMonths = vehicles[y].getEntryTimeDate().getMonth();
				int totalDays = vehicles[y].getEntryTimeDate().getDay();
				int totalHours = vehicles[y].getEntryTimeDate().getHours();
				int totalMinutes = vehicles[y].getEntryTimeDate().getMinutes();

				long totalTime = (totalYears * 365 * 24 * 60) + (totalMonths * 30 * 24 * 60) + (totalDays * 24 * 60)
						+ (totalHours * 60) + totalMinutes;

				long parkedTimeDays = ((currentTime - totalTime) / 60) / 24;
				long parkedTimeHours = ((currentTime - totalTime) / 60) % 24;

				long totalPrice = (parkedTimeDays * 30) + parkedTimeHours;
				System.out.println("This Vehicle  " + vehicles[y].getIDPlate() + " has a Fee of : " + totalPrice);

			}
		}
	}
	
	
}
