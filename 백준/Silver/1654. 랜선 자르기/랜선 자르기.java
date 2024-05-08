import java.util.*;
import java.io.*;

public class Main {
    static int k, n;
    static int[] lanList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        lanList = new int[k];

        int max = 0;
        for (int i = 0; i < k; i++) {
            lanList[i] = Integer.parseInt(br.readLine());
            if (max < lanList[i]) {
                max = lanList[i];
            }
        }

        long low = 1, high = max, best = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (canMake(mid)) {
                best = mid;  
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(best);
    }

    static boolean canMake(long length) {
        long count = 0;
        for (int i = 0; i < k; i++) {
            count += lanList[i] / length;
        }
        return count >= n;
    }
}
