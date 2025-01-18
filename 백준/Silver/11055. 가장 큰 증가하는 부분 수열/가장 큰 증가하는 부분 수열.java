import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.println(nums[1]);
            return;
        }
        
        int[] dp = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            dp[i] = nums[i];
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
        }

        int maxNum = 0;
        for (int d : dp) {
            maxNum = Math.max(maxNum, d);
        }
        System.out.println(maxNum);
    }
}