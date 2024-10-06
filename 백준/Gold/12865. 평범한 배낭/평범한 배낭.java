import java.util.*;
import java.io.*;

class Main {

    static int N, K;
    static int[][] items, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        items = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(items, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        dp = new int[N][K + 1];

        System.out.println(knapsack(N - 1, K));

    }

    static int knapsack(int i, int k) {
        
        if (i < 0) {
            return 0;
        } 

        if (dp[i][k] == 0) {
           if (items[i][0] > k) {
            dp[i][k] = knapsack(i - 1, k);
            } else {
                dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - items[i][0]) + items[i][1]);
            } 
        }

        return dp[i][k];
        
    }
    
}