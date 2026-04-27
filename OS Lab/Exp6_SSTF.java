import java.util.*;

public class Exp6_SSTF {
    public static void main(String[] args) {
        int[] req = {82,170,43,140,24,16,190};
        boolean[] vis = new boolean[req.length];
        int head = 50, seek = 0;

        for (int i = 0; i < req.length; i++) {
            int idx = -1, min = Integer.MAX_VALUE;

            for (int j = 0; j < req.length; j++)
                if (!vis[j] && Math.abs(req[j] - head) < min) {
                    min = Math.abs(req[j] - head);
                    idx = j;
                }

            vis[idx] = true;
            seek += min;
            head = req[idx];
        }
        System.out.println("SSTF Total Head Movement: " + seek);
    }
}