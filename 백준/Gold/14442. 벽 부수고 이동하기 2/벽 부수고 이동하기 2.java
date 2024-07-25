import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M, K;
    static int[] dx, dy;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};
        
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
        
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][K + 1];
        queue.add(new int[] {0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int nx = current[0];
            int ny = current[1];
            int ncnt = current[2];
            int nbreakWall = current[3];

            if (nx == N - 1 && ny == M - 1) {
                return ncnt;
            }

            for (int i = 0; i < 4; i++) {
                int nnx = nx + dx[i];
                int nny = ny + dy[i];
                if (0 <= nnx && nnx < N && 0 <= nny && nny < M) {
                    if (map[nnx][nny] == 1 && nbreakWall + 1 <= K && !visited[nnx][nny][nbreakWall + 1]) {
                        visited[nnx][nny][nbreakWall + 1] = true;
                        queue.add(new int[] {nnx, nny, ncnt + 1, nbreakWall + 1});
                    }
                    else if (map[nnx][nny] == 0 && !visited[nnx][nny][nbreakWall]) {
                        visited[nnx][nny][nbreakWall] = true;
                        queue.add(new int[] {nnx, nny, ncnt + 1, nbreakWall});
                    }
                }
            }
            
        }
        return -1;
    }
    
}