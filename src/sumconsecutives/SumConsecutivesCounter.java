package sumconsecutives;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Iryna Guzenko on 16.01.2016.
 */
public class SumConsecutivesCounter {
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        sumConsecutives(Arrays.asList(1, 4, 4, 4, 0, 4, 3, 3, 1)).stream().forEachOrdered(el -> System.out.print(el + " "));
    }

    public static List<Integer> sumConsecutives(List<Integer> s) {
        list = s;
        return addNumber(new ArrayList<>(), 0);
    }

    private static List<Integer> addNumber(List<Integer> result, int startIndex) {
        if (startIndex > list.size() - 1) return result;
        Integer number = list.get(startIndex);
        int counter = 1;
        for (int j = startIndex + 1; j < list.size(); j++) {
            if (!list.get(j).equals(number)) break;
            counter++;
        }
        result.add(number * counter);
        return addNumber(result, startIndex + counter);
    }
}
