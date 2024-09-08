import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, count;
    static int[][] graph;
    static ArrayList<Integer> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    count = 0;
                    arr.add(dfs(i ,j));
                }
            }
        }

        Collections.sort(arr);

        sb.append(arr.size()).append("\n");
        
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i)).append("\n");
        }

        System.out.println(sb);
         
    }

    static int dfs(int x, int y) {
        if (0 > x || x >= N || 0 > y || y >= N) {
            return 0;
        }

        if (graph[x][y] == 1) {
            graph[x][y] = 0;
            count++;
            dfs(x + 1, y);
            dfs(x - 1, y);
            dfs(x, y + 1);
            dfs(x, y - 1);

            return count;
        }

        return 0;
    }
}