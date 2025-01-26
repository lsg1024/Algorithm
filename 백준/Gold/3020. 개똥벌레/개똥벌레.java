import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] bottom = new int[H + 1]; // 석순
        int[] top = new int[H + 1];    // 종유석

        boolean way = true;
        for (int i = 0; i < N; i++) {
            int length = Integer.parseInt(br.readLine());

            if (way) {
                bottom[length]++;
                way = false;
            } else {
                top[length]++;
                way = true;
            }
        }
        
        for (int i = H - 1; i > 0; i--) {
            bottom[i] += bottom[i + 1];
        }

        for (int i = H - 1; i > 0; i--) {
            top[i] += top[i + 1];
        }

        int minBreak = Integer.MAX_VALUE;
        int count = 0;

         for (int i = 1; i <= H; i++) {
            int breakWall = bottom[i] + top[H - i + 1];
            if (breakWall < minBreak) {
                minBreak = breakWall;
                count = 1;
            } else if (breakWall == minBreak) {
                count++;
            }
        }

        System.out.println(minBreak + " " + count);
        
    }
}