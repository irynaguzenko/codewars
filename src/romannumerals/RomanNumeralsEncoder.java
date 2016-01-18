package romannumerals;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Iryna Guzenko on 04.12.2015.
 */
public class RomanNumeralsEncoder {
    private static final Map<Integer, String> map = new HashMap<>();

    public String solution(int n) {
        fillMap();
        StringBuilder number = new StringBuilder();
        for (int i = 1; i <= 1000; i = i * 10) {
            int remainder = n % (i * 10);
            switch (remainder / i) {
                case 1:
                    number.append(map.get(i));
                    break;
                case 2:
                    number.append(map.get(i)).append(map.get(i));
                    break;
                case 3:
                    number.append(map.get(i)).append(map.get(i)).append(map.get(i));
                    break;
                case 4:
                    number.append(map.get(i * 5)).append(map.get(i));
                    break;
                case 5:
                    number.append(map.get(i * 5));
                    break;
                case 6:
                    number.append(map.get(i)).append(map.get(i * 5));
                    break;
                case 7:
                    number.append(map.get(i)).append(map.get(i)).append(map.get(i * 5));
                    break;
                case 8:
                    number.append(map.get(i)).append(map.get(i)).append(map.get(i)).append(map.get(i * 5));
                    break;
                case 9:
                    number.append(map.get(i * 10)).append(map.get(i));
                    break;
            }
            n -= remainder;
            if (n == 0) {
                return number.reverse().toString();
            }
        }
        return number.reverse().toString();
    }

    private void fillMap() {
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
    }
}
