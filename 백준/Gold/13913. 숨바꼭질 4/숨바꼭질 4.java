import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, K, minTime;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[100_001];
        minTime = Integer.MAX_VALUE;
        bfs();

    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {N, 0});

        boolean[] visited = new boolean[100_001];
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int index = current[0];
            int time = current[1];

            if (index == K) {
                minTime = Math.min(minTime, time);
            }

            if (index * 2 < 100_001 && !visited[index * 2]) {
                queue.offer(new int[] {index * 2, time + 1});
                visited[index * 2] = true;
                parent[index * 2] = index;
            }

            if (index + 1 < 100_001 && !visited[index + 1]) {
                queue.offer(new int[] {index + 1, time + 1});
                visited[index + 1] = true;
                parent[index + 1] = index;
            }

            if (index - 1 >= 0 && !visited[index - 1]) {
                queue.offer(new int[] {index - 1, time + 1});
                visited[index - 1] = true;
                parent[index - 1] = index;
            }
        }

        System.out.println(minTime);

        Stack<Integer> stack = new Stack();
        while (K != N) {
            stack.push(K);
            K = parent[K];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(N).append(" ");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.print(sb);
    }

}