import java.util.*;
class Point implements Comparable<Point>{
    int idx, weight;
    Point(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Point p) {
        return this.weight - p.weight;
    }
}
class Solution {
    int N;
    ArrayList<ArrayList<Point>> list = new ArrayList<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        N = n;
        
        for(int i=0;i<=n;i++) {
            list.add(new ArrayList<Point>());
        }
        
        for(int i=0;i<fares.length;i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int w = fares[i][2];
            
            list.get(start).add(new Point(end, w));
            list.get(end).add(new Point(start, w));
        }
        
        int[] startA = new int[N+1];
        int[] startB = new int[N+1];
        int[] start = new int[N+1];
        
        Arrays.fill(startA, Integer.MAX_VALUE);
        Arrays.fill(startB, Integer.MAX_VALUE);
        Arrays.fill(start, Integer.MAX_VALUE);
        
        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        start = dijkstra(s, start);
        
        for(int i=1;i<=N;i++) {
            answer = Math.min(answer, startA[i] + startB[i]+start[i]);
        }
        
        return answer;
    }
    
    public int[] dijkstra(int start, int[] costs) {
        PriorityQueue<Point> queue = new PriorityQueue<Point>();
        queue.add(new Point(start, 0));
        costs[start] = 0;
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            if(p.weight > costs[p.idx]) continue;
            
            ArrayList<Point> points = list.get(p.idx);
            for(Point point : points) {
                int cost = costs[p.idx] + point.weight;
                if(cost < costs[point.idx]) {
                    costs[point.idx] = cost;
                    queue.offer(new Point(point.idx, cost));
                }
            }
            
        }
        
        return costs;
        
    }
}
