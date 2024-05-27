import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] numbers;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        while (true) {

            int k = sc.nextInt();

            if (k == 0) {
                break;
            }

            numbers = new int[k];
            
            for (int i = 0; i < k; i++) {
                int n = sc.nextInt();
                numbers[i] = n;
            }

            Arrays.sort(numbers);
            
            for (int i = 0; i < k; i++) {
                for (int j = i + 1; j < k; j++) {
                    for (int q = j + 1; q < k; q++) {
                        for (int l = q + 1; l < k; l++) {
                            for (int o = l + 1; o < k; o++)  {
                                for (int p = o + 1; p < k; p++) {
                                    sb.append(numbers[i]).append(" ");
                                    sb.append(numbers[j]).append(" ");
                                    sb.append(numbers[q]).append(" ");
                                    sb.append(numbers[l]).append(" ");
                                    sb.append(numbers[o]).append(" ");
                                    sb.append(numbers[p]).append(" ").append("\n");
                                }
                            }
                        }
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}