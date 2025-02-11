import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int total = 0;
        int min = Integer.MAX_VALUE;

        while (s <= N && e <= N) {
            if (total >= S && min > e - s) {
                min = e - s;
            }

            if (total < S) {
                total += nums[e++];
            } else {
                total -= nums[s++];
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}