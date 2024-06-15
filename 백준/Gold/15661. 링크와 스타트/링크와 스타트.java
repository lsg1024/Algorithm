import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n;
    static int[][] ability;
    static boolean[] visit;
    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ability = new int[n][n];
        visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
             isCheck(0, 0, i);   
        }
        
        System.out.println(Min);
    }

    static void isCheck(int idx, int count, int target) {

        if (target == count) {
            dfs();
            return;
        }
        
        for (int i = idx; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                isCheck(i + 1, count + 1, target);
                visit[i] = false;
            }
        }
    }


    static void dfs() {
        int start = 0;
        int link = 0;
    
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] && visit[j]) {
                    start += ability[i][j] + ability[j][i];
                }
                else if (!visit[i] && !visit[j]){
                    link += ability[i][j] + ability[j][i];
                }
            }
        }
        int value = Math.abs(start - link);
    
        if (value == 0) {
            System.out.println(0);
            System.exit(0);
        }
        
        Min = Math.min(Min, value);
    }
}