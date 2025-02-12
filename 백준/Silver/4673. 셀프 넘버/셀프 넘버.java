import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int max = 10_000;

    public static void main(String[] args) throws IOException {

        boolean[] check = new boolean[max + 1];
        for (int i = 1; i <= max; i++) {
            int n = d(i);

            if (n <= max) {
                check[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= max; i++) {
            if (!check[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    static int d(int number) {
        int sum = number;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}