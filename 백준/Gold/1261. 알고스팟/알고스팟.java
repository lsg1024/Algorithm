import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M;
    static int[] dx, dy;
    static int[][] graph, visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};

        graph = new int[N + 1][M + 1];
        visited = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            String s = br.readLine();
            for (int j = 1; j < M + 1; j++) {
                int num = s.charAt(j - 1) - '0';
                graph[i][j] = num;
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs());

    }

    static int bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[2] - o2[2];
        });
        pq.offer(new int[] {1, 1, 0});
        visited[1][1] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int wall = current[2];

            if (x == N && y == M) {
                return wall;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 < nx && nx <= N && 0 < ny && ny <= M) {

                    int nextWall = wall + graph[nx][ny];

                    if (nextWall < visited[nx][ny]) {
                        visited[nx][ny] = nextWall;
                        pq.offer(new int[] {nx, ny, nextWall});
                    }
                    
                }
            }
        }
        
        return -1;
    }
    
}