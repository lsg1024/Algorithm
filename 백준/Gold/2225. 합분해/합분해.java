import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i < N + 1; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        
        for (int i = 0; i < K + 1; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 2; j < K + 1; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }

        System.out.println(dp[N][K]);
    }
}