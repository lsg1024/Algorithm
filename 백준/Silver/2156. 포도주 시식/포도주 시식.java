import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] wines = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        
        if (N == 1) {
            System.out.println(wines[1]);
            return;
        } 
        
        dp[1] = wines[1];
        dp[2] = wines[2] + wines[1];

        for (int i = 3; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]));
        }

        System.out.println(dp[N]);
    }
}