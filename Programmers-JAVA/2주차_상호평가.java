import java.util.*;
import java.lang.*;
class Solution {
    String answer = "";
    public String solution(int[][] scores) {
        for(int i=0;i<scores.length;i++) {
            int sum = 0;
            int myMax = scores[i][i];
            int myMin = scores[i][i];
            int cnt = 0;
            for(int j=0;j<scores[i].length;j++) {
                if(i==j) continue;
                if(scores[i][i] == scores[j][i]) cnt++;
                myMax = Math.max(myMax, scores[j][i]);
                myMin = Math.min(myMin, scores[j][i]);
                sum += scores[j][i];
            }
            if(myMax == scores[i][i] || myMin == scores[i][i]) {
                if(cnt == 0) { //최소나 최대 중 유일한 값일때
                    sum /= (scores.length-1);
                } else { // 최소나 최대이지만 유일하진 않을때
                    sum += scores[i][i];
                    sum /= scores.length;
                }
            } else {
                sum+=scores[i][i];
                sum/=scores.length;
            }

            score(sum);
        }
        return answer;
    }
    private void score(int sum) {
        if(sum >= 90) answer+="A";
        else if(sum>= 80) answer+="B";
        else if(sum>= 70) answer+="C";
        else if(sum>= 50) answer+="D";
        else answer+="F";
    }
}
