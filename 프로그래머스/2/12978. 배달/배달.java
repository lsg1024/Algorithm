import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node> {
        int node;
        int weight;
        
        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
        
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < road.length; i++) {
            int x = road[i][0];
            int y = road[i][1];
            int w = road[i][2];
            
            graph.get(x).add(new Node(y, w));
            graph.get(y).add(new Node(x, w));
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int node = current.node;
            int weight = current.weight;
            
            if (weight > dist[node]) continue;
            
            for (Node next : graph.get(node)) {
                int next_node = next.node;
                int next_weight = next.weight + dist[node];
                
                if (next_weight < dist[next_node]) {
                    dist[next_node] = next_weight;
                    pq.add(new Node(next_node, next_weight));
                }
            }
        }

        
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}