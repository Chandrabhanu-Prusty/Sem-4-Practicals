import java.util.*;

public class Exp6_LOOK {
    public static void main(String[] args) {
        int[] req = {82,170,43,140,24,16,190};
        int head = 50;

        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        for (int x : req)
            if (x < head) left.add(x); else right.add(x);

        int seek = (Collections.max(right) - head) +
                   (Collections.max(right) - Collections.min(left));

        System.out.println("LOOK Total Head Movement: " + seek);
    }
}