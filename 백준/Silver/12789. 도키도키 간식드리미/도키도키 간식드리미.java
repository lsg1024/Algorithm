import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        ArrayList<Integer> line = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            line.add(Integer.parseInt(st.nextToken()));
        }

        Stack<Integer> stack = new Stack<>();

        int index = 0; // 1 ~ n 까지 번호
        int target = 1; // 현재 받을 수 있는 번호
        int count = 0; // n 번까지 받았는지 카운트

        while (true) {

            if (count == n) {
                System.out.println("Nice");
                break;
            }

            if (index < line.size() && line.get(index) == target) { // 번호가 현재 받을 수 있는 번호와 일치
                index++;
                count++;
                target++;
            } 
            else if (!stack.isEmpty() && stack.peek() == target) { // 스택에서 꺼낼 수 있는 경우
                stack.pop();
                count++;
                target++;
            } 
            else if (index < line.size()) { // 번호가 일치하지 않는 경우
                stack.push(line.get(index));
                index++;
            } 
            else { // 더 이상 처리할 번호가 없는 경우
                System.out.println("Sad");
                break;
            }
        }
    }
}