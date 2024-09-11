import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N;
    static int[][] visited, graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new int[N][N];
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
                dfs(i, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : visited) {
            for (int col : row) {
                sb.append(col).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        
    }

    static void dfs(int start, int node) {
        
        for (int nextNode = 0; nextNode < N; nextNode++) {
            if (graph[node][nextNode] == 1 && visited[start][nextNode] == 0) {
                visited[start][nextNode] = 1;
                dfs(start, nextNode);
            }
        }
        
    }
}