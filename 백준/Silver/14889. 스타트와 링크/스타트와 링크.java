import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[][] graph;
    public static boolean[] visit;

    public static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n];

        method(0, 0);

        System.out.print(MIN);

    }

    public static void method(int num, int count) {
        if (n/2 == count) {
            dfs();
            return;
        }
        for (int i = num; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                method(i + 1, count + 1);
                visit[i] = false;
            }

        }
    }

    public static void dfs() {

        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] && visit[j]) {
                    start += graph[i][j] + graph[j][i];
                } else if (!visit[i] && !visit[j]) {
                    link += graph[i][j] + graph[j][i];
                }
            }
        }

        int value = Math.abs(start - link);

        if (value == 0) {
            System.out.println(0);
            System.exit(0);
        }

        MIN = Math.min(value, MIN);
    }
}