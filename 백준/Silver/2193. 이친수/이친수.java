import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N;
    static long[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if (N == 1 || N == 2) {
            System.out.println(1);
            return;
        }

        dp = new long[N + 1];

        dp[1] = 1;
        dp[2] = 1;
        
        for (int i = 3; i < N + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[N]);
        
    }
}