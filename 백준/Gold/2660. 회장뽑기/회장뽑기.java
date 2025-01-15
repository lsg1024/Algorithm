import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static final int INF = 100_000;
    
    static int N;
    static int[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == -1 && y == -1) break;

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int[] scores = new int[N + 1];
        int minScore = INF;

        for (int i = 1; i < N + 1; i++) {
            int maxDist = 0;
            for (int j = 1; j < N + 1; j++) {
                maxDist = Math.max(maxDist, graph[i][j]);
            }
            scores[i] = maxDist;
            minScore = Math.min(minScore, maxDist);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            if (minScore == scores[i]) {
                count++;
                sb.append(i).append(" ");
            }
        }

        System.out.println(minScore + " " + count);
        System.out.println(sb);
        
    }
    
}