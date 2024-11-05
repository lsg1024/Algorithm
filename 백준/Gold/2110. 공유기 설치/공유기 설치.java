import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, C;
    static int[] houses;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        long low = 1;
        long high = houses[N - 1] - houses[0];
        int best = 0;

        while (low <= high) {

            int mid = (int) (low + high) / 2;

            if (canRoutes(mid)) {
                best = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.print(best);
        
    }

    static boolean canRoutes(int distance) {
        int count = 1;
        int firsthouse = houses[0];

        for (int i = 0; i < N; i++) {
            if (houses[i] - firsthouse >= distance) {
                count++;
                firsthouse = houses[i];
            }

            if (count == C) {
                return true;
            }
        }

        return false;
    }
}