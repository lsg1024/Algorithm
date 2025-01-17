import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Node {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<Node>> graph;
    static int T, n, d, c, a, b, s;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            graph = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph.get(y).add(new Node(x, cost));
            }

            dijkstra(c);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        pq.offer(new Node(start, 0));

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        boolean[] visited = new boolean[n + 1];

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int node = current.node;
            int cost = current.cost;

            if (visited[node]) continue;
            visited[node] = true;

            for (Node next : graph.get(node)) {
                int next_node = next.node;
                int next_cost = next.cost + cost;

                if (distance[next_node] > next_cost) {
                    distance[next_node] = next_cost;
                    pq.offer(new Node(next_node, next_cost));
                }
            }
        }

        int count = 0;
        int totalHour = 0;
        for (int dist : distance) {
            if (dist == Integer.MAX_VALUE) continue;
            count++;
            totalHour = Math.max(dist, totalHour);
        }
        System.out.println(count + " " + totalHour);
    }
}