import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M;
    static int[] list;
    static boolean[] visited;
    static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[M];
        visited = new boolean[N];

        sb = new StringBuilder();
        backtrack(0);

        System.out.println(sb);
        
    }

    static void backtrack(int depth) {

        if (depth == M) {
            for (int l : list) {
                sb.append(l).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            
            if (!visited[i]) {
                visited[i] = true;
                list[depth] = i + 1;
                backtrack(depth + 1);
                visited[i] = false;
            }
            
        }
        
    }
    
}