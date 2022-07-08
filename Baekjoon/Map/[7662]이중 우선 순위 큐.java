import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0;tc<T;tc++) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                String calc = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                
                if (calc.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0)+1);
                } else {
                    if (map.isEmpty()) continue;
                    if (num > 0) {
                        int max = map.lastKey();
                        int cnt = map.get(max);
                        if (cnt == 1) map.remove(max);
                        else map.put(max, cnt-1);
                    } else {
                        int min = map.firstKey();
                        int cnt = map.get(min);
                        if (cnt == 1) map.remove(min);
                        else map.put(min, cnt-1);
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY" + "\n");
            } else {
                sb.append(map.lastKey() +" "+map.firstKey()+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
