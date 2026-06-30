import java.util.*;

class UndergroundSystem {

    private Map<Integer, CheckIn> checkIns;
    private Map<String, Route> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkIns.remove(id);

        String key = checkIn.station + "->" + stationName;
        Route route = routes.getOrDefault(key, new Route());

        route.totalTime += (t - checkIn.time);
        route.count++;

        routes.put(key, route);
    }

    public double getAverageTime(String startStation, String endStation) {
        Route route = routes.get(startStation + "->" + endStation);
        return (double) route.totalTime / route.count;
    }

    static class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    static class Route {
        long totalTime;
        int count;
    }
}