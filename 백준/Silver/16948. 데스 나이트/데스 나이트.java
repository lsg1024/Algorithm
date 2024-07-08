import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, result;
    static int[][] start_end = new int[2][2];
    static boolean[][] visited;
    static int[][] directions = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 2; i++) {
            start_end[i][0] = Integer.parseInt(st.nextToken());
            start_end[i][1] = Integer.parseInt(st.nextToken());
        }

        result = Integer.MAX_VALUE;
        visited = new boolean[n][n];

        dfs(start_end[0][0], start_end[0][1]);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
            System.exit(0);
        }
        
        System.out.println(result);
        
        
    }

    static void dfs(int start_x, int start_y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start_x, start_y, 0});
        visited[start_x][start_y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int depth = current[2];

            if (x == start_end[1][0] && y == start_end[1][1]) {
                result = depth;
                return;
            }

            for (int[] dir :directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY, depth + 1});
                }
            }

        }
        
    }
    
}