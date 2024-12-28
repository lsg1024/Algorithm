import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        double weight;

        Edge(int u, int v, double weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
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

    static double kruskal(int n, List<Edge> edges) {
        Collections.sort(edges);
        parent = new int[n + 1];

        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }

        double mstWeight = 0;
        int count = 0;

        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                mstWeight = edge.weight + mstWeight;
                count++;
                if (count == n - 1) break;
            }
        }
        return mstWeight;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        double[][] stars = new double[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            stars[i][0] = x;
            stars[i][1] = y;
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2));
                edges.add(new Edge(i, j, distance));
            }
        }

        double mstWeight = kruskal(n, edges);

        System.out.printf("%.2f", mstWeight);
    }
}