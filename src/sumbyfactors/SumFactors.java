package sumbyfactors;

import java.util.*;

/**
 * Created by Iryna Guzenko on 04.12.2015.
 */
public class SumFactors {
    public static void main(String[] args) {
        System.out.println(sumOfDivided(new int[]{12, 3, 24, -35, 44}));
    }

    public static String sumOfDivided(int[] l) {
        SortedMap<Integer, Integer> pairs = new TreeMap<>();
        getFactors(Arrays.stream(l).map(Math::abs).max().getAsInt()).stream().forEachOrdered(factor -> {
            int sum = Arrays.stream(l).filter(el -> el % factor == 0).sum();
            if (sum != 0) pairs.put(factor, sum);
        });
        return mapToString(pairs);
    }

    private static List<Integer> getFactors(int n) {
        boolean[] numbers = new boolean[n - 2];
        List<Integer> factors = new ArrayList<>();
        Arrays.fill(numbers, true);
        for (int i = 2; Math.pow(i, 2) <= n; i++) {
            if (numbers[i - 2]) {
                for (int p = (int) Math.pow(i, 2); p <= numbers.length; p += i) {
                    numbers[p - 2] = false;
                }
            }
        }
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index]) factors.add(index + 2);
        }
        return factors;
    }

    private static String mapToString(Map<Integer, Integer> pairs) {
        StringBuilder string = new StringBuilder();
        pairs.forEach((factor, sum) -> string.append("(").append(factor).append(" ").append(sum).append(")"));
        return string.toString();
    }
}
