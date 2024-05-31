import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] sudoku = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 9; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        
        
    }

    static void dfs(int x, int y) {

        // 만족하는 값이 나오면 중지
        if (x > 8) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        // 이미 채워진 부분이면 넘기기
        if (sudoku[x][y] != 0) {
            if (y == 8) {
                dfs(x + 1, 0);
            }
            else {
                dfs(x, y + 1);
            }
            return;
        }
        
        // 행, 열, 3 * 3 값이 일치하는지
        for (int n = 1; n <= 9; n++) {

            if (isValid(x, y, n)) {
                sudoku[x][y] = n;
                if (y == 8) {
                    dfs(x + 1, 0);
                }
                else {
                    dfs(x, y + 1);
                }
                sudoku[x][y] = 0;
            }
            
        }
    }

    static boolean isValid(int x, int y, int n) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == n) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (sudoku[i][y] == n) {
                return false;
            }
        }

        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[startX + i][startY + j] == n) {
                    return false;
                }
            }
        }

        return true;
    }
}