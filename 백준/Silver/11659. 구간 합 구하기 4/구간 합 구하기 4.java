import java.util.*;
import java.io.*;

public class Main {
    
    public static int n, m;
    public static int[] nums, prefix_sum;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        nums = new int[n];
        prefix_sum = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prefix_sum[i + 1] = prefix_sum[i] + Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            sb.append(prefix_value(x, y)).append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    public static int prefix_value(int x, int y) {
        return prefix_sum[y] - prefix_sum[x - 1];
    }
}