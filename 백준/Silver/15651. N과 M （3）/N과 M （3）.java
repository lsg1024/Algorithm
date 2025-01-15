import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[M];
        func(0);
        System.out.println(sb);
    }

    static void func(int depth) {
        if (depth == M) {
            for (int num : nums) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            nums[depth] = i;
            func(depth + 1);
        }
        
    }
}