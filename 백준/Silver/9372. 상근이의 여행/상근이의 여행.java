import java.util.*;
import java.lang.*;
import java.io.*;
    
class Main {

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int weight;

        Edge (int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight = e.weight;
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    static int kruskal(int n, List<Edge> edges) {
        Collections.sort(edges); 
        parent = new int[n + 1]; 
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int mstWeight = 0;
        int edgeCount = 0;

        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                mstWeight += edge.weight;
                edgeCount++;

                if (edgeCount == n - 1) break;
            }
        }

        return mstWeight;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            List<Edge> edges = new ArrayList<>();
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
        
                edges.add(new Edge(u, v, 1));
            }

            int mstWeight = kruskal(N, edges);

            System.out.println(mstWeight);
        }
        
    }
}