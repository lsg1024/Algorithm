import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static long X, Y;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        int target = (int) (Y * 100 / X);

        if (target >= 99) {
            System.out.println(-1);
            return;
        }    
        
        int left = 0;
        int right = 1000000000;

        while (left <= right) {
            int mid = (int) ((left + right) / 2);
            int Z = (int) (((Y + mid) * 100) / (X + mid));
            
            if (target < Z) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}