import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] blocks;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        blocks = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 1; i < W - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(blocks[j], left);
            }

            for (int j = i + 1; j < W; j++) {
                right = Math.max(blocks[j], right);
            }

            if (blocks[i] < left && blocks[i] < right) {
                result += Math.min(left, right) - blocks[i];
            }
            
        }
        System.out.println(result);
    }
}