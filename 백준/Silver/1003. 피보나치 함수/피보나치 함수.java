import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
    
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                System.out.println(1 + " " + 0);
                continue;
            } else if (n == 1) {
                System.out.println(0 + " " + 1);
                continue;
            }

            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}