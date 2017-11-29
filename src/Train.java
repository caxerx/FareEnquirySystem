abstract class Train {

    private final String code;
    private final String startTime;
    private final Line line;
    private final Station start;
    private final Station end;

    public Train(String code, String startTime, Line line, Station start, Station end) {
        this.code = code;
        this.startTime = startTime;
        this.line = line;
        this.start = start;
        this.end = end;
    }

    abstract double calculateDistanceFare(Station from, Station to);

    public double calculateFare(Station from, Station to, int quantity) {
        return calculateDistanceFare(from, to) * quantity;
    }

    public boolean isValidRoute(Station from, Station to) {
        if (start.getDistance() > end.getDistance() && from.getDistance() > to.getDistance() && from.getDistance() <= start.getDistance() && to.getDistance() >= end.getDistance()) {
            return true;
        }
        if (start.getDistance() < end.getDistance() && from.getDistance() < to.getDistance() && from.getDistance() >= start.getDistance() && to.getDistance() <= end.getDistance()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getCode() + " " + getStartTime() + " " + getStart().getName() + " -> " + getEnd().getName();
    }

    public String getCode() {
        return code;
    }

    public String getStartTime() {
        return startTime;
    }

    public Line getLine() {
        return line;
    }

    public Station getStart() {
        return start;
    }

    public Station getEnd() {
        return end;
    }
}
