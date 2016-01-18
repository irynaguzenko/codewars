package validbraces;

/**
 * Created by Iryna Guzenko on 10.12.2015.
 */
public class Main {
    public static void main(String[] args) {
        BracesChecker checker = new BracesChecker();
        System.out.println(checker.isValid("[(("));
    }
}
