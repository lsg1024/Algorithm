import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N;
    static int[] day, pay, dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        day = new int[N + 1];
        pay = new int[N + 1];

        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 2];

        int max = -1;
        for (int i = 1; i < N + 1; i++) {

            if (max < dp[i]) {
                max = dp[i];
            }

            int work = day[i] + i;

            if (work > N + 1) continue;
            
            dp[work] = Math.max(dp[work], max + pay[i]);
        }

        max = 0;
        for (int i = 1; i < N + 2; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.print(max);
        
    }
}