import java.util.*;
class Solution {
    private HashMap<Integer, ArrayList<Integer>> map;
    private int[] infos;
    private int maxSheep;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        map = new HashMap<>();
        infos = info;
        
        for(int[] e : edges) {
            if(!map.containsKey(e[0])) map.put(e[0], new ArrayList<>());
            map.get(e[0]).add(e[1]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, 0, 0, list);
        
        return maxSheep;
    }
    
    private void dfs(int idx, int sheep, int wolf, ArrayList<Integer> list) {
        if(infos[idx] == 0) sheep++;
        else wolf++;
        
        if(sheep <= wolf) return;
        maxSheep = Math.max(maxSheep, sheep);
        
        ArrayList<Integer> temp = new ArrayList<>();
        temp.addAll(list);
        if(map.containsKey(idx)) temp.addAll(map.get(idx));
        temp.remove(Integer.valueOf(idx));
        
        for(int i : temp) {
            dfs(i, sheep, wolf, temp);
        }
        
        return;
        
    }
}
