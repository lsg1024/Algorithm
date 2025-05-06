import java.util.*;

class Food {
    int time;
    int index;

    Food(int time, int index) {
        this.time = time;
        this.index = index;
    }
}

class Solution {

    public int solution(int[] food_times, long k) {
        int n = food_times.length;
        long left = 0;
        long right = Long.MAX_VALUE;
        long timeSpent = 0;
        long targetTime = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int t : food_times) {
                sum += Math.min(mid, t);
            }

            if (sum <= k) {
                targetTime = mid;
                timeSpent = sum;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        List<Food> remaining = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (food_times[i] > targetTime) {
                remaining.add(new Food(food_times[i], i + 1));
            }
        }

        if (remaining.isEmpty()) return -1;

        remaining.sort(Comparator.comparingInt(f -> f.index));

        long idx = (k - timeSpent) % remaining.size();
        return remaining.get((int) idx).index;
    }
}
