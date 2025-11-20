import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M, maxCount;
    static int[] dx, dy;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
            }
        }

        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};

        maxCount = Integer.MIN_VALUE;
        buildWall(0);

        System.out.println(maxCount);
        
    }

    static void buildWall(int depth) {
        if (depth == 3) {
            maxCount = Math.max(maxCount, getArea());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    buildWall(depth + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    static int getArea() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = graph[i].clone();
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (copy[nx][ny] == 0) {
                        copy[nx][ny] = 2;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }

        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 0) {
                    safe++;
                }
            }
        }

        return safe;
    }
    
}