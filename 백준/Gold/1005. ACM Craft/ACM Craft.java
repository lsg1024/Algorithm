import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int T, N, K;
    static int[] dp, costs, inDegree;
    static ArrayList<ArrayList<Integer>> graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            costs = new int[N + 1];
            graph = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                costs[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N + 1; i++) {
                graph.add(new ArrayList<>());
            }

            inDegree = new int[N + 1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph.get(start).add(end);
                inDegree[end]++;
            }

            int target = Integer.parseInt(br.readLine());

            bfs(target);
        }
    }

    static void bfs(int target) {
        Queue<Integer> queue = new LinkedList<>();

        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) { // 진입 차수가 0인 것을 찾음 그것이 start인 부분
                queue.offer(i);
                dp[i] = costs[i];
            }
        }

        while (!queue.isEmpty()) {
            int index = queue.poll();

            for (int next : graph.get(index)) {
                inDegree[next]--;
                dp[next] = Math.max(dp[next], costs[next] + dp[index]);

                if (inDegree[next] == 0) {
                     queue.offer(next);   
                }
            }
        }
        
        System.out.println(dp[target]);
        
    }
}