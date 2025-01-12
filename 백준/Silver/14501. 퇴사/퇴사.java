import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        int[][] days = new int[N + 1][2];

        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            days[i][0] = Integer.parseInt(st.nextToken());
            days[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            int day = days[i][0];
            int pay = days[i][1];

            dp[i] = Math.max(dp[i], dp[i - 1]);

            if (i <= N && i + day - 1 <= N) {
                dp[i + day - 1] = Math.max(dp[i + day - 1], pay + dp[i - 1]);
            }
        }

        int max = 0;
        for (int i = 0; i <= N; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
        
    }
}