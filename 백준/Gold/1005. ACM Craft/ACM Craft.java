 import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int target;
    static int[] times, maxTime, inDegree;
    static ArrayList<ArrayList<Integer>> graph;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            times = new int[N + 1];
            maxTime = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                times[j] = Integer.parseInt(st.nextToken());
            }

            graph = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                graph.add(new ArrayList<>());
            }

            inDegree = new int[N + 1];
            for (int j = 1; j <= K; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph.get(start).add(end);
                inDegree[end]++;
            }

            target = Integer.parseInt(br.readLine());
            bfs(N);
        }
        System.out.println(sb);
    }

    static void bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                maxTime[i] = times[i];
            }
        }
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int next : graph.get(node)) {
                maxTime[next] = Math.max(maxTime[next], maxTime[node] + times[next]);
                if (--inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        sb.append(maxTime[target]).append("\n");
    }
    
}