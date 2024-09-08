import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M;
    static int[] dx, dy;
    static int[][] graph, distance;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        distance = new int[N][M];
        visited = new boolean[N][M];

        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        distance[x][y] = 1;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int xx = current[0];
            int yy = current[1];

            if (xx == N - 1 && yy == M - 1) {
                System.out.println(distance[N - 1][M - 1]);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && graph[nx][ny] == 1) {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[xx][yy] + 1;
                }
            }
        }
    }
    
}