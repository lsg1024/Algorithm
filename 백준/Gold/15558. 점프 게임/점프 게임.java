import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int n, k;
    static int[][] maps;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        maps = new int[2][n];

        String left = br.readLine();
        String right = br.readLine();
        
        for (int i = 0; i < n; i++) {
            maps[0][i] = Integer.parseInt(left.substring(i, i + 1));
            maps[1][i] = Integer.parseInt(right.substring(i, i + 1));
        }

        System.out.println(bfs(0, 0, 0));
        
    }

    static int bfs(int x, int y, int time) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[2][n];

        q.add(new int[] {x, y, time});
        visited[x][y] = false;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int nx = current[0];
            int ny = current[1];
            int n_time = current[2];

            if (ny + k >= n) {
                return 1;
            }

            if (ny < n_time) {
                continue;
            }
            
            // + 1
            if (ny + 1 < n && !visited[nx][ny + 1] && maps[nx][ny + 1] == 1) {
                visited[nx][ny + 1] = true;
                q.add(new int[] {nx, ny + 1, n_time + 1});
            }

            // - 1
            if (ny - 1 > n_time && !visited[nx][ny - 1] && maps[nx][ny - 1] == 1) {
                visited[nx][ny - 1] = true;
                q.add(new int[] {nx, ny - 1, n_time + 1});
            }

            // + k
            if (ny + k < n && !visited[1 - nx][ny + k] && maps[1 - nx][ny + k] == 1) {
                visited[1 - nx][ny + k] = true;
                q.add(new int[] {1 - nx, ny + k, n_time + 1});
            }
        }

        return 0;
    }
}