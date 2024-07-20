import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        ArrayList<String> option = new ArrayList<>(Arrays.asList("code", "date", "maximum", "remain"));
        ArrayList<int[]> filteredData = new ArrayList<>();
        
        // ext - ext_value
        int ext_index = option.indexOf(ext);
        for (int i = 0; i < data.length; i++) {
            int target = data[i][ext_index];
            if (target < val_ext) {
                filteredData.add(data[i]);
            }
        }
        int[][] new_data = filteredData.toArray(new int[filteredData.size()][]);
        
        int sortBy_index = option.indexOf(sort_by);
        Arrays.sort(new_data, (o1, o2) -> Integer.compare(o1[sortBy_index], o2[sortBy_index]));
        
        return new_data;
    }
}