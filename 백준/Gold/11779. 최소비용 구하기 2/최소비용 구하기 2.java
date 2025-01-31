import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Node {
        int index;
        int cost;

        public Node (int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    
    static int N, M, S, E;
    static List<List<Node>> graph = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Node(y, cost));
            // graph.get(y).add(new Node(x, cost));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dijkstra();
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });

        pq.offer(new Node(S, 0));

        boolean[] visited = new boolean[N + 1];
        int[] prev = new int[N + 1];
        int[] distance = new int[N + 1];
        
        Arrays.fill(prev, -1);
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int cost = node.cost;

            if (visited[index]) continue;
            visited[index] = true;

            for (Node next : graph.get(index)) {
                int next_index = next.index;
                int next_cost = next.cost + cost;

                if (distance[next_index] > next_cost) {
                    distance[next_index] = next_cost;
                    prev[next_index] = index;
                    pq.offer(new Node(next_index, next_cost));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(distance[E]).append("\n");

        List<Integer> path = new ArrayList<>();
        for (int p = E; p != -1; p = prev[p]) {
            path.add(p);
        }
        Collections.reverse(path);
        sb.append(path.size()).append("\n");

        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i)).append(" ");
        }

        System.out.println(sb);
        
        
    }
}