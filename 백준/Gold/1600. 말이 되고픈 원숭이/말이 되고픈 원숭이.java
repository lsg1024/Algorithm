import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int K, W, H;
    static int[] dx, dy;
    static int[][] graph;
    static boolean[][][] visited;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        graph = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dx = new int[] {1, -1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1};
        dy = new int[] {0, 0, 1, -1, -2, -1, 1, 2, 2, 1, -1, -2};

        visited = new boolean[H][W][K + 1];
        int result = bfs();
        System.out.println(result);
        
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];
            int k = current[3];

            if (x == H - 1 && y == W - 1) {
                return count;
            }
            
            for (int i = 0; i < 12; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (i < 4) {
                    if (0 <= nx && nx < H && 0 <= ny && ny < W && !visited[nx][ny][k] && graph[nx][ny] != 1) {
                        visited[nx][ny][k] = true;
                        queue.offer(new int[] {nx, ny, count + 1, k});
                    }
                } else {
                    if (0 <= nx && nx < H && 0 <= ny && ny < W && k + 1 < K + 1 && !visited[nx][ny][k + 1] && graph[nx][ny] != 1) {
                        visited[nx][ny][k + 1] = true;
                        queue.offer(new int[] {nx, ny, count + 1, k + 1});
                    }    
                }
            }
        }

        return -1;
        
    }
}