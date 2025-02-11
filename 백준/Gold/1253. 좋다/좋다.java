import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static long[] goods;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        goods = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            goods[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(goods);

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (goodCounts(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean goodCounts(int i) {
        
        long target = goods[i];
        int left = 0;
        int right = goods.length - 1;
    
        while (left < right) {

            if (left == i) {
                left++;
                continue;
            } else if (right == i) {
                right--;
                continue;
            }

            long sum = goods[left] + goods[right];
            if (target == sum) {
                return true;
            } else if (target > sum) {
                left++;
            } else {
                right--;
            }
        } 

        return false;
    }
}