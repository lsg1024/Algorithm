import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int a;
    static int[] a_list;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = Integer.parseInt(br.readLine());

        a_list = new int[a];
        dp = new Integer[a];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < a; i++) {
            a_list[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < a; i++) {
            LIS(i);
        }

        int max = dp[0];

        for (int i = 1; i < a; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
        
    }

    static int LIS(int n) {
        if (dp[n] == null) {
            dp[n] = 1;

            for (int i = n - 1; i >= 0; i--) {
                if (a_list[i] < a_list[n]) {
                    dp[n] = Math.max(dp[n], LIS(i) + 1);
                }
            }
        }
        return dp[n];
    }
}