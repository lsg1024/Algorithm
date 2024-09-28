import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Node {
        int idx;
        int time;

        Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    static int N, K, min_time;
    static boolean[] visited = new boolean[100001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        min_time = Integer.MAX_VALUE;
        
        bfs();

        System.out.println(min_time);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));

        int max = 100000;
        visited[N] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();
            int idx = current.idx;
            int time = current.time;
            
            visited[idx] = true;

            if (idx == K) {
                min_time = Math.min(time, min_time);
            }

            // 우선순위 *2, +1, -1
            if (idx * 2 <= max && !visited[idx * 2]) {
                q.offer(new Node(idx * 2, time));
            }

            if (idx + 1 <= max && !visited[idx + 1]) {
                q.offer(new Node(idx + 1, time + 1));
            }

            if (0 <= idx - 1 && !visited[idx - 1]) {
                q.offer(new Node(idx - 1, time + 1));
            }
            
        }
    }
}