import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][][] dp = new int[N + 1][3][2];

        int[][] score = new int[N + 1][3];
        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
            score[i][2] = Integer.parseInt(st.nextToken());

            dp[i][0][0] = Integer.MAX_VALUE;
            dp[i][1][0] = Integer.MAX_VALUE;
            dp[i][2][0] = Integer.MAX_VALUE;

            dp[i][0][1] = Integer.MIN_VALUE;
            dp[i][1][1] = Integer.MIN_VALUE;
            dp[i][2][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < N + 1; i++) {
            dp[i][0][0] = score[i][0] + Math.min(dp[i - 1][0][0], dp[i - 1][1][0]);
            dp[i][1][0] = score[i][1] + Math.min(dp[i - 1][0][0], Math.min(dp[i - 1][1][0], dp[i - 1][2][0]));
            dp[i][2][0] = score[i][2] + Math.min(dp[i - 1][1][0], dp[i - 1][2][0]);

            dp[i][0][1] = score[i][0] + Math.max(dp[i - 1][0][1], dp[i - 1][1][1]);
            dp[i][1][1] = score[i][1] + Math.max(dp[i - 1][0][1], Math.max(dp[i - 1][1][1], dp[i - 1][2][1]));
            dp[i][2][1] = score[i][2] + Math.max(dp[i - 1][1][1], dp[i - 1][2][1]);
        }

        System.out.println(Math.max(dp[N][0][1], Math.max(dp[N][1][1], dp[N][2][1])) + " " + Math.min(dp[N][0][0], Math.min(dp[N][1][0], dp[N][2][0])));
        
    }
}