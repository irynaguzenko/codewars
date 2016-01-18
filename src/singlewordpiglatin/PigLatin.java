package singlewordpiglatin;

/**
 * Created by Iryna Guzenko on 16.01.2016.
 */
public class PigLatin {

    public static void main(String[] args) {
        System.out.println(translate("spad"));
    }

    public static String translate(String str) {
        String word = str.toLowerCase();
        if (!word.matches("[a-z]+")) return null;
        if (word.matches("[^aeiou]+")) return word.concat("ay");
        if (word.matches("^[aeiou].*")) return word.concat("way");
        while (!word.matches("^[aeiou].*")) {
            word = word.substring(1) + word.charAt(0);
        }
        return word.concat("ay");
    }
}
