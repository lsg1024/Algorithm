import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int T, N, M;
    static int[] list;
    static List<Integer> arr = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());

            list = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(list);

            M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                int left = 0;
                int right = N - 1;
                int target = Integer.parseInt(st.nextToken());
                int find = 0;

                while (left <= right) {
                    int mid = (left + right) / 2;
                    
                    if (target == list[mid]) {
                    
                        find = 1;
                        break;
                    }

                    if (target > list[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                    
                }
                sb.append(find).append("\n");
            }

            System.out.print(sb);
        }
    }
}