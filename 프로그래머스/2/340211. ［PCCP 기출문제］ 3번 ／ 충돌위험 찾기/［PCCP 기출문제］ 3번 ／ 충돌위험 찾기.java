import java.util.*;

class Solution {
    
    static int size, answer;
    
    public int solution(int[][] points, int[][] routes) {
        
        size = routes.length;
        
        Queue<int[]>[] queue = new LinkedList[size];
        
        for (int i = 0; i < size; i++) {
            queue[i] = new LinkedList<>();
        }
        
        findPosition(queue, points, routes);
        findAccident(queue);
        
        return answer;
    }
    
    static void findPosition(Queue<int[]>[] queue, int[][] points, int[][] routes) {
        
        for (int i = 0; i < size; i++) {
            int[] point = points[routes[i][0] - 1];
            int x = point[0];
            int y = point[1];
            
            queue[i].add(new int[] {x, y});
            
            for(int j = 1; j < routes[0].length; j++){
                
                int[] end_point = points[routes[i][j] - 1];
                int nx = end_point[0];
                int ny = end_point[1];

                int mx = nx - x;
                int my = ny - y;

                while (mx != 0) {
                    if (mx > 0) {
                        mx--;
                        x++;
                        queue[i].add(new int[] {x, y});
                    } else {
                        mx++;
                        x--;
                        queue[i].add(new int[] {x, y});
                    }
                }

                while (my != 0) {
                    if (my > 0) {
                        my--;
                        y++;
                        queue[i].add(new int[] {x, y});
                    } else {
                        my++;
                        y--;
                        queue[i].add(new int[] {x, y});
                    }
                }
                
            }
            
        }
    }
    
    static void findAccident(Queue<int[]>[] queue) {
        
        int count = 0;
        
        while (count != size) {
            int[][] graph = new int[101][101];
            count = 0;
            
            for (int i = 0; i < size; i++) {
                if (queue[i].isEmpty()) {
                    count++;
                    
                }
                int[] temp = queue[i].poll();
                if (temp != null) {
                    graph[temp[0]][temp[1]]++;
                }
            }
            
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (graph[i][j] > 1) {
                        answer++;
                    }
                }
            }
        }
    }
}