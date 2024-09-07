import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int V, E, R, count;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s_node = Integer.parseInt(st.nextToken());
            int f_node = Integer.parseInt(st.nextToken());
            graph.get(s_node).add(f_node);
            graph.get(f_node).add(s_node);
        }

        for (int i = 1; i < V + 1; i++) {
            Collections.sort(graph.get(i));
        }

        count = 1;
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        
        visited[start] = count++;
        
        for (int value : graph.get(start)) {
            // 한번도 방문하지 않음
            if (visited[value] == 0) {
                dfs(value);
            }
        }

        
    }
    
}