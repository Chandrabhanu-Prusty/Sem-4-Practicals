import java.util.*;

public class Exp3_FCFS {
    public static void main(String[] args) {
        int n = 5, at[] = {0,2,4,5,6}, bt[] = {3,6,4,2,5};
        int ct[] = new int[n], tat[] = new int[n], wt[] = new int[n];

        int time = 0;
        for (int i = 0; i < n; i++) {
            time = Math.max(time, at[i]);
            ct[i] = time + bt[i];
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
            time = ct[i];
        }

        float avgTAT = 0, avgWT = 0;

        System.out.println("P\tAT\tBT\tCT\tTAT\tWT");
        for (int i = 0; i < n; i++) {
            avgTAT += tat[i]; avgWT += wt[i];
            System.out.println((i+1)+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
        }

        System.out.println("Avg TAT = " + avgTAT/n);
        System.out.println("Avg WT = " + avgWT/n);
    }
}