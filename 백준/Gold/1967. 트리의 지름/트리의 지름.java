import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static class Node {
        int index, cost;

        public Node (int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    static List<List<Node>> graph = new ArrayList<>();
    static int N, node, maxCost;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Node(y, cost));
            graph.get(y).add(new Node(x, cost));
        }

        visited = new boolean[N + 1];
        dfs(1, 0);

        visited = new boolean[N + 1];
        dfs(node, 0);

        System.out.println(maxCost);
        
    }

    static void dfs(int index, int cost) {
        if (cost > maxCost) {
            maxCost = cost;
            node = index;
        }

        visited[index] = true;

        for (int i = 0; i < graph.get(index).size(); i++) {
            Node next = graph.get(index).get(i);
            if (!visited[next.index]) {
                dfs(next.index, next.cost + cost);
                visited[next.index] = true;
            }
        }
    }
    
}
