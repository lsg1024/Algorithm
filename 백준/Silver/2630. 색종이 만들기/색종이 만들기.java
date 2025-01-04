import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] colors;
    static int[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        colors = new int[2];
        dfs(N, 0, 0);

        System.out.println(colors[0]);
        System.out.println(colors[1]);
    }

    static void dfs(int n, int x, int y) {

        int target = graph[x][y];
        
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (target != graph[i][j]) {
                    int half = n / 2;
                    dfs(half, x, y);
                    dfs(half, x, y + half);
                    dfs(half, x + half, y);
                    dfs(half, x + half, y + half);
                    return;
                }
            }
        }

        colors[target]++;
        return;
        
    }
}