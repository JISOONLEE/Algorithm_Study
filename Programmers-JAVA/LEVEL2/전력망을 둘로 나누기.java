import java.util.*;

class Solution {
    ArrayList<Integer>[] list;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        list = new ArrayList[n+1];
        for(int i=0;i<=n;i++) {
            list[i] = new ArrayList<Integer>();
        }
        
        for(int i=0;i<wires.length;i++) {
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }
        
        for(int i=0;i<wires.length;i++) {
            int a = bfs(wires[i][0], wires[i][1], n);
            int b = bfs(wires[i][1], wires[i][0], n);
            
            answer = Math.min(answer, Math.abs(a-b));
        }
        
        return answer;
    }
    
    private int bfs(int a, int b, int n) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;
        int cnt = 0;
        
        while(!queue.isEmpty()) {
            int num = queue.poll();
            cnt++;
            for(int end : list[num]) {
                if(!visited[end] && end != b) {
                    queue.add(end);
                    visited[end] = true;
                }
            }
        }
        
        return cnt;
    }
}
