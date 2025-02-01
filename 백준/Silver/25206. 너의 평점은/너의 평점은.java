import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int count = 0;
        double totalSum = 0.000000;
        double totalScore = 0.000000;
        while (true) {

            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                break;
            }

            if (st.countTokens() > 0) {
                String name = st.nextToken();
                double score = Double.parseDouble(st.nextToken());
                String type = st.nextToken();

                if (type.equals("P")) {
                    continue;
                } else {
                    totalSum += score;
                    if (type.equals("A+")) {
                        totalScore += 4.5 * score;
                    } else if (type.equals("A0")) {
                        totalScore += 4.0 * score;
                    } else if (type.equals("B+")) {
                        totalScore += 3.5 * score;
                    } else if (type.equals("B0")) {
                        totalScore += 3.0 * score;
                    } else if (type.equals("C+")) {
                        totalScore += 2.5 * score;
                    } else if (type.equals("C0")) {
                        totalScore += 2.0 * score;
                    } else if (type.equals("D+")) {
                        totalScore += 1.5 * score;
                    } else if (type.equals("D0")) {
                        totalScore += 1.0 * score;
                    }
                }
            }
            
        }

        System.out.printf("%.6f", totalScore / totalSum);
    }
}