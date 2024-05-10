import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, k;
    static int[] characters;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        characters = new int[n];

        for (int i = 0; i < n; i++) {
            characters[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(characters);

        int low = 0;
        int high = Integer.MAX_VALUE;
        int best = 0;
        
        while (low <= high) {
            
            int mid = (low + high) / 2;

            if (canLevelUp(mid)) {
                best = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        System.out.println(best);
    }

    static boolean canLevelUp(int mid) {
        int total = 0;

        for (int v : characters) {
            if (v < mid) {
                total += mid - v;
                if (total > k) {
                    return false;
                }
            }
        }
        return true;
    }
}