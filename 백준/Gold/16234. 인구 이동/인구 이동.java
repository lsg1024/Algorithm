import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, L, R, totalCount;
    static int[] dx, dy;
    static int[][] graph;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};

        totalCount = 0;
        while (true) {
            
            visited = new boolean[N][N];
            boolean moved = false;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) {
                break;
            }

            totalCount++;
            
        }

        System.out.println(totalCount);
        
    }


    static boolean bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});

        List<int[]> contries = new ArrayList<>();
        contries.add(new int[] {x, y});

        visited[x][y] = true;
        
        int totalPopulation = graph[x][y];
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int xx = current[0];
            int yy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                    int num = Math.abs(graph[xx][yy] - graph[nx][ny]);

                    if (L <= num && num <= R) {
                        queue.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        contries.add(new int[] {nx, ny});
                        totalPopulation += graph[nx][ny];
                    }   
                }
            }
        }

        if (contries.size() == 1) return false;
        
        int newPopulation = totalPopulation/contries.size();
        for (int[] pos : contries) {
            graph[pos[0]][pos[1]] = newPopulation;
        }

        return true;
        
    }
    
}