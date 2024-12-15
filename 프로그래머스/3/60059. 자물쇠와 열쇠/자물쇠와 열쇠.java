class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        int N = key.length;
        int M = lock.length;
        
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotate(key);
            
            for (int nx = -N + 1; nx < M; nx++) {
                for (int ny = -N + 1; ny < M; ny++) {
                    if (canUnlock(key, lock, nx, ny)) {
                        return true;
                    }
                }
            }
        }
        
        return answer;
    }
    
    static boolean canUnlock(int[][] key, int[][] lock, int nx, int ny) {
        int N = key.length;
        int M = lock.length;
        
        int[][] tempLock = new int[M][M];
        for (int i = 0; i < M; i++) {
            System.arraycopy(lock[i], 0, tempLock[i], 0, M);
        }
        
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int nnx = x + nx;
                int nny = y + ny;
                
                if (0 <= nnx && nnx < M && 0 <= nny && nny < M) {
                    tempLock[nnx][nny] += key[x][y];
                    
                    if (tempLock[nnx][nny] > 1) {
                        return false;
                    }
                }
            }
        }
        
        // 자물쇠가 다 채워졌는지 확인
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < M; y++) {
                if (tempLock[x][y] == 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    static int[][] rotate(int[][] key) {
        
        int size = key.length;
        int[][] newKey = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newKey[j][size - i - 1] = key[i][j];
            }
        }
        return newKey;
    }
    
}
// 90도 회전 기능
// key 값이 lock에 일치하는지 확인 -> lock의 0의 값에만 확인하면됨
 // 열쇠를 4번 회전
 // 자물쇠를 열 수 있는지 확인하는 함수
 // 열쇠 회전 함수 (시계 방향 90도)