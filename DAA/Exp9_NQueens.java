public class Exp9_NQueens {
    static int count;
    public static void main(String[] args) {
        int n = 4;
        count = 0;
        solve(0, 0, 0, 0, new int[n], n);
        System.out.println("Total solutions for " + n + "-Queens: " + count);
    }

    static void solve(int col, int rows, int diag1, int diag2, int[] queens, int n) {
        if (col == n) {
            count++;
            printSolution(queens, n);
            return;
        }
        for (int row = 0; row < n; row++) {
            if ((rows & (1 << row)) == 0 && (diag1 & (1 << (row + col))) == 0
                    && (diag2 & (1 << (row - col + n))) == 0) {
                queens[col] = row;
                solve(col + 1, rows | (1 << row), diag1 | (1 << (row + col)),
                        diag2 | (1 << (row - col + n)), queens, n);
            }
        }
    }

    static void printSolution(int[] queens, int n) {
        System.out.println("\nSolution " + count + ":");
        for (int row : queens) {
            for (int col = 0; col < n; col++) {
                System.out.print(col == row ? "Q " : ". ");
            }
            System.out.println();
        }
    }
}
