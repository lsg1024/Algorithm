import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            answer = "YES";
            st = new StringTokenizer(br.readLine());
            
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= V; j++) {
                graph.add(new ArrayList<>());
            }
            
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            int[] visited = new int[V + 1];
            boolean bf_visit = true;
            for (int j = 1; j <= V; j++) {
                if (visited[j] == 0) {
                    if (!bfs(graph, visited, j)) {
                        break;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static boolean bfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int node) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int nextNode : graph.get(current)) {
                if (visited[nextNode] == 0) {
                    visited[nextNode] = -visited[current];
                    q.offer(nextNode);
                } else if (visited[nextNode] == visited[current]) {
                    answer = "NO";
                    return false;
                }
            }
        }
        return true;
    }
    
}