import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M, count;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        count = 0;
        for (int i = 1; i < N + 1; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
            
    }

    static void dfs(int node) {

        for (int nextNode : graph.get(node)) {
            if (visited[nextNode] == 0) {
                visited[nextNode] += 1;
                dfs(nextNode);
            }
        }
    }
}