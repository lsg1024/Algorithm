import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        int total = T;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();

            int target = -1;
            HashSet<Integer> history = new HashSet<>();
            for (int w = 0; w < word.length(); w++) {
                int c = word.charAt(w) - 'a';
                if (history.contains(c) && target != c) {
                    total--;
                    break;
                }
                if (!history.contains(c) && target != c) {
                    history.add(c);
                    target = c;
                }
            }
        }
        System.out.println(total);
    }
}