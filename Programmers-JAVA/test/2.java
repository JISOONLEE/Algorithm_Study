import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<want.length;i++) {
            map.put(want[i], number[i]);
        }

        int idx = 1;
        for(int i=0;i<discount.length;i++) {
            String product = discount[i];
            if(map.containsKey(product)) {
                map.put(product, map.get(product)-1);
            }

            if(idx == 10) {
                boolean check = false;
                for(String key : map.keySet()) {
                    int num1 = map.get(key);
                    if(num1 > 0) {
                        check = true;
                        break;
                    }
                }

                if(!check) {
                    answer++;
                }

                String prod = discount[i-9];
                if(map.containsKey(prod)) {
                    map.put(prod, map.get(prod) + 1);
                    
                }
                idx--;
            }
            idx++;
        }
        return answer;
    }
}
