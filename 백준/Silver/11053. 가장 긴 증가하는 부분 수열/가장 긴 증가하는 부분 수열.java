import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int a;
    static int[] a_list, LTS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = Integer.parseInt(br.readLine());

        a_list = new int[a];
        LTS = new int[a];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < a; i++) {
            a_list[i] = Integer.parseInt(st.nextToken());
        }

        LTS[0] = a_list[0];
        int length = 1;

        for (int i = 1; i < a; i++) {
            int key = a_list[i];

            if (LTS[length - 1] < key) {
                length++;
                LTS[length - 1] = key;
            }
            else {
                int low = 0;
                int high = length;
                while (low < high) {
                    int mid = (low + high) / 2;

                    if (LTS[mid] < key) {
                        low = mid + 1;
                    }
                    else {
                        high = mid;
                    }
                }
                LTS[low] = key;
            }
        }

        System.out.println(length);
        
    }
}