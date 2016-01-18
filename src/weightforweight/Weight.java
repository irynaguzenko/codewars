package weightforweight;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Iryna Guzenko on 01.12.2015.
 */
public class Weight {

    public static void main(String[] args) {
        System.out.println(WeightDouble.orderWeight("56 65 74 74 100 99 68 86 180 90"));
    }

    public static String orderWeight(String string) {
        List<String> finalList = new ArrayList<>();
        Map<String, Integer> pair = new HashMap<>();
        Arrays.stream(string.split(" ")).forEach(el -> pair.put(el, getSum(el)));
        pair.values().stream().sorted().forEachOrdered(el -> {
                    List<String> relevantNumbers = pair.entrySet().stream()
                            .filter(entry -> Objects.equals(entry.getValue(), el))
                            .map(Map.Entry::getKey).collect(Collectors.toList());
                    if (relevantNumbers.size() == 1) {
                        finalList.add(relevantNumbers.get(0));
                    } else {
                        relevantNumbers.sort(Comparator.<String>naturalOrder());
                        if (!finalList.containsAll(relevantNumbers)) {
                            relevantNumbers.stream().forEachOrdered(finalList::add);
                        }
                    }
                }
        );
        return listToString(finalList);
    }

    private static int getSum(String s) {
        return Arrays.stream(s.split("")).mapToInt(Integer::valueOf).sum();
    }

    private static String listToString(List<String> list) {
        StringBuilder str = new StringBuilder();
        list.forEach(el -> str.append(el).append(" "));
        return str.toString().trim();
    }
}
