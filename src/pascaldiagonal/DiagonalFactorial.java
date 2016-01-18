package pascaldiagonal;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iryna Guzenko on 23.11.2015.
 */
public class DiagonalFactorial {

    public static BigInteger diagonal(int n, int p) {
        List<int[]> triangle = createPascalTriangle(n);
        int sum = 0;
        for (int i = n; i >= p; i--) {
            sum += triangle.get(i)[p];
        }
        System.out.println(BigInteger.valueOf(sum));
        return BigInteger.valueOf(sum);
    }

    public static List<int[]> createPascalTriangle(int n) {
        List<int[]> triangle = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            triangle.add(new int[i + 1]);
        }
        fillCoefficients(triangle);
        return triangle;
    }

    private static void fillCoefficients(List<int[]> triangle) {
        int n = triangle.size() - 1;
        triangle.forEach(el -> {
            el[0] = 1;
            el[el.length - 1] = 1;
        });
        if (n > 1) {
            for (int i = 2; i < triangle.size(); i++) {
                for (int j = 1; j < triangle.get(i).length - 1; j++) {
                    triangle.get(i)[j] = Integer.valueOf(String.valueOf(countCoef(i, j)));
                }
            }
        }
    }

    private static BigInteger countCoef(int n, int m) {
        return factorial(n).divide(factorial(m).multiply(factorial(n - m)));
    }

    private static BigInteger factorial(int number) {
        BigInteger factorial = BigInteger.valueOf(1);
        if (number > 1)
            factorial = factorial(number - 1).multiply(BigInteger.valueOf(number));
        return factorial;
    }
}
