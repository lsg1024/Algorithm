import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int T, M, N, K;
    static int[] dx, dy;
    static int[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
    
            graph = new int[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[y][x] = 1;
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int y, int x) {

        if (x < 0 || x >= M || y < 0 || y >= N) {
            return;
        }

        if (graph[y][x] == 0) {
            return;
        }

        graph[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            dfs(y + dy[i],  x + dx[i]);
        }
    }
}