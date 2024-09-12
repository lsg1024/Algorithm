import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];

        int max_height = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                graph[i][j] = height;

                if (max_height < height) {
                    max_height = height;
                }
                
            }
        }

        int result = 0;
        int count;
        for (int k = 0; k < max_height; k++) {
            count = 0;

            int[][] copyGraph = new int[N][N];
            for (int i = 0; i < N; i++) {
                copyGraph[i] = graph[i].clone();
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (copyGraph[i][j] > k) {
                        count++;
                        dfs(i, j, k, copyGraph);
                    }
                }
            }
            result = Math.max(result, count);
        }
       

        System.out.println(result);
        
    }

    static void dfs(int x, int y, int target, int[][] graph) {

        if (0 <= x && x < N && 0 <= y && y < N) {
            if (graph[x][y] > target) {
                graph[x][y] = -1;
                dfs(x + 1, y, target, graph);
                dfs(x - 1, y, target, graph);
                dfs(x, y + 1, target, graph);
                dfs(x, y - 1, target, graph);
                return;
            }
        }
        
    }
}