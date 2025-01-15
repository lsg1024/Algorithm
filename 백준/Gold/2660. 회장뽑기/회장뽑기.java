import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Node {
        int node;
        int cost;

        public Node (int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    static int N, historyMaxScore;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == -1 && y == -1) break;

            graph.get(x).add(new Node(y, 1));
            graph.get(y).add(new Node(x, 1));
        }

        historyMaxScore = Integer.MAX_VALUE;
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            int score = dijkstra(i);

            if (score == historyMaxScore) {
                arr.add(i);
            } else if (historyMaxScore > score) {
                historyMaxScore = score;
                arr = new ArrayList<>();
                arr.add(i);
            }
        }

        System.out.println(historyMaxScore + " " + arr.size());
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        
    }

    static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });

        pq.offer(new Node(start, 0));
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int node = current.node;
            int cost = current.cost;

            if (visited[node]) continue;
            visited[node] = true;

            for (Node next : graph.get(node)) {
                int next_node = next.node;
                int next_cost = next.cost + cost;

                if (!visited[next_node] && dist[next_node] > next_cost) {
                    dist[next_node] = next_cost;
                    pq.offer(new Node(next_node, next_cost));
                }
            }
        }

        int maxScore = 0;
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) continue;
            maxScore = Math.max(maxScore, d);
        }

        return maxScore;
    }
}