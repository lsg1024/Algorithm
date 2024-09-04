import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int n, m, k;
    static int[][] f_list, s_list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        f_list = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                f_list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        s_list = new int[m][k];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                s_list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] r_list = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int t = 0; t < m; t++) {
                    r_list[i][j] += f_list[i][t] * s_list[t][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(r_list[i][j] + " ");
            }
            System.out.println();
        }

        
    }
}