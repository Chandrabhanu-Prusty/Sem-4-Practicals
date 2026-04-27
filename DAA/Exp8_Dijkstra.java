import java.util.*;
public class Exp8_Dijkstra {
    static void dijkstra(int[][] graph, int source) {
        int V = graph.length;
        int[] dist = new int[V];
        boolean[] used = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int k = 0; k < V; k++) {
            int u = -1;
            for (int i = 0; i < V; i++) {
                if (!used[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            if (u == -1 || dist[u] == Integer.MAX_VALUE) {
                break;
            }
            used[u] = true;

            for (int v = 0; v < V; v++) {
                if (!used[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        printSolution(dist);
    }

    static void printSolution(int[] dist) {
        System.out.println("\nVertex \t Distance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of vertices: ");
            int V = sc.nextInt();

            int[][] graph = new int[V][V];
            System.out.println("Enter the Adjacency Matrix (use 0 for no edge):");
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            System.out.print("Enter the Source Vertex: ");
            int source = sc.nextInt();
            if (source < 0 || source >= V) {
                System.out.println("Invalid source vertex.");
                return;
            }

            dijkstra(graph, source);
        }
    }
}
