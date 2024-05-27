import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, max;
    static int[] numbers, arr;
    static boolean[] isChecked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        numbers = new int[n];
        arr = new int[n];
        isChecked = new boolean[n];

        max = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
        
    }

    static void dfs(int idx) {
        
        if (idx == n) {
            int value = 0;
            for (int i = 1; i < n; i++) {
                value += Math.abs(arr[i - 1] - arr[i]);
            }
            max = Math.max(max, value);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isChecked[i]) {
                continue;
            }

            isChecked[i] = true;

            arr[idx] = numbers[i];
            dfs(idx + 1);

            isChecked[i] = false;
        }
    }
    
}