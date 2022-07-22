import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int idx = 0;
        int now = 0;
        while(count < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= now) {
                queue.add(jobs[idx++]);
            }
            
            if(queue.isEmpty()) {
                now = jobs[idx][0];
            } else {
                int[] temp = queue.poll();
                answer += now + temp[1] - temp[0];
                now += temp[1];
                count++;
            }
        }
        
        return answer/jobs.length;
    }
}
