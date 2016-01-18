package reversepolishcalculator;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Iryna Guzenko on 29.11.2015.
 */
public class PolishCalculator {
    Stack<Float> number = new Stack<>();

    public double evaluate(String expr) {
        String[] chars = expr.split(" ");
        if (expr.isEmpty()) return 0;
        Arrays.stream(chars).forEachOrdered(el -> {
            switch (el) {
                case "+":
                    number.push(number.pop() + number.pop());
                    break;
                case "-":
                    number.push(-number.pop() + number.pop());
                    break;
                case "*":
                    number.push(number.pop() * number.pop());
                    break;
                case "/":
                    number.push((1 / number.pop() * number.pop()));
                    break;
                default:
                    number.push(Float.parseFloat(el));
            }
        });
        return number.peek();
    }
}
