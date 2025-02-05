import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            String[] numbers = new String[N];

            for (int i = 0; i < N; i++) {
                numbers[i] = br.readLine();
            }

            Arrays.sort(numbers);

            boolean containNumber = false;
            for (int i = 1; i < N; i++) {
                if (numbers[i].startsWith(numbers[i - 1])) {
                    containNumber = true;
                    break;
                }
            }

            if (containNumber) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
            
        }
    }
}