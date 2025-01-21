import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static int[][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                graph[i][j] = graph[i - 1][j] + graph[i][j-1] + Integer.parseInt(st.nextToken()) - graph[i -1][j -1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x_1 = Integer.parseInt(st.nextToken());
            int y_1 = Integer.parseInt(st.nextToken());
            int x_2 = Integer.parseInt(st.nextToken());
            int y_2 = Integer.parseInt(st.nextToken());


            int result = graph[x_2][y_2] - graph[x_2][y_1-1] - graph[x_1 - 1][y_2] + graph[x_1- 1][y_1 - 1];
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}