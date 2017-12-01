import java.util.Scanner;
import java.io.*;

public class FareEnquirySystem {
    public static void main(String args[]) {

        //Station information
        Station[] stations = new Station[7];
        stations[0] = new Station("HongKong", 0);
        stations[1] = new Station("ShenZhen", 50);
        stations[2] = new Station("GuangZhou", 200);
        stations[3] = new Station("ZhengZhou", 700);
        stations[4] = new Station("WuChang", 1000);
        stations[5] = new Station("BeiJing", 2100);
        stations[6] = new Station("InnerMongolia", 2400);

        double passengerFarePerKm = 0;
        double cargoFarePerKm = 0;
        int expressTrainSurcharge = 0;

        String fileName = "fare.txt";

        // read the fare rates from the text file "fare.txt" and handle possible exceptions to be completed by you!

        //Line information
        Line line =
                new Line("HongKong-WuChang-InnerMongolia", stations, passengerFarePerKm, cargoFarePerKm, expressTrainSurcharge);

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

        System.out.println("Fare Enquiry System");
        System.out.println("===================");
        System.out.println(line);

        // List of all trains - to be completed by you!
        for (Train train : trains) {
            System.out.println(train);
        }
        // List all stations - to be completed by you!
        for (Station station : line.getStops()) {
            System.out.println(station);
        }

        /* 	Ask for departure station and arrival station
            Ask for the number of passenger or weight of the cargo
			Show the total fare
			- to be completed by you!
		*/
        loadFile();
    }

    public static double[] loadFile() {
        double farePerPassenger;
        int surchargeForExpressTrain;
        double kgFarePerCargo;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(new File("fare.txt")))) {
            String line1 = fileReader.readLine();
            String line2 = fileReader.readLine();
            if (fileReader.readLine() != null) {
                throw new InvalidFileException();
            }

            String[] line1Item;
            String[] line2Item;
            if (line1 != null && line2 != null && (line1Item = line1.split(":")).length == 3 && line1Item[0].equals("P") && (line2Item = line2.split(":")).length == 2 && line2Item[0].equals("C")) {
                farePerPassenger = Double.parseDouble(line1Item[1]);
                surchargeForExpressTrain = Integer.parseInt(line1Item[2]);
                kgFarePerCargo = Double.parseDouble(line2Item[1]);
                return new double[]{farePerPassenger, surchargeForExpressTrain, kgFarePerCargo};
            } else {
                throw new InvalidFileException();
            }
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("Can't find the file: fare.txt");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid station number");
        }

        return null;
    }
}
