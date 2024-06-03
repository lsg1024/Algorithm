import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n;
    static int[][] meetings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        meetings = new int[n][2];

        for (int i = 0; i < n; i++) {            
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings,(p1, p2) -> {
            if (p1[1] == p2[1]) {
                return p1[0] - p2[0];
            }
            return p1[1] - p2[1];
        });

        int count = 0;
        int lastend = 0;

        for (int i = 0; i < n; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            if (start >= lastend) {
                count++;
                lastend = end;
            }
        }

        System.out.println(count);
    }
}