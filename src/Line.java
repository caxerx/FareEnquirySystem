public class Line {
    private String name;
    private Station[] stops;
    private final double passengerFarePerKm;
    private final double cargoFarePerKm;
    private final int expressTrainSurcharge;

    public Line(String name, Station[] stops, double passengerFarePerKm, double cargoFarePerKm, int expressTrainSurcharge) {
        this.name = name;
        this.stops = stops;
        this.passengerFarePerKm = passengerFarePerKm;
        this.cargoFarePerKm = cargoFarePerKm;
        this.expressTrainSurcharge = expressTrainSurcharge;
    }

    public String getName() {
        return name;
    }

    public int calculateDistance(Station departure, Station arrival) {
        return departure.getDistance() > arrival.getDistance() ? departure.getDistance() - arrival.getDistance() : arrival.getDistance() - departure.getDistance();
    }

    @Override
    public String toString() {
        String lineStr = stops[0].toString();
        for (int i = 1; i < stops.length; i++) {
            lineStr += " > " + stops[i];
        }
        return lineStr;
    }

    public Station[] getStops() {
        return stops;
    }

    public double getPassengerFarePerKm() {
        return passengerFarePerKm;
    }

    public double getCargoFarePerKm() {
        return cargoFarePerKm;
    }

    public int getExpressTrainSurcharge() {
        return expressTrainSurcharge;
    }
}
