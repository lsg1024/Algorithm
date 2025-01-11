import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] blocks = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (st.hasMoreTokens()) {
                    blocks[i][j] = Integer.parseInt(st.nextToken());
                } else {
                    blocks[i][j] = 0;
                }
            }
        }

        int[][] dp = new int[N + 1][H + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int h = 0; h <= H; h++) {
                dp[i][h] = (dp[i][h] + dp[i - 1][h]) % 10_007;

                for (int block : blocks[i - 1]) {
                    if (block == 0) break;

                    if (h >= block) {
                        dp[i][h] = (dp[i][h] + dp[i - 1][h - block]) % 10_007;
                    }
                }
            }
        }

        System.out.print(dp[N][H]);
         
    }
}