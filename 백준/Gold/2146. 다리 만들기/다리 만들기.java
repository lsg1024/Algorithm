import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, index;
    static int[] dx, dy;
    static int[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};
        

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][N];
        index = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    bfs(i, j, visited);
                    index++;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] != 0) {
                     result = Math.min(findMinBridge(i, j, graph[i][j]), result);   
                }
            }
        }
        
        System.out.println(result);
        
    }

    static int findMinBridge(int x, int y, int island) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});

        boolean[][] visitedBridge = new boolean[N][N];
        visitedBridge[x][y] = true;
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int xx = current[0];
                int yy = current[1];

                for (int j = 0; j < 4; j++) {
                    int nx = xx + dx[j];
                    int ny = yy + dy[j];

                    if (0 <= nx && nx < N && 0 <= ny && ny < N && !visitedBridge[nx][ny]) {
                        visitedBridge[nx][ny] = true;

                        if (graph[nx][ny] != 0 && graph[nx][ny] != island) {
                            return depth;
                        }

                        if (graph[nx][ny] == 0) {
                            queue.offer(new int[] {nx, ny});
                        }
                    }
                }
            }
            depth++;
        }

        return Integer.MAX_VALUE;
        
    }

    static void bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});

        visited[x][y] = true;
        graph[x][y] = index;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int xx = current[0];
            int yy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    graph[nx][ny] = index;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
    
}