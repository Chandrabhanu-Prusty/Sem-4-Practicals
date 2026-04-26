import java.util.*;
public class Exp4_JobSequencing {

    static class Job {
        int id, deadline, profit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of jobs:");
        int n = sc.nextInt();
        
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job();
        }

        System.out.println("Enter Job IDs:");
        for (int i = 0; i < n; i++) {
            jobs[i].id = sc.nextInt();
        }

        System.out.println("Enter Deadlines:");
        for (int i = 0; i < n; i++) {
            jobs[i].deadline = sc.nextInt();
        }

        System.out.println("Enter Profits:");
        for (int i = 0; i < n; i++) {
            jobs[i].profit = sc.nextInt();
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit));

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int[] slot = new int[maxDeadline];
        Arrays.fill(slot, -1);

        int totalProfit = 0;
        for (Job job : jobs) {
            for (int j = Math.min(maxDeadline, job.deadline) - 1; j >= 0; j--) {
                if (slot[j] == -1) {
                    slot[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Scheduled Jobs:");
        for (int i = 0; i < maxDeadline; i++) {
            if (slot[i] != -1) {
                System.out.print(slot[i] + " ");
            }
        }
        System.out.println("\nMaximum Profit = " + totalProfit);
        sc.close();
    }
}
