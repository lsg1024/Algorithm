import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int n, max_num;
    static int[] n_list, dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        n_list = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            n_list[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = n_list[0];
        int max_num = n_list[0];
    
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(n_list[i], n_list[i] + dp[i - 1]);
            max_num = Math.max(dp[i], max_num);
        }

        System.out.println(max_num);
        
    }

} 