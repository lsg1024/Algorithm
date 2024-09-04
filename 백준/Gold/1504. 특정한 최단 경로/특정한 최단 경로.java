import java.util.*;
import java.lang.*;
import java.io.*;

class Node implements Comparable<Node> {
    int index;
    int cost;

    Node (int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
    
}

class Main {

    static int N, E, A, B, plan_1, plan_2;
    static int[] distance;
    static ArrayList<ArrayList<Node>> graph;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        
        graph = new ArrayList<ArrayList<Node>>();
        
        // 초기화
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }

        // 꼭 도착해야되는 지점
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        plan_1 = 0;
        plan_2 = 0;
        
        // A -> B
        plan_1 += dijkstra(1, A);
        plan_1 += dijkstra(A, B);
        plan_1 += dijkstra(B, N);

        // B -> A
        plan_2 += dijkstra(1, B);
        plan_2 += dijkstra(B, A);
        plan_2 += dijkstra(A, N);

        int result = Math.min(plan_1, plan_2);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }
        
        

    }

    static int dijkstra(int start, int end) {
        // 초기화
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curIndex = cur.index;
            int curCost = cur.cost;

            if (curCost > distance[curIndex]) continue;

            for (int i = 0; i < graph.get(curIndex).size(); i++) {
                Node next = graph.get(curIndex).get(i);
                int nextCost = curCost + next.cost;

                if (nextCost < distance[next.index]) {
                    distance[next.index] = nextCost;
                    pq.offer(new Node(next.index, nextCost));
                }
            }
        }

        if (distance[end] == Integer.MAX_VALUE) {
            System.out.print(-1);
            System.exit(0);
        }
        
        return distance[end];
    }
}