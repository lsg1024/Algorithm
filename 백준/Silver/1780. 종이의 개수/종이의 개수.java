import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] arr;
    static int[] total;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        arr = new int[n][n];
        total = new int[3]; // -1, 0, 1

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paperNum(0, 0, n);

        for (int t : total) {
            System.out.println(t);
        }
    }

    static void paperNum(int x, int y, int size) {
        if (check(x, y, size)) {
            int num = arr[x][y];
            if (num == -1) {
                total[0]++;
            }
            else if (num == 0) {
                total[1]++;
            }
            else {
                total[2]++;
            }
            return; 
        }

        int newSize = size / 3;

        paperNum(x, y, newSize);
        paperNum(x, y + newSize, newSize);
        paperNum(x, y + 2 * newSize, newSize);
        paperNum(x + newSize, y, newSize);
        paperNum(x + 2 * newSize, y, newSize);
        paperNum(x + newSize, y + newSize, newSize);
        paperNum(x + 2 * newSize, y + newSize, newSize);
        paperNum(x + newSize, y + 2 * newSize, newSize);
        paperNum(x + 2 * newSize, y + 2 * newSize, newSize);
    }

    static boolean check(int x, int y, int size) {
        int num = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}
