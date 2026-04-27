import java.util.*;
public class Exp4_BankersAlgorithm {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        System.out.print("Enter number of resource types: ");
        int m = sc.nextInt();
        int[][] max = new int[n][m];
        int[][] allocation = new int[n][m];
        int[][] need = new int[n][m];
        int[] available = new int[m];
        // Input Allocation Matrix
        System.out.println("Enter Allocation Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                allocation[i][j] = sc.nextInt();
            }
        }
        // Input Max Matrix
        System.out.println("Enter Max Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max[i][j] = sc.nextInt();
            }
        }
        // Input Available Resources
        System.out.println("Enter Available Resources:");
        for (int j = 0; j < m; j++) {
            available[j] = sc.nextInt();
        }
        // Calculate Need Matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }
        boolean[] finished = new boolean[n];
        int[] safeSequence = new int[n];
        int count = 0;
        while (count < n) {
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (!finished[i]) {
                    int j;
                    for (j = 0; j < m; j++) {
                        if (need[i][j] > available[j])
                            break;
                    }
                    if (j == m) { // Process can execute
                        for (int k = 0; k < m; k++) {
                            available[k] += allocation[i][k];
                        }
                        safeSequence[count++] = i;
                        finished[i] = true;
                        found = true;
                    }
                }
            }
            if (!found) {
                break;
            }
        }
        if (count == n) {
            System.out.println("\nSystem is in SAFE state.");
            System.out.print("Safe Sequence: ");
            for (int i = 0; i < n; i++) {
                System.out.print("P" + safeSequence[i] + " ");
            }
        } else {
            System.out.println("\nSystem is in UNSAFE state.");
        }
    }
}