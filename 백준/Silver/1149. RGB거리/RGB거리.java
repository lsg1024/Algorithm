import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int n;
    static int[][] cost;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        cost = new int[n][3];
        
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]); 
            cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]); 
        }

        System.out.print(Math.min(Math.min(cost[n - 1][0], cost[n - 1][1]), cost[n - 1][2]));
        
    }
}