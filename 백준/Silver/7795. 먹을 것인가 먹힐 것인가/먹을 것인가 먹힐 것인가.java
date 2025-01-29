import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                A[n] = Integer.parseInt(st.nextToken());
            }

            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                B[m] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);

            int total = 0;
            for (int n = 0; n < N; n++) {
                int target = A[n];
                
                int left = 0;
                int right = M - 1;
                int mid = 0;
                int count = 0;
                while (left <= right) {
                    mid = (left + right) / 2;
                    
                    if (target <= B[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                        count = mid + 1;
                    }
                }

                total += count;
            }
            
            System.out.println(total);
        }
    }

}