import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int zero = 0;
        int match = 0;
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        for(int lotto: lottos) {
            if(lotto == 0) zero++;
            else {
                for(int win_num: win_nums) {
                    if(lotto == win_num)
                        match++;
                }
            }
        }
        answer = new int[2];
        answer[0] = (zero+match)==0?6:7-(zero+match);
        answer[1] = match==0?6:7-match;
        
        System.out.println(zero+", "+match);
        return answer;
    }
}
