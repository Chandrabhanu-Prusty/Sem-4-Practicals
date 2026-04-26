public class Exp5_Prims {
    public static void main(String[] args) {
        int V = 5;
        int graph[][] = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };
        boolean selected[] = new boolean[V];
        selected[0] = true;
        System.out.println("Edges in Minimum Spanning Tree:");
        int count = 0;
        while (count < V - 1) {
            int min = Integer.MAX_VALUE;
            int x = 0, y = 0;
            for (int i = 0; i < V; i++) {
                if (selected[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!selected[j] && graph[i][j] != 0) {
                            if (graph[i][j] < min) {
                                min = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " : " + graph[x][y]);
            selected[y] = true;
            count++;
        }
    }
}