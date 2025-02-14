import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int count, minCount;
    static int[] paperCount = new int[] {0, 5, 5, 5, 5, 5};
    static int[][] graph = new int[10][10];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        minCount = Integer.MAX_VALUE;
        backtrack(0, 0, 0);

        if (minCount != Integer.MAX_VALUE) {
            System.out.println(minCount);
        } else {
            System.out.println(-1);
        }
        
    }

    static void backtrack(int x, int y, int count) {

        if (count >= minCount) return;

        if (x == 10) {
            minCount = Math.min(minCount, count);
            return;
        }

        if (y == 10) {
            backtrack(x + 1, 0, count);
            return;
        }
        
        if (graph[x][y] == 1) {
            for (int size = 5; size >= 1; size--) {
                if (canAttach(x, y, size)) {
                    attach(x, y, size, 0);   
                    paperCount[size]--;
                    backtrack(x, y + 1, count + 1);
                    attach(x, y, size, 1);   
                    paperCount[size]++;
                }
            }
        } else {
            backtrack(x, y + 1, count);
        }
        
        return;
    }

    static boolean canAttach(int x, int y, int size) {

        if (paperCount[size] <= 0) return false;
        
        for (int i = x; i < x + size; i++) {
            for (int j = y;  j < y + size; j++) {
                if (i >= 10 || j >= 10 || graph[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void attach(int x, int y, int size, int value) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                graph[i][j] = value;
                
            }
        }
    }
}