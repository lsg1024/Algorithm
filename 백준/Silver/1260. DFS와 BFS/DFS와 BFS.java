import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M, V, count;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        // 1 ~ N
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 0 ~ M
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node_1 = Integer.parseInt(st.nextToken());
            int node_2 = Integer.parseInt(st.nextToken());
            graph.get(node_1).add(node_2);
            graph.get(node_2).add(node_1);
        }

        for (int i = 0; i < N + 1; i++) {
            Collections.sort(graph.get(i));
        }

        count = 1;
        dfs(V);

        visited = new boolean[N + 1];
        sb.append("\n");
        bfs(V);

        System.out.println(sb);
        
    }

    static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");
        for (int nextNode : graph.get(node)) {
            if (!visited[nextNode]) {
                count++;
                dfs(nextNode);
            }
        }
    }

    static void bfs(int node) {

        Queue<Integer> queue = new LinkedList<>();

        count = 1;
        visited[node] = true;
        queue.offer(node);
        sb.append(node).append(" ");

        while(!queue.isEmpty()) {
            int num = queue.poll();
            for (int i = 0; i < graph.get(num).size(); i++) {
                int next = graph.get(num).get(i);

                if (visited[next]) {
                    continue;
                }
                queue.offer(next);
                sb.append(next).append(" ");
                visited[next] = true;
            }
        }
    }
    
}