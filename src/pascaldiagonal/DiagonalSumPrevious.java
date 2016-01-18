package pascaldiagonal;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by Iryna Guzenko on 23.11.2015.
 */
public class DiagonalSumPrevious {
    public static BigInteger diagonal(int n, int p) {
        BigInteger[][] triangle = createPascalTriangle(n);
        BigInteger sum = BigInteger.ZERO;
        for (int i = n; i >= p; i--) {
            sum = triangle[i][p].add(sum);
        }
        System.out.println(sum);
        return sum;
    }

    public static BigInteger[][] createPascalTriangle(int n) {
        BigInteger[][] triangle = new BigInteger[n+1][];
        for (int i = 0; i <= n; i++) {
            triangle[i] = new BigInteger[i + 1];
        }
        fillCoefficients(triangle);
        return triangle;
    }

    private static void fillCoefficients(BigInteger[][] triangle) {
        Arrays.stream(triangle).forEach(elem -> {
            elem[0] = BigInteger.ONE;
            elem[elem.length - 1] = BigInteger.ONE;
        });

        if (triangle.length <= 1) return;
        for (int n = 2; n < triangle.length; n++) {
            for (int k = 1; k <= n / 2; k++) {
                triangle[n][k] = triangle[n - 1][k - 1].add(triangle[n - 1][k]);
                triangle[n][triangle[n].length - 1 - k] = triangle[n][k];
            }
        }
    }

//    private static void sysout(List<[]> triangle) {
//        for (int i = 0; i < triangle.size(); i++) {
//            for (int j = 0; j < triangle.get(i).length; j++) {
//                System.out.print(triangle.get(1200)[5] + " ");
//            }
//            System.out.println();
//        }
//    }
}
