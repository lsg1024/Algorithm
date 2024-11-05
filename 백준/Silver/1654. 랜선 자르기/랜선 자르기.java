import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int K, N;
    static long low, high, mid, count, best;
    static int[] lan;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lan = new int[K];

        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);

        // 분할 탐색
        func();
        
        
    }

    static void func() {
        low = 1;
        high = lan[K - 1];
        best = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (func2(mid)) {
                best = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(best);
        
    }

    // 랜선 자를 수 있는지
    static boolean func2(long length) {

        int count = 0;
        for (int i = 0; i < K; i++) {
            count += lan[i] / length;
        }

        if (count >= N) {
            return true;
        }

        return false;
        
    }
    
}