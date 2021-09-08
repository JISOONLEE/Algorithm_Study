class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if(s.length() == 1)
            return 1;
        String temp = "";
        for(int i=1;i<s.length()/2+1;i++) {
            int count = 1;
            int slen = s.length();
            for(int j = i;j<=s.length();j+=i) {
                if(temp.equals(s.substring(j-i, j))) {
                    count++;
                }
                else {
                    if(count>1) {
                        slen-=i*(count-1);
                        slen+=(int)(Math.log10(count)+1);
                        count=1;
                    }
                }  
                temp = s.substring(j-i, j);
            }
            if(count > 1){
                slen-=i*(count-1);
                slen+=(int)(Math.log10(count)+1);
            }
            answer = Math.min(answer, slen);
        }
        return answer;
    }
}
