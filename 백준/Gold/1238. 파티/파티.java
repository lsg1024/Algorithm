import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    static int n, m, x;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
        }

        int maxDistance = 0;
        for (int i = 1; i < n + 1; i++) {
            if (i == x) continue;
            int goCost = dijkstra(i, x);
            int backCost = dijkstra(x, i);

            maxDistance = Math.max(maxDistance, goCost + backCost);
        }
        
        System.out.println(maxDistance);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int node = current.index;
            int cost = current.cost;

            if (visited[node]) continue;
            visited[node] = true;

            for (Node next : graph.get(node)) {
                int next_node = next.index;
                int next_cost = next.cost + cost;

                if (distance[next_node] > next_cost) {
                    distance[next_node] = next_cost;
                    pq.offer(new Node(next_node, next_cost));
                }
            }
        }

        return distance[end];
    }
    
}