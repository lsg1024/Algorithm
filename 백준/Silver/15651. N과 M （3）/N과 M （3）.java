import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int n, m;
    static int[] value;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        value = new int[m];
        
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int dp) {

        if (dp == m) {
            for (int val : value) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
                value[dp] = i;
                dfs(dp + 1);

        } 
        
    }
}