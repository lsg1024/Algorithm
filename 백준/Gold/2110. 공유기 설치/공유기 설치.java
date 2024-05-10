import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, c;
    static int[] houses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        houses = new int[n];

        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int low = 1;
        int high = houses[n - 1] - houses[0];
        int best = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (canRouting(mid)) {
                best = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        System.out.println(best);
    }

    static boolean canRouting(int rounting) {
        int count = 1;
        int firsthouse = houses[0];
        
        for (int i = 1; i < n; i++) {
            if (houses[i] - firsthouse >= rounting) {
                count++;
                firsthouse = houses[i];
                if (count >= c) {
                    return true;
                }
            }
        }
        return false;
    }
}