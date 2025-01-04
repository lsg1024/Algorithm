import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] trees = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[T + 1][W + 1];

        for (int t = 1; t < T + 1; t++) {
            for (int w = 0; w < W + 1; w++) {
                int tree = trees[t];

                dp[t][w] = dp[t - 1][w];
                if (w > 0) {
                    dp[t][w] = Math.max(dp[t][w], dp[t - 1][w - 1]);
                }
                if ((w % 2 == 0 && tree == 1) || (w % 2 == 1 && tree == 2)) {
                    dp[t][w]++;
                }
            }
        }

        int max = 0;
        for (int w = 0; w <= W; w++) {
            max = Math.max(dp[T][w], max);
        }

        System.out.println(max);
    }
}