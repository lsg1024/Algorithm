import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static String[] mbti;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            if (N >= 33) {
                System.out.println(0);
                continue;
            }
            
            mbti = new String[N];

            for (int j = 0; j < N; j++) {
                mbti[j] = st.nextToken();
            }

            int minDist = calculateMinDistance(N);
            System.out.println(minDist);
        
        }
        
    }

    static int calculateDistance(String a, String b) {
        int distence = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                distence++;
            }
        }

        return distence;
    }

    static int calculateMinDistance(int N) {

        int minDist = Integer.MAX_VALUE;
        
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {

                    int distSum = calculateDistance(mbti[i], mbti[j]) +
                        calculateDistance(mbti[i], mbti[k]) +
                        calculateDistance(mbti[k], mbti[j]);

                    minDist = Math.min(minDist, distSum);
                    if (minDist == 0) break;
                }
            }
        }

        return minDist;
    }
    
}