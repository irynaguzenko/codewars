package twicelinear;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Iryna Guzenko on 11.01.2016.
 */
public class DoubleLinearWithAQueue {


    public static void main(String[] args) {
        System.out.println(dblLinear(50));
    }

    public static int dblLinear(int n) {
        Queue<Integer> sequence = new PriorityQueue<>();
        sequence.offer(1);
        for (int i = 0; i < n; i++) {
            int result = sequence.poll();
            int x = result * 2 + 1;
            int y = result * 3 + 1;
            if (!sequence.contains(x)) sequence.offer(x);
            if (!sequence.contains(y)) sequence.offer(y);
        }
        return sequence.element();
    }
}
