import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int T, COUNT;
    static int[] dx, dy;
    static int[][] graph = new int[100][100];
    static boolean[][] visited = new boolean[100][100];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    graph[y + i][x + j] = 1;
                    visited[y + i][x + j] = true;
                }
            }
        }

        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};
        COUNT = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (!visited[i][j] && graph[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(10000 - COUNT);
    }

    static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < 100 && 0 <= ny && ny < 100 && !visited[nx][ny] && graph[nx][ny] == 0) {
                graph[nx][ny] = 1;
                visited[nx][ny] = true;
                COUNT++;
                dfs(nx, ny);
            }
        }
    }
}