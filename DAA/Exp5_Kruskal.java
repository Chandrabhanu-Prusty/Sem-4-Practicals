import java.util.*;
public class Exp5_Kruskal {
// Find function (to find parent)
    static int find(int parent[], int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }

    // Union function
    static void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    public static void main(String[] args) {
        int V = 4; // number of vertices
        // edges: {source, destination, weight}
        int edges[][] = {
            {0, 1, 10},
            {0, 2, 6},
            {0, 3, 5},
            {1, 3, 15},
            {2, 3, 4}
        };
        // sort edges by weight
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int parent[] = new int[V];
        // initialize parent array
        for (int i = 0; i < V; i++) {   
            parent[i] = i;
        }
        System.out.println("Edges in Minimum Spanning Tree:");
        int count = 0;
        for (int i = 0; i < edges.length && count < V - 1; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            int x = find(parent, u);
            int y = find(parent, v);
            // check for cycle
            if (x != y) {
                System.out.println(u + " - " + v + " : " + w);
                union(parent, x, y);
                count++;
            }
        }
    }
}
