package helpyourgranny;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Iryna Guzenko on 25.11.2015.
 */
public class MainGranny {
    public static void main(String[] args) {
//        String[] friends1 = new String[]{"A1", "A2", "A3", "A4", "A5"};
//        String[][] fTowns1 = {new String[]{"A1", "X1"}, new String[]{"A2", "X2"}, new String[]{"A3", "X3"},
//                new String[]{"A4", "X4"}};
//        Map<String, Double> distTable1 = new HashMap<>();
//        distTable1.put("X1", 100.0);
//        distTable1.put("X2", 200.0);
//        distTable1.put("X3", 250.0);
//        distTable1.put("X4", 300.0);
//
//        System.out.println(GrannyHelp.tour(friends1, fTowns1, distTable1));
        String[] friends3 = {"B1", "B2"};
        String[][] fTowns3 = {{"B1", "Y1"}, {"B2", "Y2"}, {"B3", "Y3"}, {"B4", "Y4"}, {"B5", "Y5"}};
        Map<String, Double> distTable3 = new HashMap<>();
        distTable3.put("Y1", 50.0);
        distTable3.put("Y2", 70.0);
        distTable3.put("Y3", 90.0);
        distTable3.put("Y4", 110.0);
        distTable3.put("Y5", 150.0);
        System.out.println(GrannyHelp.tour(friends3, fTowns3, distTable3));
    }
}
