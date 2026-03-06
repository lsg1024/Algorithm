import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int M, N;
    static int[] dx = {1, -1 ,0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ", false);
            for (int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                graph[i][j] = number;

                if (number == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        System.out.print(bfs(queue));

    }

    static int bfs(Queue<int[]> queue) {
        int date = -1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M && graph[nx][ny] == 0) {

                    queue.add(new int[] {nx, ny});
                    graph[nx][ny] = graph[x][y] + 1;
                    date = Math.max(date, graph[nx][ny]);
     
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    return -1;
                }
            }
        }

        return date == -1 ? 0 : date - 1;
    }

    
}