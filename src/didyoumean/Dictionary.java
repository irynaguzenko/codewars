package didyoumean;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Iryna Guzenko on 20.01.2016.
 */
public class Dictionary {

    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public String findMostSimilar(String to) {
        SortedMap<Integer, String> changingCost = new TreeMap<>();
        for (String word : words) {
            int[][] alignment = initAlignmentArray(word, to);
            for (int i = 1; i < alignment.length; i++) {
                for (int j = 1; j < alignment[0].length; j++) {
                    alignment[i][j] = min(alignment[i - 1][j], alignment[i][j - 1], alignment[i - 1][j - 1], to.charAt(i - 1), word.charAt(j - 1));
                }
            }
            changingCost.put(alignment[alignment.length - 1][alignment[0].length - 1], word);
        }
        return changingCost.get(changingCost.firstKey());
    }

    private int[][] initAlignmentArray(String fromWord, String toWord) {
        int[][] alignment = new int[toWord.length() + 1][fromWord.length() + 1];
        for (int i = 0; i < alignment.length; i++) {
            alignment[i][0] = i;
        }
        for (int j = 0; j < alignment[0].length; j++) {
            alignment[0][j] = j;
        }
        return alignment;
    }

    private int min(int insert, int delete, int replace, char from, char to) {
        replace += from == to ? 0 : 1;
        return Math.min(Math.min(insert + 1, delete + 1), replace);
    }
}
