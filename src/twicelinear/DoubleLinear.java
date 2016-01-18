package twicelinear;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Iryna Guzenko on 11.01.2016.
 */
public class DoubleLinear {

    public static void main(String[] args) {
        System.out.println(dblLinear(6000));
    }

    public static int dblLinear(int n) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(1);
        int index = 0;
        while (sequence.size() < n*n) {
            sequence.add(sequence.get(index) * 2 + 1);
            sequence.add(sequence.get(index) * 3 + 1);
            index++;
        }
        List<Integer> result = new ArrayList<>(new HashSet<>(sequence));
        result.sort(Comparator.<Integer>naturalOrder());
//        result.stream().forEachOrdered(el -> System.out.print(el + " "));
        return result.get(n);
    }
}
