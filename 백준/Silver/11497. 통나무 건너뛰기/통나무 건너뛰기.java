import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] arr;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            
            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                arr[n] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int[] trees = new int[N];

            int mid = N / 2;
            int left = mid;
            int right = mid;

            boolean bool = true;
            while (N-- > 0) {

                if (bool) {
                    bool = false;
                    trees[right] = arr[N];
                    left--;
                } else {
                    bool = true;
                    trees[left] = arr[N];
                    right++;
                }
                
            }

            int min = Math.abs(trees[trees.length - 1] - trees[0]);
            for (int i = 0; i < trees.length - 1; i++) {
                min = Math.max(min, Math.abs(trees[i] - trees[i + 1]));
            }
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
}