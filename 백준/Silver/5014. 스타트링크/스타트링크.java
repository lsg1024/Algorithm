import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int F, S, G, U, D;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        bfs();
    
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {S, 0});

        boolean[] visited = new boolean[F + 1];
        visited[S] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int floar = current[0];
            int depth = current[1];

            if (floar == G) {
                System.out.println(depth);
                return;
            }

            int[] nextFloar = new int[2];
            nextFloar[0] = floar + U;
            nextFloar[1] = floar - D;

            for (int i = 0; i < 2; i++) {
                if (0 < nextFloar[i] && nextFloar[i] < F + 1 && !visited[nextFloar[i]]) {
                    visited[nextFloar[i]] = true;
                    queue.offer(new int[] {nextFloar[i], depth + 1});
                }
            }
        }

        System.out.println("use the stairs");
    }
}