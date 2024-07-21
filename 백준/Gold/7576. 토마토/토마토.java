import java.util.*;
import java.lang.*;
import java.io.*;

// 1 익은 토마토 0 익지 않은 토마토 -1 토마토 없음
class Main {
    static int n, m;
    static int[] dx, dy;
    static int[][] box;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        dx = new int[] {1, -1, 0, 0};
        dy = new int[] {0, 0, 1, -1};

        box = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int status = Integer.parseInt(st.nextToken());
                box[i][j] = status;
                if (status == 1) {
                    queue.add(new int[] {i, j});
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
                int nx = current[0];
                int ny = current[1];

                for (int j = 0; j < 4; j++) {
                    int nnx = nx + dx[j];
                    int nny = ny + dy[j];
                    
                    if (0 <= nnx && nnx < n && 0 <= nny && nny < m && box[nnx][nny] == 0) {
                        box[nnx][nny] = 1;
                        q.add(new int[] {nnx, nny});
                    }
                } 
            }  
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
            }
        }

        return days;

        
    }
}

