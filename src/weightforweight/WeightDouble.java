package weightforweight;

import java.util.*;

/**
 * Created by Iryna Guzenko on 01.12.2015.
 */
public class WeightDouble {
    public static String orderWeight(String string) {
        if (string.isEmpty()) return string;
        List<String> finalList = new ArrayList<>();
        SortedMap<Integer, List<String>> pairs = getPairs(string);
        pairs.values().stream().forEachOrdered(el ->
                el.stream().sorted(Comparator.<String>naturalOrder()).forEachOrdered(finalList::add));
        return listToString(finalList);
    }

    private static SortedMap<Integer, List<String>> getPairs(String string) {
        SortedMap<Integer, List<String>> pairs = new TreeMap<>();
        Arrays.stream(string.split(" ")).forEach(el -> {
            int sum = Arrays.stream(el.split("")).mapToInt(Integer::valueOf).sum();
            if (pairs.containsKey(sum)) {
                pairs.get(sum).add(el);
            } else {
                List<String> numbers = new ArrayList<>();
                numbers.add(el);
                pairs.put(sum, numbers);
            }
        });
        return pairs;
    }

    private static String listToString(List<String> list) {
        StringBuilder str = new StringBuilder();
        list.forEach(el -> str.append(el).append(" "));
        return str.toString().trim();
    }
}
