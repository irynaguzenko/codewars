package financingplanonplanet;

import java.math.BigInteger;

/**
 * Created by Iryna Guzenko on 24.11.2015.
 */
public class FinancingPlan {
    private static int N;

    public static BigInteger finance(int n) {
        N = n;
        BigInteger sum = countSum(BigInteger.ZERO, 1);
        return sum;
    }

    private static BigInteger countSum(BigInteger previousSum, int index) {
        if (index > N) return BigInteger.ZERO;
        BigInteger currentSum = previousSum.add(BigInteger.valueOf(4 * index - index));
        return currentSum.add(countSum(currentSum, index + 1));
    }
}
