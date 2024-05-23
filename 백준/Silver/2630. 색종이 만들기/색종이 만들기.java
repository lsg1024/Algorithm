import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[][] arr;
    static int[] total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        total = new int[2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BlueAndWhite(0, n - 1, 0, n - 1);

        for (int i = 0; i < 2; i++) {
            System.out.println(total[i]);
        }
    }

    static void BlueAndWhite(int x_s, int x_e, int y_s, int y_e) {
        
        if (checkColor(x_s, x_e, y_s, y_e)) {
            int value = arr[y_s][x_s];
            total[value]++;
            return;
        }

        int midX = (x_s + x_e) / 2;
        int midY = (y_s + y_e) / 2;

        BlueAndWhite(x_s, midX, y_s, midY); 
        BlueAndWhite(midX + 1, x_e, y_s, midY); 
        BlueAndWhite(x_s, midX, midY + 1, y_e); 
        BlueAndWhite(midX + 1, x_e, midY + 1, y_e);
    }

    static boolean checkColor(int x_s, int x_e, int y_s, int y_e) {
        int color = arr[y_s][x_s];
        for (int i = y_s; i <= y_e; i++) {
            for (int j = x_s; j <= x_e; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
