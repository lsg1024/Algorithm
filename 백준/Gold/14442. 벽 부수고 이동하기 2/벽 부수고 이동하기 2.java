import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M, K;
    static int[] dx, dy;
    static int[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
        
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 0, 0});

        boolean[][][] visited = new boolean[N][M][K + 1];
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int cnt = current[2];
            int isWall = current[3];

            if (x == N - 1 && y == M - 1) {
                return cnt + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {

                    if (graph[nx][ny] == 0 && !visited[nx][ny][isWall]) {
                        queue.offer(new int[] {nx, ny, cnt + 1, isWall});
                        visited[nx][ny][isWall] = true;
                    }

                    if (graph[nx][ny] == 1 && isWall < K && !visited[nx][ny][isWall + 1]) {
                        queue.offer(new int[] {nx, ny, cnt + 1, isWall + 1});
                        visited[nx][ny][isWall + 1] = true;
                    } 
                }
            }   
        }

        return -1;
        
    }
    
}