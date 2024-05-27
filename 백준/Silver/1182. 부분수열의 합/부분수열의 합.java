import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, s, count;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        
        dfs(0, 0);

        if (s == 0) count--;
        
        System.out.println(count);
    
    }

    static void dfs(int idx, int point) {

        if (idx == n) {
            if (point == s) {
                count++;
            }
            return;
        }

        dfs(idx + 1, point);
        dfs(idx + 1, point + numbers[idx]);
        
    }
}