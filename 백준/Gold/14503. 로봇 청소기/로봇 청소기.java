import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M, R, C, D, count;
    static int[] dx, dy;
    static int[][] graph;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dx = new int[] {-1, 0, 1, 0};
        dy = new int[] {0, 1, 0, -1};

        count = 0;
        dfs(R, C, D);

        System.out.println(count);
    }

    static void dfs(int x, int y, int d) {

        if (graph[x][y] == 0) {
            graph[x][y] = 2;
            count++;
        }

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (graph[nx][ny] == 0) {
                    dfs(nx, ny, d);
                    return;
                }
            }
        }

        int back = (d + 2) % 4;
        int backX = x + dx[back];
        int backY = y + dy[back];

        if (0 <= backX && backX < N && 0 <= backY && backY < M && graph[backX][backY] != 1) {
            dfs(backX, backY, d);
        }
        
    }
    
}