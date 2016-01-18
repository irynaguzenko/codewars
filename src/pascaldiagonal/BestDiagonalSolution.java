package pascaldiagonal;

import java.math.BigInteger;

/**
 * Created by Iryna Guzenko on 24.11.2015.
 */
public class BestDiagonalSolution {

    public static BigInteger diagonal(int n, int p) {
        BigInteger sum = BigInteger.ONE;
        BigInteger initialElement = BigInteger.ONE;
        for (int i = p + 1; i <= n; i++) {
            initialElement = initialElement.multiply(BigInteger.valueOf(i)).divide(BigInteger.valueOf(i - p));
            sum = sum.add(initialElement);
        }
        return sum;
    }
}
