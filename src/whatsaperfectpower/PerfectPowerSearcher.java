package whatsaperfectpower;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Iryna Guzenko on 11.12.2015.
 */
public class PerfectPowerSearcher {

    public static void main(String[] args) {
        Arrays.stream(isPerfectPower(519885601)).forEachOrdered(System.out::println);
    }

    public static int[] isPerfectPower(int n) {
        if (n < 2) return null;
        for (int number : getPrimes(n)) {
            double base = Math.pow(n, 1. / number);
            BigDecimal converted = new BigDecimal(base, new MathContext(10)).stripTrailingZeros();
            if (converted.scale() == 0 || converted.scale() == -1) {
                return new int[]{converted.intValue(), number};
            }
        }
        return null;
    }

    private static List<Integer> getPrimes(int n) {
        boolean[] prePrimes = new boolean[n];
        List<Integer> primes = new ArrayList<>();
        Arrays.fill(prePrimes, true);
        for (int i = 2; Math.pow(i, 2) <= n; i++) {
            if (prePrimes[i - 2]) {
                for (int j = (int) Math.pow(i, 2); j <= n; j += i) {
                    prePrimes[j - 2] = false;
                }
            }
        }
        for (int number = 2; number < n + 2; number++) {
            if (prePrimes[number - 2]) primes.add(number);
        }
        return primes;
    }
}
