import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M, T;
    static List<List<Integer>> graph, reverseGraph;
    static boolean[] visited_1, visited_2;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();
        
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            reverseGraph.get(y).add(x);
        }

        T = Integer.parseInt(br.readLine());

        visited_1 = new boolean[N + 1];
        visited_2 = new boolean[N + 1];
        
        bfs(1, visited_1, graph);
        bfs(N, visited_2, reverseGraph);
        
        for (int t = 0; t < T; t++) {
            int target = Integer.parseInt(br.readLine());
            
            if (visited_1[target] && visited_2[target]) {
                sb.append("Defend the CTP").append("\n");
            } else {
                sb.append("Destroyed the CTP").append("\n");
            }
        }

        System.out.print(sb);
    }

    static void bfs(int start, boolean[] visited, List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
    
}