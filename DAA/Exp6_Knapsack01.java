import java.util.Scanner;
public class Exp6_Knapsack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        int[] weights = new int[n];
        int[] profits = new int[n];
        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        System.out.println("Enter profits of items:");
        for (int i = 0; i < n; i++) {
            profits[i] = sc.nextInt();
        }
        System.out.print("Enter capacity of knapsack: ");
        int capacity = sc.nextInt();
        int maxProfit = knapsack(weights, profits, capacity, n);
        System.out.println("Maximum Profit: " + maxProfit);
        sc.close();
    }

    public static int knapsack(int[] wt, int[] pro, int cap, int n) {
        int[] dp = new int[cap + 1];
        for (int i = 0; i < n; i++) {
            // Iterate backwards so each item is used at most once (0/1 knapsack).
            for (int w = cap; w >= wt[i]; w--) {
                dp[w] = Math.max(dp[w], pro[i] + dp[w - wt[i]]);
            }
        }
        return dp[cap];
    }
}
