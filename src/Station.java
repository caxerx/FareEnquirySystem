public class Station {
    private String name;
    private int distance;

    public Station(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return name + ",(" + distance + ")";
    }
}
