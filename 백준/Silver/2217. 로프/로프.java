import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(weights);

        int maxWeight = 0;
        for (int i = 0; i < N; i++) {
            maxWeight = Math.max(weights[i] * (N - i), maxWeight);
        }

        System.out.println(maxWeight);
    }
}