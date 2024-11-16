import java.util.*;

class Solution {
    
    static class Node {
        int index;
        int cost;
        
        Node (int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] visited;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        visited = new int[N + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        for (int i = 0; i < N + 1; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int[] r : road) {
            int x = r[0];
            int y = r[1];
            int cost = r[2];
            
            graph.get(x).add(new Node(y, cost));
            graph.get(y).add(new Node(x, cost));
        }
        
        dijkstra();
        
        for (int i = 1; i <= N; i++) {
            if (visited[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
    
    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        pq.offer(new Node(1, 0));
        
        visited[1] = 0;
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int cost = node.cost;
            
            if (visited[index] < cost) {
                    continue;
            }
            
            for (Node next : graph.get(index)) {
                int next_node = next.index;
                int next_cost = next.cost + cost;
                
                if (visited[next_node] > next_cost) {
                    visited[next_node] = next_cost;
                    pq.offer(new Node(next_node, next_cost));
                }
            }
        }
    }
    
}