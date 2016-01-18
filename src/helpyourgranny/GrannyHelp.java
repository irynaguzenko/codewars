package helpyourgranny;

import java.util.Map;

/**
 * Created by Iryna Guzenko on 25.11.2015.
 */
public class GrannyHelp {
    private static String[][] cities;
    private static String[] friends;
    private static Map<String, Double> distances;

    public static int tour(String[] arrFriends, String[][] ftwns, Map<String, Double> h) {
        cities = ftwns;
        friends = arrFriends;
        distances = h;

        double distance = 0.;
        if (getTown(friends[0]) == null) {
            distance += distances.get(getTown(friends[1])) + distances.get(getTown(friends[friends.length - 1]));
            return (int) (distance += countPath(1, friends.length - 1));
        }
        if (getTown(friends[friends.length - 1]) == null) {
            distance += distances.get(getTown(friends[0])) + distances.get(getTown(friends[friends.length - 2]));
            return (int) (distance += countPath(0, friends.length - 2));
        }
        return (int) (distance + distances.get(getTown(friends[0])) + distances.get(getTown(friends[friends.length - 1]))
                + countPath(0, friends.length - 1));
    }

    private static double countPath(int FROM, int TO) {
        double distance = 0;
        for (int i = FROM; i < TO; i++) {
            String townA = getTown(friends[i]);
            String townB = getTown(friends[i + 1]);
            if (townB == null) townB = getTown(friends[i + 2]);
            distance += getDistance(townA, townB);
        }
        return distance;
    }

    private static double getDistance(String townA, String townB) {
        return Math.sqrt(Math.pow(distances.get(townB), 2) - Math.pow(distances.get(townA), 2));
    }

    public static String getTown(String friend) {
        for (String[] pair : cities) {
            if (pair[0].equals(friend)) return pair[1];
        }
        return null;
    }
}
