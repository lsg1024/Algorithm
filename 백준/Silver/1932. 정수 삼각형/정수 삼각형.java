import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        dp = new int[N][N];

        dp[0][0] = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] += dp[i - 1][0];
                } else if (j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
            
        }

        int maxValue = Integer.MIN_VALUE;
        for (int j = 0; j < N; j++) {
            maxValue = Math.max(maxValue, dp[N - 1][j]);
        }

        System.out.println(maxValue);
    }
}