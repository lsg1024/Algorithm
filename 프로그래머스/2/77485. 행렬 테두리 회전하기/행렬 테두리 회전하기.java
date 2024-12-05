class Solution {
    
    static int x1, x2, y1, y2, MIN;
    static int[][] graph;
    static int[] answer;
    
    
    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        
        graph = new int[rows + 1][columns + 1];
        
        int value = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                graph[i][j] = value;
                value++;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            MIN = Integer.MAX_VALUE;
            move(queries[i]);
            answer[i] = MIN;
        }
        
        return answer;
    }
    
    static void move(int[] queries) {
        
        x1 = queries[0];
        y1 = queries[1];
        x2 = queries[2];
        y2 = queries[3];

        int x_move = x2 - x1;
        int y_move = y2 - y1;

        int last = graph[x1][y1];

        last = graph_move(y_move, 1, true, last);
        last = graph_move(x_move, 1, false, last);
        last = graph_move(y_move, -1, true, last);
        last = graph_move(x_move, -1, false, last);
        
    }
    
    static int graph_move(int move, int moveType, boolean bool, int last) {
        
        for (int i = 1; i <= move; i++) {
            MIN = Math.min(MIN, last);
            
            int num = last;
            
            if (!bool) {
                x1 += moveType;   
            } else {
                y1 += moveType;
            }
            
            last = graph[x1][y1];
            
            graph[x1][y1] = num;
        }
        
        return last;
    }
}