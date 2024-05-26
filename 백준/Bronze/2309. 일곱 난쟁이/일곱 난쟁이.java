import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] n = new int[9];

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int num = sc.nextInt();
            n[i] = num;
            sum += num;
        }

        Arrays.sort(n);


        int target = sum - 100;

        int[] spy = new int[2];
        
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (n[i] + n[j] == target) {
                    spy[0] = n[i];
                    spy[1] = n[j];
                } 
            }
        }


        for (int i = 0; i < 9; i++) {
            if (spy[0] != n[i] && spy[1] != n[i]) {
                System.out.println(n[i]);
            }
        }
        
    }
}