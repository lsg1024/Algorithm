import java.util.*;

class Solution {
    public String[] solution(String[] files) {

        String[][] new_files = new String[files.length][4];
        
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            
            int head_index = 0;
            int number_index = 0;
            for (int j = 0; j < file.length(); j++) {
                if (Character.isDigit(file.charAt(j))) {
                    
                    head_index = j;
                    break;

                }
            }
            
            for (int j = head_index; j < file.length() && j < head_index + 5; j++) {
                if (!Character.isDigit(file.charAt(j))) {
                    number_index = j;
                    break;
                }
                number_index = j + 1;
            }
            
            String head = file.substring(0, head_index);
            String number = file.substring(head_index, number_index);
            String tail = file.substring(number_index);
            
            new_files[i][0] = head;
            new_files[i][1] = number;
            new_files[i][2] = tail;
            new_files[i][3] = file;
        }
        
        Arrays.sort(new_files, (o1, o2) -> {
            int headCompare = o1[0].toLowerCase().compareTo(o2[0].toLowerCase());
            
            if (headCompare != 0) {
                return headCompare;
            }
            
            int numA = Integer.parseInt(o1[1]);
            int numB = Integer.parseInt(o2[1]);
            
            return numA - numB;
            
        });
        
        
        String[] answer = new String[files.length];
        
        for (int i = 0; i < files.length; i++) {
            answer[i] = new_files[i][3];
        }
        
        return answer;
    }
}