package doublecola;

/**
 * Created by Iryna Guzenko on 26.11.2015.
 */
public class WhoIsNext {
    private static String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};

    public static void main(String[] args) {
        System.out.println(whoIsNext(names, 100000000));
    }

    public static String whoIsNext(String[] names, int n) {
        int i = 0;
        int j = 1;
        for (int m = 1; m < 1000000000; m++) {
            for (String name : names) {
                i += j;
                if (n <= i) return name;
            }
            j = (int) Math.pow(2, m);
        }
        return null;
    }
}

//        List<String> queue = new ArrayList<>(Arrays.asList(names));
//        for (int i = 0; i < n - 1; i++) {
//            queue.add(queue.get(0));
//            queue.add(queue.get(0));
//            queue.remove(0);
//        }
//        return queue.get(0);x
