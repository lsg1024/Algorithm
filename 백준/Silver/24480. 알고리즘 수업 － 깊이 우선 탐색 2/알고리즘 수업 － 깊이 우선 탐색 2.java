import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M, R, count;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s_node = Integer.parseInt(st.nextToken());
            int e_node = Integer.parseInt(st.nextToken());
            graph.get(s_node).add(e_node);
            graph.get(e_node).add(s_node);
        }

        for (int i = 0; i < N + 1; i++) {
             Collections.sort(graph.get(i), Collections.reverseOrder());
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
        // 현재 값을 방문 노드에 추가
        visited[start] = count++;

        // 반복문으로 이동하며 방문하지 않은 노드 찾기
        for (int next_node : graph.get(start)) {
            if (visited[next_node] == 0) {
                dfs(next_node);
            }
        }


    }
    
}