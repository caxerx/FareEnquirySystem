public class CargoTrain extends Train {
    private final int maxCargoWeight;

    public CargoTrain(String code, String startTime, Line line, Station start, Station end, int maxCargoWeight) {
        super(code, startTime, line, start, end);
        this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    double calculateDistanceFare(Station from, Station to) {
        return getLine().getCargoFarePerKm() * getLine().calculateDistance(from, to);
    }

    @Override
    public String toString() {
        //C001 08:00 ShenZhen -> ZhengZhou Max. Cargo Weight per Order : 100 KG
        return super.toString() + " Max. Cargo Weight per Order : " + maxCargoWeight;
    }
}
