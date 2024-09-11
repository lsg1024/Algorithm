import java.util.*;
import java.lang.*;
import java.io.*;

// 왼쪽 아래, 오른쪽 위

class Main {

    static int M, N, K, result, count;
    static int[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // y
        N = Integer.parseInt(st.nextToken()); // x
        K = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x_1 = Integer.parseInt(st.nextToken());
            int y_1 = Integer.parseInt(st.nextToken());
            int x_2 = Integer.parseInt(st.nextToken());
            int y_2 = Integer.parseInt(st.nextToken());

            for (int y = M - y_2; y < M - y_1; y++) {
                for (int x = x_1; x < x_2; x++) {
                    graph[y][x] = 1;
                }
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        result = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 0) {
                    result++;
                    count = 0;
                    arr.add(dfs(i, j));
                }
            }
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(result).append("\n");
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i)).append(" ");
        }
        
        System.out.println(sb);
    }

    static int dfs(int y, int x) {

        if (0 <= x && x < N && 0 <= y && y < M) {
            if (graph[y][x] == 0) {
                graph[y][x] = 1;
                count++;
                dfs(y + 1, x);
                dfs(y - 1, x);
                dfs(y, x + 1);
                dfs(y, x - 1);
                return count;
            }
        }
        return 0;
    }
}