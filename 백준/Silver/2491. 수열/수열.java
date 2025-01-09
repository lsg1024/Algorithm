import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp_1 = new int[N];
        int[] dp_2 = new int[N];
        
        for (int i = 1; i < N; i++) {
            if (nums[i - 1] <= nums[i]) {
                dp_1[i] = dp_1[i - 1] + 1;
            }
            if (nums[i - 1] >= nums[i]) {
                dp_2[i] = dp_2[i - 1] + 1;
            }
        }

        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < N; i++) {
            max1 = Math.max(dp_1[i], max1);
            max2 = Math.max(dp_2[i], max2);
        }

        int max = Math.max(max1, max2);

        System.out.println(max + 1);

    }
}