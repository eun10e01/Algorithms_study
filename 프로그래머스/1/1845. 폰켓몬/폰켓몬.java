import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> mon = new HashSet<>();
        
        for(int i : nums){
            mon.add(i);
        }
        
        int numSize = nums.length;
        int monSize = mon.size();
        
        if(monSize <= numSize / 2){
            answer = monSize;
        }
        else{
            answer = numSize / 2;
        }
        
        return answer;
    }
}