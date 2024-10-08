class Solution {
    
    static int[] result = new int[2];
    
    public int[] solution(int[][] arr) {
        
        int size = arr.length;
        
        //영역별 분할 탐색 dfs
        dfs(0, 0, size, arr);
        
        return result;
    }
    
    static void dfs(int x, int y, int size, int[][] arr) {
            
        if (isCheck(x, y, size, arr)) {
            result[arr[x][y]] += 1;
            
            return;
        }
        else {
            int re_size = size / 2;
            dfs(x, y, re_size, arr);
            dfs(x, y + re_size, re_size, arr);
            dfs(x + re_size, y, re_size, arr);
            dfs(x + re_size, y + re_size, re_size, arr);
        }
        
    }
    
    // 같은 숫자인지
    static boolean isCheck(int x, int y, int size, int[][] arr) {
        int target = arr[x][y];
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != target) {
                    return false;
                }
            }
        }
        
        return true;
    }
}