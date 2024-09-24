import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static Long[] dp = new Long[101];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Arrays.fill(dp, -1L);
        
        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        dp[4] = 2L;
        dp[5] = 2L;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(func(n)).append("\n");
        }

        System.out.println(sb);
        
    }

    static long func(int n) {
        if (dp[n] == -1) {
            dp[n] = func(n - 2) + func(n - 3);
            
        }
        
        return dp[n];
    } 
    
}