package yourorderplease;

/**
 * Created by Iryna Guzenko on 16.01.2016.
 */
public class Order {
    public static void main(String[] args) {
        System.out.println(order("is2 Thi1s T4est 3a"));
    }

    public static String order(String words) {
        String result = "";
        String[] elements = words.split(" ");
        for (int i = 1; i <= elements.length; i++) {
            for (String el : elements) {
                if (!el.contains(String.valueOf(i))) continue;
                result = result.concat(el + " ");
                break;
            }
        }
        return result.trim();
    }
}
