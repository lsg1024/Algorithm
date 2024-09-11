import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int T, H, W, count;
    static int[][] graph, visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            graph = new int[H][W];
            visited = new int[H][W];

            for (int h = 0; h < H; h++) {
                String input = br.readLine();
                for (int w = 0; w < W; w++) {
                    graph[h][w] = input.charAt(w);
                }
            }

            count = 0;
            for (int h = 0; h < H; h++) {
                for (int w = 0; w < W; w++) {
                    if (graph[h][w] == 35) {
                        count++;
                        dfs(h, w);
                    }
                }
            }

            sb.append(count).append("\n");
    
        }

        System.out.print(sb);
    }

    static void dfs(int x, int y) {
        if (0 <= x && x < H && 0 <= y && y < W && graph[x][y] == 35) {
            graph[x][y] = 46;
            dfs(x + 1, y);
            dfs(x - 1, y);
            dfs(x, y + 1);
            dfs(x, y - 1);
            return;
        }
        
    }
}