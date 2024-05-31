import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] stoke = new int[9][9];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 9; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                stoke[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        
        
    }

    static void dfs(int x, int y) {

        // 만족하는 값이 나오면 중지
        if (x > 8) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(stoke[i][j] + " ");
                }
                System.out.println();
            }

            System.exit(0);
        }

        // 이미 채워진 부분이면 넘기기
        if (stoke[x][y] != 0) {
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
            boolean isValid = true;

            // 행
            for (int j = 0; j < 9; j++) {
                if (stoke[x][j] == n) {
                    isValid = false;
                }
            }

            // 열
            for (int i = 0; i < 9; i++) {
                if (stoke[i][y] == n) {
                    isValid = false;
                }
            }

            // 3 * 3
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (stoke[(x / 3) * 3 + i][(y / 3) * 3 + j] == n) {
                        isValid = false;
                    }
                }
            }

            if (!isValid) {
                continue;
            }

            stoke[x][y] = n;

            if (y == 8) {
                dfs(x + 1, 0);
            }
            else {
                dfs(x, y + 1);
            }
            
            stoke[x][y] = 0;
        }
    }
}