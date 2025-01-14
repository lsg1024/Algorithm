import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        if (n >= 2) dp[2] = 1; 
        if (n >= 4) dp[4] = 2;
        if (n >= 5) dp[5] = 1;
        
        for (int i = 6; i <= n; i++) {
            if (dp[i - 2] != -1 && dp[i - 5] != -1) {
                dp[i] = Math.min(dp[i - 2] + 1, dp[i - 5] + 1);
            } else if (dp[i - 2] != -1) {
                dp[i] = dp[i - 2] + 1;
            } else if (dp[i - 5] != -1) {
                dp[i] = dp[i - 5] + 1;
            }
        }
        
        System.out.println(dp[n]);
    }

}