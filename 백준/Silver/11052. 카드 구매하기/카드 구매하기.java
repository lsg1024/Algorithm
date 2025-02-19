import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N;
    static int[] coins, dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[N + 1];
        coins = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = coins[1];
        
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + coins[j]);
            }
        }

        System.out.println(dp[N]);
        
    }
}