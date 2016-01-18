package scramblies;

/**
 * Created by Iryna Guzenko on 12.01.2016.
 */
public class ScrambleSearcher {

    public static void main(String[] args) {
        scramble("", "");
    }

    public static boolean scramble(String str1, String str2) {
        for (String letter : str2.split("")) {
            if (str1.contains(letter)) {
                str1 = str1.replaceFirst(letter, "");
            } else return false;
        }
        return true;
    }
}

