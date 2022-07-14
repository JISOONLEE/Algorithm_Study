import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        ArrayList<Integer> nums = new ArrayList<>();
        Stack<Integer> belt = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        belt.add(0);
        stack.add(0);

        for(int i=1;i<=order.length;i++) {
            nums.add(i);
        }

        int idx = 0;
        for(int i=0;i<order.length;i++) {
            boolean check = false;
            while(true) {
                if(idx == nums.size())
                    idx = nums.size()-1;

                int num = nums.get(idx);
                int stackNum = stack.peek();
                if(order[i] != num) {
                    if(order[i] == stackNum) {
                        belt.add(stack.pop());
                        break;
                    } else {
                        if(stackNum != num){
                            stack.add(num);
                            idx++;
                        } else {
                            check = true;
                            break;
                        }
                    }
                } else {
                    belt.add(num);
                    idx++;
                    break;
                }
            }

            if(check)
                break;
        }

        answer = belt.size()-1;
        return answer;
    }
}
