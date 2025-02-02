import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Point {
        int index;
        double x;
        double y;

        public Point(int index, double x, double y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }
    
    static class Edge implements Comparable<Edge> {
        int v, w;
        double cost;

        public Edge (int v, int w, double cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            if (this.cost < other.cost) {
                return -1;
            }
            return 1;
        }
    }

    static int N, M;
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

    static List<Edge> edges = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Point[] points = new Point[N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            points[i] = new Point(i, x, y);
        }

        parent = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            union(s, e);
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                double cost = distance(points[i], points[j]);

                edges.add(new Edge(points[i].index, points[j].index, cost));
            }
        }

        Collections.sort(edges);

        kruskal(edges);
        
    }

    static void kruskal(List<Edge> edges) {

        double totalCost = 0;
        int totalCount = 0;

        for (Edge edge : edges) {
            if (find(edge.v) != find(edge.w)) {
                union(edge.v, edge.w);
                totalCost += edge.cost;
                totalCount++;

                if (totalCount == N - 1) break;
            }
        }

        System.out.printf("%.2f", totalCost);
        
    }

    static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2)); 
    }
    
}