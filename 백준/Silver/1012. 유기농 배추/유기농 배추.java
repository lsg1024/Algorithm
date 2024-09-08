import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int T, M, N, K, count;
    static int[][] graph;
    static StringBuilder sb = new StringBuilder(); 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new int[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[y][x] = 1;
            }

            count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[j][k] == 1) {
                        count++;
                        dfs(j, k);
                    } 
                }
            }

            sb.append(count).append("\n");
            
        }

        System.out.println(sb);
    }

    static boolean dfs(int x, int y) {
        if (0 > x || x >= N || 0 > y || y >= M) {
            return false;
        }

        if (graph[x][y] == 1) {
            graph[x][y] = 0;
            dfs(x + 1, y);
            dfs(x - 1, y);
            dfs(x, y + 1);
            dfs(x, y - 1);

            return true;
        }

        return false;
    }
}