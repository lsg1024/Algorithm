import java.util.*;

class Solution {
    
    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};
    
    static String[][] graph = new String[][] {
        {"1", "2", "3"}, 
        {"4", "5", "6"},
        {"7", "8", "9"},
        {"*", "0", "#"}
    };
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[] right = new int[] {3, 2};
        int[] left = new int[] {3, 0};
        
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                for (int i = 0; i < 4; i++) {
                    if (graph[i][0].equals(String.valueOf(number))) {
                        left = new int[] {i, 0};
                        sb.append("L");
                    }
                }
            } else if (number == 3 || number == 6 || number == 9) {
                for (int i = 0; i < 4; i++) {
                    if (graph[i][2].equals(String.valueOf(number))) {
                        right = new int[] {i, 2};
                        sb.append("R");
                    }
                }
            } else {
                int left_count = find(left, String.valueOf(number));
                int right_count = find(right, String.valueOf(number));
                
                if (left_count == right_count) {
                    if (hand.equals("right")) {
                        sb.append("R");
                        for (int i = 0; i < 4; i++) {
                            if (graph[i][1].equals(String.valueOf(number))) {
                                right = new int[] {i, 1};     
                            } 
                        }
                    } else {
                        sb.append("L");
                        for (int i = 0; i < 4; i++) {
                            if (graph[i][1].equals(String.valueOf(number))) {
                                left = new int[] {i, 1};     
                            } 
                        }
                    }
                } else if (left_count < right_count) {
                    sb.append("L");
                    for (int i = 0; i < 4; i++) {
                        if (graph[i][1].equals(String.valueOf(number))) {
                            left = new int[] {i, 1};     
                        } 
                    }
                } else {
                    sb.append("R");
                    for (int i = 0; i < 4; i++) {
                        if (graph[i][1].equals(String.valueOf(number))) {
                            right = new int[] {i, 1};     
                        } 
                    }
                }
            }
        }
        
        return sb.toString();
    }
    
    static int find(int[] hand, String target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {hand[0], hand[1], 0});
        boolean[][] visited = new boolean[4][3];
        visited[hand[0]][hand[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];
            
            if (graph[x][y].equals(target)) {
                return count;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < 4 && 0 <= ny && ny < 3 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, count + 1});
                } 
            }
        }
        
        return -1;
    }
}