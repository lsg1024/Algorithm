import java.util.*;
import java.lang.*;
import java.io.*;

// 1 익은 토마토 0 익지 않은 토마토 -1 토마토 없음
// 3차원 창고 구조로 한층씩 쌓아 올리는 구조!!
class Main {
    static int n, m, h;
    static int[] dx, dy, dz;
    static int[][][] box;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        // 3차원 배열 이동 경로 
        dx = new int[] {1, -1, 0, 0, 0, 0};
        dy = new int[] {0, 0, 1, -1, 0, 0};
        dz = new int[] {0, 0, 0, 0, 1, -1};
        
        box = new int[h][n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }

        System.out.println(bfs(queue));
        
    }

    static int bfs(Queue<int[]> q) {

        int days = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            days++;
            for (int i = 0; i < size; i++) {

                int[] current = q.poll();
                int z = current[0];
                int y = current[1];
                int x = current[2];
    
                for (int j = 0; j < 6; j++) {

                    int nz = z + dz[j];
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    
                    if (0 <= nz && nz < h && 0 <= ny && ny < n && 0 <= nx && nx < m && box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = 1;
                        q.add(new int[] {nz, ny, nx});
                    }
                }
            }
            
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        return days;
        
    }
}