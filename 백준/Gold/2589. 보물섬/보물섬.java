import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M, maxNumber;
    static int[] dx, dy;
    static String[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new String[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                String way = Character.toString(s.charAt(j));
                graph[i][j] = way;
            }
        }

        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};
        
        maxNumber = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j].equals("L")) {
                    bfs(i, j, 0);
                }
            }
        }

        System.out.println(maxNumber);

        
    }

    static void bfs (int x, int y, int depth) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y, depth});

        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;
   
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int nx = current[0];
            int ny = current[1];
            int ndepth = current[2];
            
            for (int i = 0; i < 4; i++) {
                int nnx = nx + dx[i];
                int nny = ny + dy[i];

                if (0 <= nnx && nnx < N && 0 <= nny && nny < M && !visited[nnx][nny]) {
                    if (graph[nnx][nny].equals("L")) {
                        visited[nnx][nny] = true;
                        maxNumber = Math.max(maxNumber, ndepth + 1);
                        queue.offer(new int[] {nnx, nny, ndepth + 1});
                    }
                }
            }
        }
    }
}