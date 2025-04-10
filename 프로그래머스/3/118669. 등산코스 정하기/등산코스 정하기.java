import java.util.*;

class Solution {
    
    static class Node {
        int index, cost;
        
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
        
    }
    
    List<List<Node>> graph = new ArrayList<>();
    int n;
    int[] gates, summits;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        this.n = n;
        this.gates = gates;
        this.summits = summits;
        
        for (int i = 0; i < n + 1; i++) {
            graph.add(i, new ArrayList<>());
        }
        
        for (int i = 0; i < paths.length; i++) {
            int[] path = paths[i];
            int x = path[0];
            int y = path[1];
            int cost = path[2];       
            
            if (isGate(x) || isSummit(y)) {
                graph.get(x).add(new Node(y, cost));
            } else if (isGate(y) || isSummit(x)) {
                graph.get(y).add(new Node(x, cost));
            } else {
                graph.get(x).add(new Node(y, cost));
                graph.get(y).add(new Node(x, cost));
            }
            
        }
        
        Arrays.sort(summits);
        
        
        return dijkstra();
    }
    
    public int[] dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        for (int gate : gates) {
            pq.offer(new Node(gate, 0));
            visited[gate] = 0;
        }
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int index = current.index;
            int cost = current.cost;
            
            if (visited[index] < cost) continue;
            
            for (Node next : graph.get(index)) {
                int next_node = next.index;
                int next_cost = Math.max(visited[index], next.cost);
                
                if (visited[next_node] > next_cost) {
                    visited[next_node] = next_cost;
                    pq.offer(new Node(next_node, next_cost));
                }
            }
        }
        
        int maxIndex = -1;
        int maxCost = Integer.MAX_VALUE;
        
        for (int summit : summits) {
            if (visited[summit] < maxCost) {
                maxIndex = summit;
                maxCost = visited[summit];
            }
        }
        
        return new int[] {maxIndex, maxCost};
    }    
    
    public boolean isGate(int s) {
        for (int gate : gates) {
            if (gate == s) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isSummit(int s) {
        for (int summit : summits) {
            if (summit == s) {
                return true;
            }
        }
        return false;
    }
}