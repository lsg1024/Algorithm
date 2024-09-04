import java.util.*;
import java.lang.*;
import java.io.*;

class Node {

    int index;
    int cost;

    Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
}

class Main {

    static int V, E, K;
    static int[] distence;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList<ArrayList<Node>>();

        // graph 초기화
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, cost));
        }

        visited = new boolean[V + 1];
        distence = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {
            distence[i] = Integer.MAX_VALUE;
        }
        distence[K] = 0;

        dijkstra();

        for (int i = 1; i < V + 1; i++) {
            if (distence[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(distence[i]);
            }
        }
    }

    static void dijkstra() {
         for (int i = 0; i < V; i++) {
            int nodeValue = Integer.MAX_VALUE;

            int nodeIndex = 0;

            // 시작 인덱스는 생략하고 반복
            for (int j = 1; j < V + 1; j++) {
                if (distence[j] < nodeValue && !visited[j]) {
                    nodeValue = distence[j];
                    nodeIndex = j;
                }
            }

            visited[nodeIndex] = true;

            for (int j = 0; j < graph.get(nodeIndex).size(); j++) {
                Node node = graph.get(nodeIndex).get(j);

                // 인접 노드가 현재 가지는 최소 비용을 비교해 적으면 해당 값으로 갱신
                if (distence[node.index] > distence[nodeIndex] + node.cost) {
                    distence[node.index] = distence[nodeIndex] + node.cost;
                }   
            }
        }
    }
}