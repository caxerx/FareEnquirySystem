public class PassengerTrain extends Train {
    private final int maxTicketNumber;

    public PassengerTrain(String code, String startTime, Line line, Station start, Station end, int maxTicketNumber) {
        super(code, startTime, line, start, end);
        this.maxTicketNumber = maxTicketNumber;
    }

    @Override
    double calculateDistanceFare(Station from, Station to) {
        return getLine().getPassengerFarePerKm() * getLine().calcurateDistance(from, to);
    }

    public int getMaxTicketNumber() {
        return maxTicketNumber;
    }
}
