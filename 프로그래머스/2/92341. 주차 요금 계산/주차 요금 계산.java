import java.util.*;

class Solution {
    
    static int basic_time, basic_fee, charge_time, charge_fee;
    static HashMap<Integer, Integer> parking = new HashMap<>();
    static TreeMap<Integer, Integer> parking_bill = new TreeMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        
        basic_time = fees[0];
        basic_fee = fees[1];
        charge_time = fees[2];
        charge_fee = fees[3];
        
        //누적시간 계산
        InAndOut(fees, records);
        
        //요금 계산
        answer = new int[parking_bill.size()];
        int idx = 0;
        for (Map.Entry<Integer, Integer> bill : parking_bill.entrySet()) {
            answer[idx] = Pay(bill.getValue());
            idx++;
        }
        
        return answer;
    }
    
    static void InAndOut(int[] fees, String[] records) {
        
        for (String record : records) {
            String[] firstSplit = record.split(":");
            String time = firstSplit[0];
            
            String[] secoundSplit = firstSplit[1].split(" ");
            String minute = secoundSplit[0];
            Integer carNumber = Integer.parseInt(secoundSplit[1]);
            String type = secoundSplit[2];
            
            Integer total_time = Integer.parseInt(time) * 60 + Integer.parseInt(minute);
            
            if (type.equals("IN")) {
                parking.put(carNumber, total_time);
            }
            else {
                // 출차 차량 누적 시간
                Integer start_time = parking.get(carNumber);
                Total_Time(start_time, total_time, carNumber);
                parking.remove(carNumber);
            }
            
        }
        
        // 24시간 이후에도 존재하는 차량 출차
        for (Map.Entry<Integer, Integer> entry : parking.entrySet()) {
            Total_Time(entry.getValue(), 1439, entry.getKey());
        }
        
        return;
        
    }
    
    // 누적 시간 구하기
    static void Total_Time(Integer start, Integer end, Integer carNumber) {
        int using_time = end - start;
        
        parking_bill.put(carNumber, parking_bill.getOrDefault(carNumber, 0) + using_time);
        
        return;
        
    }
    
    static int Pay(int using_time) {
        
        // 기본 요금 초과 여부
        if (using_time > basic_time) {
            
            // 단위 시간을 초과하지 않는 경우 반올림
            int upper = 0;
            if ((using_time - basic_time) % charge_time != 0) {
                upper = 1;
            }
            
            return basic_fee + ((using_time - basic_time) / charge_time + upper) * charge_fee;
        }
        
        // 기본 요금 이하
        return basic_fee;
        
    }
    
}