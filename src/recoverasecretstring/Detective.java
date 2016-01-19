package recoverasecretstring;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iryna Guzenko on 19.01.2016.
 */
public class Detective {
    private static List<Character> result = new ArrayList<>();

    public static String recoverSecret(char[][] triplets) {
        for (int i = 0; i < 3; i++) {
            for (char[] triplet : triplets) {
                if (result.contains(triplet[i])) continue;
                result.add(triplet[i]);
            }
        }
        doCycle(triplets);
        StringBuilder builder = new StringBuilder("");
        result.forEach(builder::append);
        return builder.toString();
    }

    private static void doCycle(char[][] triplets) {
        for (char[] triplet : triplets) {
            if (placeTriplet(triplet)) continue;
            doCycle(triplets);
            break;
        }
    }

    private static boolean placeTriplet(char[] triplet) {
        int firstIndex = result.indexOf(triplet[0]);
        int secondIndex = result.indexOf(triplet[1]);
        int thirdIndex = result.indexOf(triplet[2]);
        if (firstIndex > secondIndex) {
            result.set(firstIndex, triplet[1]);
            result.set(secondIndex, triplet[0]);
            placeTriplet(triplet);
            return false;
        }
        if (secondIndex > thirdIndex) {
            result.set(thirdIndex, result.get(secondIndex));
            result.set(secondIndex, triplet[2]);
            placeTriplet(triplet);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] triplets = {
                {'t', 'u', 'p'},
                {'w', 'h', 'i'},
                {'t', 's', 'u'},
                {'a', 't', 's'},
                {'h', 'a', 'p'},
                {'t', 'i', 's'},
                {'w', 'h', 's'}
        };
        System.out.println(recoverSecret(triplets));
    }
}
