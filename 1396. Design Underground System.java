import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Helper class to store check-in details for each customer
    private static class CheckInInfo {
        String stationName;
        int time;

        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    // Helper class to store total travel time and total trip count for a route
    private static class RouteInfo {
        double totalTime;
        int count;

        RouteInfo(double totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    // id -> CheckInInfo
    private final Map<Integer, CheckInInfo> checkIns;
    // "startStation->endStation" -> RouteInfo
    private final Map<String, RouteInfo> routeStats;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routeStats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        // Retrieve and remove customer's check-in info
        CheckInInfo info = checkIns.remove(id);
        String routeKey = info.stationName + "->" + stationName;
        int travelTime = t - info.time;

        // Update the route total time and trip count
        RouteInfo route = routeStats.getOrDefault(routeKey, new RouteInfo(0, 0));
        route.totalTime += travelTime;
        route.count += 1;
        routeStats.put(routeKey, route);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteInfo route = routeStats.get(routeKey);
        return route.totalTime / route.count;
    }
}
