import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M, min;
    static boolean[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String colors = br.readLine();
            for (int j = 0; j < M; j++) {
                if (colors.charAt(j) == 'W') {
                    graph[i][j] = true;
                } else {
                    graph[i][j] = false;
                }
            }
        }

        int height = N - 7;
        int width = M - 7;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    static void find(int x, int y) {
        int dx = x + 8;
        int dy = y + 8;

        boolean color = graph[x][y];

        int count = 0;
        for (int i = x; i < dx; i++) {
            for (int j = y; j < dy; j++) {
                if (graph[i][j] != color) {
                    count++;
                }

                color = (!color);
            }
            color = color == false ? true : false;
        }
        count = Math.min(count, 64 - count);

        min = Math.min(min, count);
    }
    
}