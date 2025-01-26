import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Edge implements Comparable<Edge> {
        int n;
        int v;
        int cost;

        public Edge(int n, int v, int cost) {
            this.n = n;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return this.cost - other.cost;
        }
    }

    static int[] parent;
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    static int N, M;
    static List<Edge> edges = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(x, y, cost));
        }

        kruskal();
    }

    static void kruskal() {
        
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
        
        Collections.sort(edges);

        int totalCost = 0;
        int totalCount = 0;

        for (Edge edge : edges) {
            if (find(edge.n) != find(edge.v)) {
                union(edge.n, edge.v);
                totalCost += edge.cost;
                totalCount++;
            }

            if (totalCount == N - 1) break;
            
        }

        System.out.println(totalCost);
    }
}