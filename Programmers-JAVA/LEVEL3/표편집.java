import java.util.*;
class Solution {
    int cursor, N;
    Stack<Integer> stack;
    public String solution(int n, int k, String[] cmd) {
        N = n; cursor = k;
        stack = new Stack<>();
        
        for(int i=0;i<cmd.length;i++) {
            String[] str = cmd[i].split(" ");
            char ch = str[0].charAt(0);
            
            if(ch == 'D') {
                int num = Integer.parseInt(str[1]);
                cursor += num;
            } else if (ch == 'U') {
                int num = Integer.parseInt(str[1]);
                cursor -= num;
            } else if (ch == 'C') {
                N--;
                stack.push(cursor);
                if(cursor == N) cursor--;
            } else {
                N++;
                int num = stack.pop();
                if(cursor >= num) cursor++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            sb.append('O');
        }
        
        while(!stack.isEmpty()) {
            sb.insert(stack.pop().intValue(), 'X');
        }
        
        return sb.toString();
    }
}
