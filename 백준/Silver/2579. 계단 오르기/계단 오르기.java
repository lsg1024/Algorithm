import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] floors = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            floors[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(floors[1]);
            return;
        } else if (N == 2) {
            System.out.println(floors[1] + floors[2]);
            return;
        }

        dp[1] = floors[1];
        dp[2] = dp[1] + floors[2];
        dp[3] = Math.max(floors[1] + floors[3], floors[2] + floors[3]);
        
        for (int i = 4; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + floors[i], dp[i - 3] + floors[i - 1] + floors[i]);
        }

        System.out.println(dp[N]);
        
    }
}