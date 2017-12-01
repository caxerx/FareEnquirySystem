public class TestLine {

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

		System.out.println(line);

		Station s[] = line.getStops();

		System.out.println("First Station : " + s[0].getName());
		System.out.println("Second Station : " + s[1].getName());
		System.out.println("...");
		System.out.println("Last Station : " + s[s.length-1].getName());
		System.out.println("Second Last Station : " + s[s.length-2].getName());
		System.out.println("...");
		System.out.println("Distance from " + s[1].getName() + " to "
				+ s[3].getName() + " is " + line.calculateDistance(s[1], s[3]) + "Km");
		System.out.println("Distance from " + s[3].getName() + " to " + s[1].getName() + " is " + line.calculateDistance(s[3], s[1]) + "Km");
	}
}
