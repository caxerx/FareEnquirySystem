import java.io.*;
import java.util.Scanner;

public class FareEnquirySystem {
    public static void main(String[] args) {
        double farePerPanssenger;
        int surchargeForExpressTrain;
        double kgFarePerCargo;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(new File("fare.txt")));
            try (fileReader) {
                String line1 = fileReader.readLine();
                String line2 = fileReader.readLine();
                if (fileReader.readLine() != null) {
                    throw new InvalidFileException();
                }
                String[] line1Item;
                String[] line2Item;
                if (line1 != null && line2 != null && (line1Item = line1.split(":")).length == 3 && line1Item[0].equals("P") && (line2Item = line2.split(":")).length == 2 && line2Item[0].equals("C")) {
                    try {
                        farePerPanssenger = Double.parseDouble(line1Item[1]);
                        surchargeForExpressTrain = Integer.parseInt(line1Item[2]);
                        kgFarePerCargo = Double.parseDouble(line2Item[1]);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new InvalidFileException();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFileException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Station[] stations = {new Station("Hong Kong", 0),
                new Station("ShenZhen", 50),
                new Station("GuanZhou", 200),
                new Station("ZhenZhou", 700),
                new Station("WuChang", 1000),
                new Station("BeiJing", 2100),
                new Station("Inner Mongolia", 2400)};
        Train[] trains = new Train[8];
        Line line = new Line("HongKong-WuChang-InnerMongolia", stations, trains, 0, 0, 0);
        trains[0] = new CargoTrain("C001", "08:00", line, stations[1], stations[3], 100);
        trains[1] = new CargoTrain("C002", "12:00", line, stations[5], stations[2], 200);
        trains[2] = new CargoTrain("C003", "16:00", line, stations[0], stations[6], 50);
        trains[3] = new CargoTrain("C004", "20:00", line, stations[6], stations[0], 80);
        trains[4] = new PassengerTrain("P001", "10:30", line, stations[0], stations[6], 10);
        trains[5] = new PassengerTrain("P002", "17:30", line, stations[6], stations[0], 8);
        trains[6] = new ExpressPassengerTrain("X001", "09:30", line, stations[0], stations[5], 4);
        trains[7] = new ExpressPassengerTrain("X002", "16:30", line, stations[5], stations[0], 6);

        System.out.println("Fare Enquiry System");
        System.out.println("===================");
        System.out.println("Line: " + line.getName());
        System.out.println(line);
        System.out.println("Fares Summary:");
    }
}
