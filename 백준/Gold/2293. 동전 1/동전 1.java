import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, K;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        int[] dp = new int[K + 1];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K + 1; j++) {
                if (j < coins[i]) continue;

                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.println(dp[K]);
        
    }
}