import java.util.*;
import java.lang.*;
import java.io.*;

class Node implements Comparable<Node> {

    int index;
    int cost;

    Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
    
}

class Main {

    static int V, E, K;
    static int[] distence;
    static ArrayList<ArrayList<Node>> graph;
    // static boolean[] visited;
    
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

        // visited = new boolean[V + 1];
        distence = new int[V + 1];
        Arrays.fill(distence, Integer.MAX_VALUE);

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
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int current = currentNode.index;
            int currentCost = currentNode.cost;

            // 처리된 node 무시
            if (currentCost > distence[current]) continue;

            // 인접 노드 탐색저
            for (int i = 0; i < graph.get(current).size(); i++) {
                Node nextNode = graph.get(current).get(i);
                int next = nextNode.index;
                int cost = currentCost + nextNode.cost;

                // 더 짧은 경로 발견시 우선순위 큐에 넣기
                if (cost < distence[next]) {
                    distence[next] = cost;
                    pq.offer(new Node(next, cost));
                }
            }
        }
    }
}