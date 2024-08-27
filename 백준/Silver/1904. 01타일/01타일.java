import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] dp = new int[10000001];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = -1;
        }

        System.out.print(func(n));
        
    }

    static int func(int n) {
        if (dp[n] == -1) {
            dp[n] = (func(n - 1) + func(n - 2)) % 15746;
        }

        return dp[n];
    }
    
}