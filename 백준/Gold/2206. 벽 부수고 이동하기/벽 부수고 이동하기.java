import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M;
    static int[] dx, dy;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
        
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 0, 0});
        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int nx = current[0];
            int ny = current[1];
            int ncnt = current[2];
            int nwallBroken = current[3];

            if (nx == N - 1 && ny == M - 1) {
                return ncnt + 1;
            }

            // 칸 이동 && 벽검사
            for (int i = 0; i < 4; i++) {
    
                int nnx = nx + dx[i];
                int nny = ny + dy[i];
                if (0 <= nnx && nnx < N && 0 <= nny && nny < M) {

                    if (map[nnx][nny] == 1 && !visited[nnx][nny][1] && nwallBroken == 0) {
                        visited[nnx][nny][1] = true;
                        q.add(new int[] {nnx, nny, ncnt + 1, 1});
                    }
                    else if (map[nnx][nny] == 0 && !visited[nnx][nny][nwallBroken]) {
                        visited[nnx][nny][nwallBroken] = true;
                        q.add(new int[] {nnx, nny, ncnt + 1, nwallBroken});
                    }
                    
                }
            }
        }

        return -1;
    }
}