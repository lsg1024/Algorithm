import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, V, result;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        V = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int node_1 = Integer.parseInt(st.nextToken());
            int node_2 = Integer.parseInt(st.nextToken());
            graph.get(node_1).add(node_2);
            graph.get(node_2).add(node_1);
        }

        // 카운트만 필요하므로 정렬 X

        result = 0;
        dfs(1);

        System.out.println(result);
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int nextNode : graph.get(node)) {
            if (!visited[nextNode]) {
                result++;
                dfs(nextNode);
            }
        }
    }
}