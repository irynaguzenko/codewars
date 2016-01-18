package ismyfriendcheating;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iryna Guzenko on 02.12.2015.
 */
public class CheatingChecker {

    public static void main(String[] args) {
        List<long[]> r = removNb(26);
        System.out.println(r.get(0)[0] + " " + r.get(0)[1]);
        System.out.println(r.get(1)[0] + " " + r.get(1)[1]);
    }

    public static List<long[]> removNb(long n) {
        long sum = (1 + n) * n / 2;
        List<long[]> finalList = new ArrayList<>();
        for (long a = n / 2; a < n; a++) {
            for (long b = n; b >= n / 2; b--) {
                if (a * b < sum - 2 * n) break;
                if (a + b + a * b != sum) continue;
                finalList.add(new long[]{a, b});
                finalList.add(new long[]{b, a});
            }
        }
        return finalList;
    }
}
