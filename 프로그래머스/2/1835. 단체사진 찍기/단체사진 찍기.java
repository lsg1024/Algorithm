import java.util.*;

class Solution {
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int count;  // 조건을 만족하는 배치 수
    static List<Condition> conditions;

    // 조건을 저장하는 클래스
    static class Condition {
        char first;
        char second;
        char operator;
        int distance;

        Condition(char first, char second, char operator, int distance) {
            this.first = first;
            this.second = second;
            this.operator = operator;
            this.distance = distance;
        }
    }

    public int solution(int n, String[] data) {
        count = 0;
        conditions = new ArrayList<>();

        for (String condition : data) {
            char first = condition.charAt(0);
            char second = condition.charAt(2);
            char operator = condition.charAt(3);
            int distance = condition.charAt(4) - '0';
            conditions.add(new Condition(first, second, operator, distance));
        }

        // 사용 여부를 추적하는 배열
        boolean[] used = new boolean[8];

        // DFS 탐색 시작
        dfs(new ArrayList<>(), used);
        return count;
    }

    // DFS 탐색 함수
    public void dfs(List<Character> currentOrder, boolean[] used) {

        if (currentOrder.size() == 8) {
            if (isValid(currentOrder)) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!used[i]) {

                currentOrder.add(friends[i]);
                used[i] = true;

                dfs(currentOrder, used);

                currentOrder.remove(currentOrder.size() - 1);
                used[i] = false;
            }
        }
    }

    public boolean isValid(List<Character> currentOrder) {
        for (Condition condition : conditions) {
            int pos1 = currentOrder.indexOf(condition.first);
            int pos2 = currentOrder.indexOf(condition.second);
            int actualDistance = Math.abs(pos1 - pos2) - 1;

            if (condition.operator == '=') {
                if (actualDistance != condition.distance) return false;
            } else if (condition.operator == '<') {
                if (actualDistance >= condition.distance) return false;
            } else if (condition.operator == '>') {
                if (actualDistance <= condition.distance) return false;
            }
        }
        return true;
    }
}
