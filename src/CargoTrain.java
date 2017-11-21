public class CargoTrain extends Train {
    private final int maxCargoWeight;

    public CargoTrain(String code, String startTime, Line line, Station start, Station end, int maxCargoWeight) {
        super(code, startTime, line, start, end);
        this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    double calculateDistanceFare(Station from, Station to) {
        return getLine().getCargoFarePerKm() * getLine().calcurateDistance(from, to);
    }
}
