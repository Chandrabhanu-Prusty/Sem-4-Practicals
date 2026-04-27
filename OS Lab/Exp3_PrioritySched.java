public class Exp3_PrioritySched {

    public static void main(String[] args) {
        int n = 5, at[] = {0, 2, 4, 5, 6}, bt[] = {3, 6, 4, 2, 5}, pr[] = {2, 1, 3, 2, 4};
        boolean done[] = new boolean[n];
        int ct[] = new int[n], tat[] = new int[n], wt[] = new int[n];

        int time = 0, completed = 0;

        while (completed < n) {
            int idx = -1, best = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!done[i] && at[i] <= time && pr[i] < best) {
                    best = pr[i];
                    idx = i;
                }
            }

            if (idx == -1) {
                time++; 
            }else {
                ct[idx] = time + bt[idx];
                tat[idx] = ct[idx] - at[idx];
                wt[idx] = tat[idx] - bt[idx];
                time = ct[idx];
                done[idx] = true;
                completed++;
            }
        }

        float avgTAT = 0, avgWT = 0;

        System.out.println("P\tAT\tBT\tCT\tTAT\tWT");
        for (int i = 0; i < n; i++) {
            avgTAT += tat[i];
            avgWT += wt[i];
            System.out.println((i + 1) + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
        }

        System.out.println("Avg TAT = " + avgTAT / n);
        System.out.println("Avg WT = " + avgWT / n);
    }
}
