import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static long n, k, count;
    static int[] a_list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());

        long low = 1;
        long high = k;
    
        while (low < high) {

            count = 0;
            long mid = (low +  high) / 2;

            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n); // 최대 값이 n을 넘어서는 안됨
            }

            if (k <= count) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
            
        }

        System.out.println(low);
        
    }
}