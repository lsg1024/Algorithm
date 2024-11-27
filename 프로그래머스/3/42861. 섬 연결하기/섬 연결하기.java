import java.util.*;

class Solution {
    
    static int[] parant;
    static int find(int x) {
        if (parant[x] == x) {
            return x;
        }
        return parant[x] = find(parant[x]);
    }
    
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            parant[rootY] = rootX;
        }
    }
    
    static int kruskal(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        parant = new int[n];
        for (int i = 0; i < n; i++) {
            parant[i] = i;
        }
        
        int mstWeight = 0;
        int edgeCount = 0;
        
        for (int[] cost : costs) {
            int x = cost[0];
            int y = cost[1];
            int weight = cost[2];
            
            if (find(x) != find(y)) {
                union(x, y);
                mstWeight += weight;
                edgeCount++;
                
                if (edgeCount == n - 1) {
                    break;
                }
            }
        }
        
        return mstWeight;
    }
    
    
    public int solution(int n, int[][] costs) {
        
        return kruskal(n, costs);
        
    }
}