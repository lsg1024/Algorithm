import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] p = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = p[1];

        for (int i = 2; i < N + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] = Math.min(dp[i - j] + p[j], dp[i]);
            }
        }

        System.out.print(dp[N]);
    
    }
}