package reversepolishcalculator;

/**
 * Created by Iryna Guzenko on 29.11.2015.
 */
public class MainPolishCalculator {
    public static void main(String[] args) {
        PolishCalculator c = new PolishCalculator();
        System.out.println(c.evaluate("1 2 3.5"));
    }

}
