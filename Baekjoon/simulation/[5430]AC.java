import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 0;tc<T;tc++) {
            String func = br.readLine();
            int N = Integer.parseInt(br.readLine());

            Deque<Integer> que = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            for (int i=0;i<N;i++) {
                que.add(Integer.parseInt(st.nextToken()));
            }

            boolean reverse = false;
            boolean check = false;
            for (int i=0;i<func.length();i++) {
                if (func.charAt(i) == 'R') {
                    reverse = !reverse;
                } else {
                    if (que.size() == 0) {
                        check = true;
                        break;
                    }

                    if (reverse) que.removeLast();
                    else que.removeFirst();
                }
            }

            if (check) {
                sb.append("error"+"\n");
            } else {
                sb.append("[");
                while(!que.isEmpty()) {
                    sb.append((reverse ? que.removeLast() : que.removeFirst()));
                    if (que.size() != 0) sb.append(",");
                }
                sb.append("]"+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
