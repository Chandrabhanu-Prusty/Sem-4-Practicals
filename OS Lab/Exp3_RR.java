import java.util.*;
public class Exp3_RR {
    public static void main(String[] args) {
        int n = 5, tq = 2;
        int at[] = {0,2,4,5,6}, bt[] = {3,6,4,2,5}, rt[] = bt.clone();
        int ct[] = new int[n], tat[] = new int[n], wt[] = new int[n];

        Queue<Integer> q = new LinkedList<>();
        boolean inQ[] = new boolean[n];

        int time = 0, done = 0;
        q.add(0); inQ[0] = true;

        while (done < n) {
            int i = q.poll();

            if (rt[i] > tq) {
                time += tq;
                rt[i] -= tq;
            } else {
                time += rt[i];
                rt[i] = 0;
                ct[i] = time;
                done++;
            }

            for (int j = 0; j < n; j++)
                if (!inQ[j] && at[j] <= time && rt[j] > 0) {
                    q.add(j); inQ[j] = true;
                }

            if (rt[i] > 0) q.add(i);
        }

        float avgTAT = 0, avgWT = 0;

        System.out.println("P\tAT\tBT\tCT\tTAT\tWT");
        for (int i = 0; i < n; i++) {
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
            avgTAT += tat[i]; avgWT += wt[i];

            System.out.println((i+1)+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
        }

        System.out.println("Avg TAT = " + avgTAT/n);
        System.out.println("Avg WT = " + avgWT/n);
    }
}