import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int mod = 9901;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][3];
        Arrays.fill(dp[1], 1);
        
        for (int i = 2; i <= N; i++) {
            dp[i][0] += (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
            dp[i][1] += (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] += (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % mod);
        
    }
    
}
