import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] dp = new int[1000001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Arrays.fill(dp, -1);        
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(func(N));
    }

    static int func(int n) {
        if (dp[n] == -1) {
            dp[n] = (func(n - 1) + func(n - 2)) % 15746;
        }

        return dp[n];
    }
    
}