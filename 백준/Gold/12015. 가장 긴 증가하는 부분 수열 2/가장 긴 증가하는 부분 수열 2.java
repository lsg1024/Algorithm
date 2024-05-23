import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int n;
    static int[] a, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        a = new int[n];
        result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        result[0] = a[0];
        int length = 1;

        for (int i = 1; i < n; i++) {
            int num = a[i];

            if (result[length - 1] < num) {
                result[length] = num;
                length++;
            }
            else {
                int low = 0;
                int high = length;

                while (low < high) {
                    int mid = (low + high) / 2;

                    if (result[mid] < num) {
                        low = mid+ 1;
                    } 
                    else {
                        high = mid;
                    }
                }
                result[low] = num;
            }
        }

        System.out.println(length);
        
    }
}