import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        quadTree(0, 0, n);
        System.out.println(sb);
    }

    static void quadTree(int x, int y, int size) {
        if (check(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        }

        int mid = size / 2;

        sb.append('(');
        
        quadTree(x, y, mid);
        quadTree(x, y + mid, mid);
        quadTree(x + mid, y, mid);
        quadTree(x + mid, y + mid, mid);

        sb.append(')');
    }

    static boolean check(int x, int y, int size) {
        
        int number = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != number) {
                    return false;
                }
            }
        }
        return true;
    }
    
}