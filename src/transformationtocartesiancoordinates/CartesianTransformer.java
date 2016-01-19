package transformationtocartesiancoordinates;

import java.awt.geom.Point2D;

/**
 * Created by Iryna Guzenko on 19.01.2016.
 */
public class CartesianTransformer {
    public static Point2D coordinates(Double degrees, Double radius) {
        double x = radius * Math.cos(Math.toRadians(degrees));
        double y = radius * Math.sin(Math.toRadians(degrees));
        return new Point2D.Double(round(x), round(y));
    }

    private static double round(double number) {
        return Math.round(number * Math.pow(10, 10)) / Math.pow(10, 10);
    }

    public static void main(String[] args) {
        System.out.println(coordinates(45., 1.));
    }
}
