package parityoutlier;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by Iryna Guzenko on 23.11.2015.
 */
public class OutlierFinder {

    public static void main(String[] args) {
        System.out.println(find(new int[]{-3, 8, 6,  10}));
    }

    static int find(int[] integers) {
        try {
            if (checkOdd(integers))
                return Arrays.stream(integers).filter(integer -> ((integer % 2) == 0)).findFirst().getAsInt();
            return Arrays.stream(integers).filter(integer -> ((integer % 2) == 1|(integer % 2) == -1)).findFirst().getAsInt();
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    private static boolean checkOdd(int[] integers) {
        return Arrays.stream(integers).filter(integer -> integer % 2 == 1).count() > 1;
    }
}
