import java.util.*;

public class Exp6_SCAN {
    public static void main(String[] args) {
        int[] req = {82,170,43,140,24,16,190};
        int head = 50, size = 200;

        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        for (int x : req)
            if (x < head) left.add(x); else right.add(x);

        int seek = (size-1 - head) + (size-1 - Collections.min(left));
        System.out.println("SCAN Total Head Movement: " + seek);
    }
}