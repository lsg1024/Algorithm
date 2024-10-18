import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M, max;
    static int[] dx, dy;
    static int[][] graph;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, 0, 0);
            }
        }

        System.out.println(max);
        
    }

    static void dfs(int x, int y, int count, int sum) {

        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {

                if (count == 2) {
                    visited[nx][ny] = true;
                    dfs(x, y, count + 1, sum + graph[nx][ny]);
                    visited[nx][ny] = false;
                }
                
                visited[nx][ny] = true;
                dfs(nx, ny, count + 1, sum + graph[nx][ny]);
                visited[nx][ny] = false;
            }
        }
        
    }
}