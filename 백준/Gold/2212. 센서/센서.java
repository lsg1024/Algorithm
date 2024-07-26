import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, K, result;
    static int[] SenserList;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        SenserList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            SenserList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(SenserList);

        Integer[] distance = new Integer[N-1];
        for (int i = 0; i < N - 1; i++) {
            distance[i] = SenserList[i + 1] - SenserList[i];
        }

        Arrays.sort(distance, Comparator.reverseOrder());

        for (int i = K - 1; i < distance.length; i++) {
            result += distance[i];
        }

        System.out.println(result);
        
    }
}