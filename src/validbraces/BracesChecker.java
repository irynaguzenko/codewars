package validbraces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Iryna Guzenko on 10.12.2015.
 */
public class BracesChecker {

    public boolean isValid(String braces) {
        Stack<String> stackOfBraces = new Stack<>();
        Map<String, String> pairs = new HashMap<>();
        pairs.put(")", "(");
        pairs.put("}", "{");
        pairs.put("]", "[");
        final boolean[] result = {true};
        Arrays.stream(braces.split("")).forEachOrdered(brace -> {
            switch (brace) {
                case "(":
                case "{":
                case "[":
                    stackOfBraces.push(brace);
                    break;
                default:
                    if (!stackOfBraces.empty() && stackOfBraces.peek().equals(pairs.get(brace))) {
                        stackOfBraces.pop();
                        break;
                    } else {
                        result[0] = false;
                    }
            }
        });
        return stackOfBraces.empty() && result[0];
    }
}
