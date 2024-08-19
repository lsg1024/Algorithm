import java.util.*;
import java.io.*;

public class Main {
    
    public static int n, m;
    public static int[] nums;
    public static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken()); // 4
        m = Integer.parseInt(st.nextToken()); // 2
        
        nums = new int[m];
        visited = new boolean[n];
        
        bfs(n, 0);
    
    }
    
    public static void bfs(int n, int count) {
        if (count == m) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nums[count] = i + 1;
                bfs(n, count + 1);
                visited[i] = false;
            }
        }
    }
}

