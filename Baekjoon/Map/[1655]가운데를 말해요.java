import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1655_가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxQue = new PriorityQueue<>();
        PriorityQueue<Integer> minQue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());

            if(minQue.size() == maxQue.size()) minQue.offer(num);
            else maxQue.offer(num);

            if (!minQue.isEmpty() && !maxQue.isEmpty()) {
                if (maxQue.peek() < minQue.peek()) {
                    int temp = minQue.poll();
                    minQue.offer(maxQue.poll());
                    maxQue.offer(temp);
                }
            }
            sb.append(minQue.peek()+"\n");
        }
        System.out.println(sb.toString());
    }
}
