import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        StringBuilder result = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 나무의 개수
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                arr[n] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr); // 나무 높이 정렬

            int maxDiff = 0;
            for (int i = 2; i < N; i++) {
                maxDiff = Math.max(maxDiff, Math.abs(arr[i] - arr[i - 2]));
            }
            result.append(maxDiff).append("\n");
        }
        System.out.print(result);
    }
}
