import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int min = Integer.MAX_VALUE;
    static int N, M;

    static boolean[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == 'W') {
                    graph[i][j] = true;
                } else {
                    graph[i][j] = false;
                }
            }
        }

        for (int i= 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                find(i, j);
            }
        }
        System.out.println(min);

    }

    static void find(int x, int y) {
        int nx = x + 8;
        int ny = y + 8;

        int count = 0;
        boolean target = graph[x][y];

        for (int i = x; i < nx; i++) {
            for (int j = y; j < ny; j++) {
                if (graph[i][j] != target) {
                    count++;
                }
                target = !target;
            }
            target = target == false ? true : false;
        }

        count = Math.min(count, 64 - count);

        min = Math.min(count, min);
        
    }
}