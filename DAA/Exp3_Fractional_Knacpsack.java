import java.util.*;
public class Exp3_Fractional_Knacpsack {
    static class Item {

        double profit;
        double weight;
        double ratio;

        Item(double profit, double weight) {
            this.profit = profit;
            this.weight = weight;
            this.ratio = profit / weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items (n): ");
        int n = sc.nextInt();

        System.out.print("Enter knapsack capacity (m): ");
        double capacity = sc.nextDouble();

        double[] profits = new double[n];
        double[] weights = new double[n];

        System.out.println("Enter all profits:");
        for (int i = 0; i < n; i++) {
            profits[i] = sc.nextDouble();
        }

        System.out.println("Enter all weights:");
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextDouble();
        }

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(profits[i], weights[i]);
        }

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        System.out.println("\nItems sorted by profit/weight ratio (high to low):\n");
        System.out.println("Index\tProfit\tWeight\tRatio");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "\t" + items[i].profit + "\t" + items[i].weight + "\t" + items[i].ratio);
        }

        double totalProfit = 0;
        double remaining = capacity;

        for (int i = 0; i < n && remaining > 0; i++) {
            if (remaining >= items[i].weight) {
                totalProfit += items[i].profit;
                remaining -= items[i].weight;
            } else {
                totalProfit += items[i].ratio * remaining;
                break;
            }
        }

        System.out.println("Maximum Profit = " + totalProfit);
        sc.close();
    }
}
