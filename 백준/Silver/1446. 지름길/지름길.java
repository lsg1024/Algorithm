import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Node {
        int index, cost;

        public Node (int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    static List<List<Node>> graph = new ArrayList<>();
    static int N, D;
    static int[] distance;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < D + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < D + 1; i++) {
            graph.get(i).add(new Node(i + 1, 1));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (e > D) continue;
            
            graph.get(s).add(new Node(e ,cost));
        }

        dijkstra();
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        pq.offer(new Node(0, 0));

        distance = new int[D + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        boolean[] visited = new boolean[D + 1];
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int node = current.index;
            int cost = current.cost;

            if (visited[node]) continue;
            visited[node] = true;

            for (Node next : graph.get(node)) {
                int next_node = next.index;
                int next_cost = next.cost + cost;

                if (next_node > D) break;

                if (distance[next_node] > next_cost) {
                    distance[next_node] = next_cost;
                    pq.offer(new Node(next_node, next_cost));
                }
            }
        }

        System.out.println(distance[D]);
    }
}