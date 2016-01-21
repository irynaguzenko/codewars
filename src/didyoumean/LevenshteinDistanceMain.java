package didyoumean;

/**
 * Created by Iryna Guzenko on 20.01.2016.
 */
public class LevenshteinDistanceMain {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
        System.out.println(dictionary.findMostSimilar("javascpt"));
    }
}
