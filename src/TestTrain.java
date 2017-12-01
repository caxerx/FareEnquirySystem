
public class TestTrain {
	public static void main(String[] args) {

		//Stations information
		Station [] stations = new Station[7];
		stations[0] = new Station("HongKong", 0);
		stations[1] = new Station("ShenZhen", 50);
		stations[2] = new Station("GuangZhou", 200);
		stations[3] = new Station("ZhengZhou", 700);
		stations[4] = new Station("WuChang", 1000);
		stations[5] = new Station("BeiJing", 2100);
		stations[6] = new Station("InnerMongolia", 2400);

		//Line information
		Line line = new Line("HongKong-WuChang-InnerMongolia", stations, 0.4, 0.01, 50);
		Station s[] = line.getStops();
		System.out.println("All stations:");
		for(int i=0; i<stations.length; i++)
			System.out.print(s[i].getName() + "   ");
		System.out.println("\n");

		//Train information
		Train trains[] = new Train[8];
		trains[0] = new CargoTrain("C001", "08:00", line, line.getStops()[1], line.getStops()[3], 100);
		trains[1] = new CargoTrain("C002", "12:00", line, line.getStops()[5], line.getStops()[2], 200);
		trains[2] = new CargoTrain("C003", "16:00", line, line.getStops()[0], line.getStops()[6], 50);
		trains[3] = new CargoTrain("C004", "20:00", line, line.getStops()[6], line.getStops()[0], 80);
		trains[4] = new PassengerTrain("P001", "10:30", line, line.getStops()[0], line.getStops()[6], 10);
		trains[5] = new PassengerTrain("P002", "17:30", line, line.getStops()[6], line.getStops()[0], 8);
		trains[6] = new ExpressPassengerTrain("X001", "09:30", line, line.getStops()[0], line.getStops()[5], 4);
		trains[7] = new ExpressPassengerTrain("X001", "16:30", line, line.getStops()[5], line.getStops()[1], 6);

		System.out.println("Train information:");
		for(int i=0; i<trains.length; i++)
			System.out.println(trains[i]);

		System.out.println("\nCheck valid route:");
		System.out.print(s[1].getName() + " to " + s[2].getName() + " is the valid route for train " + trains[0].getCode() + "? ");
		if (trains[0].isValidRoute(s[1], s[2]))
			System.out.println("Yes");
		else
			System.out.println("No");

		System.out.print(s[2].getName() + " to " + s[1].getName() + " is the valid route for train " + trains[0].getCode() + "? ");
		if (trains[0].isValidRoute(s[2], s[1]))
			System.out.println("Yes");
		else
			System.out.println("No");

		System.out.print(s[0].getName() + " to " + s[1].getName() + " is the valid route for train " + trains[0].getCode() + "? ");
		if (trains[0].isValidRoute(s[0], s[1]))
			System.out.println("Yes");
		else
			System.out.println("No");

		System.out.println("\nCalculate Distance Fare");
		System.out.print("Distance Fare of " + trains[0].getCode() + " from " + s[1].getName() + " to " + s[3].getName() + " is $" + trains[0].calculateDistanceFare(s[1], s[3]));
		if(trains[0] instanceof CargoTrain)  // Example for checking the object type
			System.out.println (" Per 1KG Cargo");
		else
			System.out.println (" Per Passenger");

		System.out.println("Distance Fare of " + trains[1].getCode() + " from " + s[6].getName() + " to " + s[5].getName() + " is $" + trains[1].calculateDistanceFare(s[6], s[5]) + " Per Passenger");
		System.out.println("Distance Fare of " + trains[2].getCode() + " from " + s[1].getName() + " to " + s[5].getName() + " is $" + trains[2].calculateDistanceFare(s[1], s[5]) + " Per Passenger");

		System.out.println("\nCalculate Total Fare (including all surcharge):");
		System.out.println("Total Fare of " + trains[0].getCode() + " from " + s[1].getName() + " to " + s[3].getName() + " is $ " + trains[0].calculateFare(s[1], s[3], 1) + " Per 1KG Cargo");
		System.out.println("Total Fare of " + trains[1].getCode() + " from " + s[6].getName() + " to " + s[5].getName() + " is $" + trains[1].calculateFare(s[6], s[5], 1) + " Per Passenger");
		System.out.println("Total Fare of " + trains[2].getCode() + " from " + s[1].getName() + " to " + s[5].getName() + " is $" + trains[2].calculateFare(s[1], s[5], 1) + " Per Passenger");
	}

}
