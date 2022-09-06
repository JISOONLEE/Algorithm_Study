import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[] type = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : type) {
            map.put(ch, 0);
        }
        
        for(int i=0;i<survey.length;i++) {
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);
            if(choices[i] == 4) continue;
            if(choices[i] < 4) {
                map.put(a, map.get(a)+score[choices[i]]);
            } else {
                map.put(b, map.get(b)+score[choices[i]]);
            }
        }
        
        for(int i=0;i<8;i+=2) {
            int aNum = map.get(type[i]);
            int bNum = map.get(type[i+1]);
            if(aNum == bNum) answer += type[i]+"";
            else
                answer += aNum > bNum ? type[i]+"" : type[i+1]+"";
        }
        
        return answer;
    }
}
