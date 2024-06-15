import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, count, chessboard[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        chessboard = new int[n];
        
        dfs(0);

        System.out.println(count);
        
    }
    
    static void dfs(int idx) {
        if (idx == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            chessboard[idx] = i;
            if (isCheck(idx)){
                dfs(idx + 1);
            }
        }
    }

    // 상하좌우, 대각선
    static boolean isCheck(int idx) {
        for (int i = 0; i < idx; i++) {
           if (chessboard[idx] == chessboard[i]) {
               return false;
           }
           else if (idx - i == Math.abs(chessboard[idx] - chessboard[i])) {
               return false;
            }
        }

        return true;
    }

}