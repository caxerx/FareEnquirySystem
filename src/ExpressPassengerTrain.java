public class ExpressPassengerTrain extends PassengerTrain {

    public ExpressPassengerTrain(String code, String startTime, Line line, Station start, Station end, int maxTicketNumber) {
        super(code, startTime, line, start, end, maxTicketNumber);
    }

    @Override
    public double calculateFare(Station from, Station to, int quantity) {
        return super.calculateDistanceFare(from, to) + (getLine().getExpressTrainSurcharge() * quantity);
    }

    @Override
    public String toString() {
        return super.toString() + " Express Train Surcharge Required!";
    }
}
