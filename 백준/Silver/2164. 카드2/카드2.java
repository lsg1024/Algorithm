import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();

        int input = sc.nextInt();

        for (int i = 1; i <= input; i++) {
            q.offer(i);
        }

        while (q.size() != 1) {
            q.poll();
            Integer move_back = q.poll();
            q.offer(move_back);
        }

        System.out.println(q.poll());
    }
}