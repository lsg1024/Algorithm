import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, tx, ty;
    static int[] dx, dy;
    static int[][] graph;
    static long[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        graph = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[N + 1][N + 1];
        dp[1][1] = 1;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                int dist = graph[i][j];

                if (dist == 0) break;
                
                int nx = i + dist;
                int ny = j + dist;

                if (nx < N + 1) dp[nx][j] += dp[i][j];
                if (ny < N + 1) dp[i][ny] += dp[i][j];
            }
        }

        System.out.println(dp[N][N]);

    }

    
}