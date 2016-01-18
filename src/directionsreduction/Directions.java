package directionsreduction;

import java.util.Arrays;

/**
 * Created by Iryna Guzenko on 02.12.2015.
 */
public class Directions {
    public static String[] dirReduc(String[] arr) {
        StringBuilder route = new StringBuilder();
        Arrays.stream(arr).forEachOrdered(route::append);
        String newRoute = getIt(route);
        if (newRoute.isEmpty()) return new String[0];
        return newRoute.replaceAll("TH", "TH ").replaceAll("ST", "ST ").trim().split(" ");
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"};
        Arrays.stream(dirReduc(arr)).forEachOrdered(System.out::println);
        System.out.println(".");
    }

    private static String getIt(StringBuilder route) {
        StringBuilder newRoute = new StringBuilder();
        Arrays.stream(route.toString().split("(NORTHSOUTH|SOUTHNORTH|WESTEAST|EASTWEST)"))
                .forEachOrdered(newRoute::append);
        if (!route.toString().equals(newRoute.toString())) return getIt(newRoute);
        return route.toString();
    }
}
