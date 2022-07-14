class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] xList = new int[10];
        int[] yList = new int[10];

        for(int i=0;i<X.length();i++) {
            int num = X.charAt(i)-'0';
            xList[num]++;
        }

        for(int i=0;i<Y.length();i++) {
            int num = Y.charAt(i)-'0';
            yList[num]++;
        }

        for(int i=9;i>=0;i--) {
            int min = Math.min(xList[i], yList[i]);
            if(min > 0) {
                String str = i + "";
                str = str.repeat(min);
                answer += str;
            }
        }

        if(answer == "") answer = "-1";
        if(answer.charAt(0) == '0') answer = "0";
        return answer;
    }
}
