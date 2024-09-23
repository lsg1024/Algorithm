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

        graph = new int[N][M];

        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};

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
        // x, y, cnt, isWall, day
        queue.offer(new int[] {0, 0, 1, 0, 0});

        // 방문 처리 및 벽
        boolean[][][] visited = new boolean[N][M][K + 1];
        visited[0][0][0] = true; 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int cnt = current[2];
            int wall = current[3];
            int day = current[4];

            //탈출
            if (x == N - 1 && y == M - 1){
                return cnt;
            }

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    
                    // 벽부수기 전
                    if (graph[nx][ny] == 0 && !visited[nx][ny][wall]) {
                        visited[nx][ny][wall] = true;
                        queue.offer(new int[] {nx, ny, cnt + 1, wall, (day + 1) % 2});
                    }
    
                    // 벽부수기 후
                    if (graph[nx][ny] == 1 && wall < K && day % 2 == 0 && !visited[nx][ny][wall + 1]) {
                        visited[nx][ny][wall + 1] = true;
                        queue.offer(new int[] {nx, ny, cnt + 1, wall + 1, (day + 1) % 2});
                    }
                }
            }

            // 벽이 앞에 있을 때 밤이라면 머물러야 함
            if (day % 2 == 1) {
                queue.offer(new int[] {x, y, cnt + 1, wall, (day + 1) % 2});
            }
            
        }
        return -1;
    }
    
}