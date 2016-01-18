package decomposesquares;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iryna Guzenko on 27.11.2015.
 */
public class TreesSaver {
    private static boolean READY = false;

    public static String decompose(long n) {
        READY = false;
        return (transformToString(getComponents(n, Math.pow(n, 2))));
    }

    private static List<Long> getComponents(long firstElement, double previousSum) {
        List<Long> preComponents = new ArrayList<>();
        for (long i = firstElement - 1; i > 0; i--) {
            if (Math.pow(i, 2) > previousSum) continue;
            previousSum -= Math.pow(i, 2);
            if (previousSum == 0) {
                READY = true;
                preComponents.add(i);
                return preComponents;
            }
            List<Long> list = getComponents(i, previousSum);
            previousSum += Math.pow(i, 2);
            preComponents.remove(i);
            Long currentComp = i;
            if (READY) {
                preComponents.add(currentComp);
                preComponents.addAll(list);
                return preComponents;
            }
        }
        return preComponents;
    }

    private static String transformToString(List<Long> components) {
        StringBuilder s = new StringBuilder();
        for (int i = components.size() - 1; i >= 0; i--) {
            s.append(components.get(i)).append(" ");
        }
        return s.toString().trim();
    }
}
