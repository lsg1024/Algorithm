import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> L = new ArrayList<>();
        for (int num : arr) {
            if (L.size() == 0 || num > L.get(L.size() - 1)) {
                L.add(num);
            } else {
                int pos = Collections.binarySearch(L, num);
                if (pos < 0) {
                    pos = -pos - 1; 
                }
                L.set(pos, num);
            }
        }

        System.out.println(L.size());
    }
}
