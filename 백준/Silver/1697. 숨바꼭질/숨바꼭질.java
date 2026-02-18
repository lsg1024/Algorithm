import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, K, count;
    static int[] moves = new int[] {-1, 1, 2};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        count = Integer.MAX_VALUE;
        dfs();
        System.out.println(count);
    }

    static void dfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {N, 0});
        boolean[] visited = new boolean[100001];
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int pos = current[0];
            int dist = current[1];

            if (pos == K) {
                count = Math.min(count, dist);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int n_pos;
                if (i <= 1) {
                    n_pos = pos + moves[i];
                } else {
                    n_pos = pos * moves[i];
                }

                if (0 <= n_pos && n_pos < 100001 && !visited[n_pos]) {
                    visited[n_pos] = true;
                    queue.add(new int[] {n_pos, dist + 1});
                }
                
            }
        }
    }
}