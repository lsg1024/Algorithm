import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(score[0]);
            return;
        } else if (n == 2) {
            System.out.println(score[0] + score[1]);
            return;
        }

        dp[0] = score[0];
        dp[1] = score[0] + score[1];
        dp[2] = Math.max(score[0] + score[2], score[1] + score[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
        }

        System.out.println(dp[n - 1]);
    }
}