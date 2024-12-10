import java.util.*;

class Solution {
    static final int INITIAL_START_TIME = 540; // 09:00
    static int START_TIME;

    public String solution(int n, int t, int m, String[] timetable) {
        START_TIME = INITIAL_START_TIME;
        String answer = "";

        // 시간표를 분 단위로 변환하고 정렬
        List<Integer> arr = new ArrayList<>();
        for (String times : timetable) {
            String[] time = times.split(":");
            int minutes = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            arr.add(minutes);
        }
        Collections.sort(arr);

        // 셔틀 운행 시작
        for (int i = 0; i < n; i++) {
            int canMove = m; // 셔틀당 최대 탑승 인원
            int lastBoardingTime = -1; // 마지막 탑승 시간 기록

            // 현재 셔틀에 탑승 가능한 승객 처리
            while (canMove > 0 && !arr.isEmpty() && arr.get(0) <= START_TIME) {
                lastBoardingTime = arr.remove(0);
                canMove--;
            }

            // 마지막 셔틀 처리
            if (i == n - 1) {
                if (canMove > 0) {
                    // 자리가 남는 경우, 셔틀 도착 시간 반환
                    answer = formatTime(START_TIME);
                } else {
                    // 자리가 없는 경우, 마지막 탑승 가능 시간보다 1분 일찍 도착
                    answer = formatTime(lastBoardingTime - 1);
                }
                break;
            }

            // 다음 셔틀 시간 갱신
            START_TIME += t;
        }

        return answer;
    }

    // 시간을 "HH:MM" 형식의 문자열로 변환
    private String formatTime(int time) {
        return String.format("%02d:%02d", time / 60, time % 60);
    }
}
