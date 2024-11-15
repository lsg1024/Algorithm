import java.util.*;
import java.util.Map.Entry;
import java.io.*;

class Main {

    static class Node {
        int index;
        int cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    static int T, n, m, t, s, g, h;
    static int[] visited;
    static HashMap<Integer, Integer> resultMap;
    static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.get(x).add(new Node(y, cost));
                graph.get(y).add(new Node(x, cost));
            }

            resultMap = new HashMap<>();
            for (int j = 0; j < t; j++) {
                int target = Integer.parseInt(br.readLine());

                int a_one = dijkstra(s, g);
                int a_two = dijkstra(g, h);
                int a_three = dijkstra(h, target);

                if (a_one == -1 || a_two == -1 || a_three == -1) {
                    continue;
                }

                int a_value = a_one + a_two + a_three;

                int b_one = dijkstra(s, h);
                int b_two = dijkstra(h, g);
                int b_three = dijkstra(g, target);

                if (b_one == -1 || b_two == -1 || b_three == -1) {
                    continue;
                }

                int b_value = b_one + b_two + b_three;

                int min_value = Math.min(a_value, b_value);
                int value = dijkstra(s, target);

                if (min_value == value) {
                    resultMap.put(target, min_value);
                }
            }

            if (resultMap.size() == 0) {
                System.out.println();
            } else {
                List<Integer> sortedKeys = new ArrayList<>(resultMap.keySet());
                Collections.sort(sortedKeys);
                for (int key : sortedKeys) {
                    System.out.print(key + " ");
                }
                System.out.println();
            }
        }
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.offer(new Node(start, 0));

        visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int index = current.index;
            int cost = current.cost;

            if (cost > visited[index]) {
                continue;
            }

            for (Node next : graph.get(index)) {
                int next_index = next.index;
                int next_cost = next.cost + cost;

                if (visited[next_index] > next_cost) {
                    visited[next_index] = next_cost;
                    pq.offer(new Node(next_index, next_cost));
                }
            }
        }

        return visited[end] == Integer.MAX_VALUE ? -1 : visited[end];
    }
}
