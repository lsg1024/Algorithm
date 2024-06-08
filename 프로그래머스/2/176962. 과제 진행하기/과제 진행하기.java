import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        
        ArrayList<String> result = new ArrayList<>();
        Stack<String[]> stack = new Stack<>();
        
        // 시간 순 정렬
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return convertToMinutes(o1[1]) - convertToMinutes(o2[1]);
            }
        });
        
        for (int i = 0; i < plans.length - 1; i++) {
            int currentEndTime = convertToMinutes(plans[i][1]) + Integer.parseInt(plans[i][2]);
            int nextStartTime = convertToMinutes(plans[i + 1][1]);
            int remainingTime = currentEndTime - nextStartTime;
            
            System.out.println(remainingTime);
            
            if (remainingTime <= 0) {
                
                result.add(plans[i][0]);
                if (remainingTime < 0 && !stack.isEmpty()) {
                
                    int availableTime = -remainingTime;
                    while (!stack.isEmpty() && availableTime > 0) {
                        String[] lastPlan = stack.pop();
                        int lastPlanTime = Integer.parseInt(lastPlan[2]);
                        if (availableTime >= lastPlanTime) {
                            result.add(lastPlan[0]);
                            availableTime -= lastPlanTime;
                        } else {
                            lastPlan[2] = Integer.toString(lastPlanTime - availableTime);
                            stack.push(lastPlan);
                            availableTime = 0;
                        }
                    }
                }
            } else {
                plans[i][2] = Integer.toString(remainingTime);
                stack.push(plans[i]);
            }
        }
    
        result.add(plans[plans.length - 1][0]);
        
        while (!stack.isEmpty()) {
            result.add(stack.pop()[0]);
        }
        
        return result.toArray(new String[result.size()]);
    }
    
    private static int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}