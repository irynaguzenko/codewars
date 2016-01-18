package squaresfibonacchi;

import java.math.BigInteger;

/**
 * Created by Iryna Guzenko on 25.11.2015.
 */
public class SquarePerimeterCounter {
    private static BigInteger N;

    public static void main(String[] args) {
        System.out.println(perimeter(BigInteger.valueOf(10)));
    }

    public static BigInteger perimeter(BigInteger n) {
        N = n.add(BigInteger.ONE);
        BigInteger sum = BigInteger.ONE.add(countSum(BigInteger.valueOf(2), BigInteger.ZERO, BigInteger.ONE));
        return sum.multiply(BigInteger.valueOf(4));
    }

    private static BigInteger countSum(BigInteger index, BigInteger prePrevious, BigInteger previous) {
        if (index.compareTo(N) > 0) return BigInteger.ZERO;
        BigInteger currentElement = prePrevious.add(previous);
        return currentElement.add(countSum(index.add(BigInteger.ONE), previous, currentElement));
    }
}
