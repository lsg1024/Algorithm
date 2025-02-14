import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, x, y, D, G, count;
    static int[] dx, dy;
    static int[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new int[101][101];
        dx = new int[] {1, 0, -1, 0};
        dy = new int[] {0, -1, 0, 1};

        StringTokenizer st;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());

            move();
        }

        count();

    }

    static void move() {
        List<Integer> directions = new ArrayList<>();
        directions.add(D);

        for (int i = 0; i < G; i++) {
            int size = directions.size();
            for (int j = size - 1; j >= 0; j--) {
                directions.add((directions.get(j) + 1) % 4);
            }
        }

        graph[y][x] = 1;
        for (int dir : directions) {
            x += dx[dir];
            y += dy[dir];

            graph[y][x] = 1;
        }
    }

    static void count() {
        count = 0;
        
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (graph[i][j] == 1 && graph[i + 1][j] == 1 && graph[i][j + 1] == 1 && graph[i + 1][j + 1] == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
    
}