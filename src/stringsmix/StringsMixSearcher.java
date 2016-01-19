package stringsmix;

import java.util.Arrays;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Iryna Guzenko on 18.01.2016.
 */
public class StringsMixSearcher {

    public static void main(String[] args) {
        System.out.println(mix("Are the kids at home? aaaaa fffff", "Yes they are here! aaaaa fffff"));
    }

    public static String mix(String s1, String s2) {
        SortedSet<String> set = new TreeSet<>();
        Arrays.stream((s1 + s2).split("")).filter(el -> el.matches("[a-z]")).distinct().forEach(el -> {
            int frequency1 = Collections.frequency(Arrays.asList(s1.split("")), el);
            int frequency2 = Collections.frequency(Arrays.asList(s2.split("")), el);
            if (frequency1 > frequency2 && frequency1 > 1) {
                set.add(makeElement(frequency1, el, "1"));
            } else if (frequency2 > frequency1 && frequency2 > 1) {
                set.add(makeElement(frequency2, el, "2"));
            } else if (frequency1 > 1) set.add(makeElement(frequency1, el, "="));
        });
        StringBuilder builder = new StringBuilder("");
        set.stream().sorted((el1, el2) -> el2.length() - el1.length()).forEach(el -> builder.append(el).append("/"));
        if (builder.length() > 0) return builder.substring(0, builder.length() - 1);
        return "";
    }

    private static String makeElement(int frequency, String element, String place) {
        StringBuilder stringBuilder = new StringBuilder(place).append(":");
        for (int i = 0; i < frequency; i++) {
            stringBuilder.append(element);
        }
        return stringBuilder.toString();
    }
}
