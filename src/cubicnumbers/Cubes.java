package cubicnumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Iryna Guzenko on 19.11.2015.
 */
public class Cubes {
    private List<String> relevantNumbers = new ArrayList<>();

    public String isSumOfCubes(String s) {
        String[] numbers = getNumbers(s);
        if(numbers[0].equals("")) numbers[0] = "14";

        int totalSum = 0;
        for (String number : numbers) {
            totalSum += findTotalSum(number);
        }
        if (!relevantNumbers.isEmpty()) {
            StringBuffer str = new StringBuffer("");
            relevantNumbers.forEach((str1) -> str.append(str1 + " "));
            return str + String.valueOf(totalSum) + " Lucky";
        }
        return "Unlucky";
    }

    private int findTotalSum(String number) {
        int sum = 0;
        if (number.length() > 3) {
            sum += findTotalSum(number.substring(3));
            sum += findConcreteSum(number.substring(0, 3));
        } else {
            sum += findConcreteSum(number);
        }
        return sum;
    }

    private int findConcreteSum(String number) {
        if (checkIfCubic(number)) {
            relevantNumbers.add(number);
            return Integer.valueOf(number);
        }
        return 0;
    }

    private String[] getNumbers(String string) {
        return string.split("[\\D]+");
    }

    private boolean checkIfCubic(String number) {
        double sum = Arrays.stream(number.split("")).mapToDouble(el -> Math.pow(Integer.parseInt(el), 3)).sum();
        return Integer.valueOf(number) == sum;
    }
}
