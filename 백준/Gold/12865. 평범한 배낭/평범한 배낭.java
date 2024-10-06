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

        items = new int[N + 1][2];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][K + 1];

        // i = 반복할 배낭 수 j = 물건 1 ~ K까지 무게 측정
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < K + 1; j++) {

                if (items[i][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i][0]] + items[i][1]);
                }
                
            }
        }

        System.out.println(dp[N][K]);

    }
    
}