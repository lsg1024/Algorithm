import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int n, m;
    static int[] numbers;
    static int[] value;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

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

        int bf_num = 0;
        
        for (int i = 0; i < numbers.length; i++) {


            if (bf_num != numbers[i]) {
                
                value[dp] = numbers[i];
    
                bf_num = numbers[i];
                
                dfs(dp + 1);

                
            }
                 
        } 
    }
}