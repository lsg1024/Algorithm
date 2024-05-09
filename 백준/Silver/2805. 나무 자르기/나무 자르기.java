import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m, max;
    static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trees = new int[n];

        st = new StringTokenizer(br.readLine());
        max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (max < trees[i]) {
                max = trees[i];
            }
        }

        long low = 0, high = max, result = 0;
        
        while (low <= high) {
            long avg = (low + high) / 2;

            long sum = 0;
            for (int tree : trees) {
                if (tree > avg) {
                    sum += tree - avg;
                }
            }
            
            if (sum < m) {
                high = avg - 1;
            }
            else{
                result = avg;
                low = avg + 1;
            }
        }

        System.out.println(result);
        
    }
}