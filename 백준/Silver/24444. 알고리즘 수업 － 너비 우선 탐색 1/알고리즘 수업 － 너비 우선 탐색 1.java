import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int V, E, R, count;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s_node = Integer.parseInt(st.nextToken());
            int e_node = Integer.parseInt(st.nextToken());
            graph.get(s_node).add(e_node);
            graph.get(e_node).add(s_node);
        }

        for (int i = 0; i < V + 1; i++) {
            Collections.sort(graph.get(i));
        }

        count = 1;
        bfs(R);
        System.out.println(sb);
        
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        int count = 1;
        visited[start] = count++;
        q.offer(start);
        
        while(!q.isEmpty()) {
            int num = q.poll();

            for (int i = 0; i < graph.get(num).size(); i++) {
                int next = graph.get(num).get(i);

                if (visited[next] != 0) {
                    continue;
                }

                q.offer(next);
                visited[next] = count++;
            }
        }
        for (int i = 1; i < V + 1; i++) {
            sb.append(visited[i]).append("\n");
        }
    }
    
}