import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int[] wines = new int[n];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(wines[0]);
            return;
        }
        
        dp[1] = wines[0];
        dp[2] = wines[0] + wines[1];

        for (int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], 
                             Math.max(dp[i - 2] + wines[i - 1], dp[i - 3] + wines[i - 2] + wines[i - 1]));
        }

        System.out.println(dp[n]);
    }
}