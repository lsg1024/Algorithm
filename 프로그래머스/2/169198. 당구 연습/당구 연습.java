class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int j = 0; j < balls.length; j++) {
            int targetX = balls[j][0];
            int targetY = balls[j][1];
            int minDistanceSquared = Integer.MAX_VALUE;
            
            // 4가지 반사 위치 고려
            // 왼쪽 벽에 반사된 경우
            if (startY != targetY || startX < targetX) {
                minDistanceSquared = Math.min(minDistanceSquared, distanceSquared(startX, startY, -targetX, targetY));
            }
            // 오른쪽 벽에 반사된 경우
            if (startY != targetY || startX > targetX) {
                minDistanceSquared = Math.min(minDistanceSquared, distanceSquared(startX, startY, 2 * m - targetX, targetY));
            }
            // 아래쪽 벽에 반사된 경우
            if (startX != targetX || startY < targetY) {
                minDistanceSquared = Math.min(minDistanceSquared, distanceSquared(startX, startY, targetX, -targetY));
            }
            // 위쪽 벽에 반사된 경우
            if (startX != targetX || startY > targetY) {
                minDistanceSquared = Math.min(minDistanceSquared, distanceSquared(startX, startY, targetX, 2 * n - targetY));
            }
            
            answer[j] = minDistanceSquared;
        }
        
        return answer;
    }

    private int distanceSquared(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}
