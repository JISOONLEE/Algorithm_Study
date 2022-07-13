import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_12852_1로만들기2 {
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] count = new int[N+1];
        int[] path = new int[N+1];
        Arrays.fill(count, Integer.MAX_VALUE);

        count[1] = 0;

        for (int i=2;i<=N;i++) {
            if (i%3 == 0) {
                if (count[i/3] + 1 < count[i]) {
                    count[i] = count[i/3]+1;
                    path[i] = i/3;
                }
            }

            if (i%2 == 0) {
                if (count[i/2] + 1 < count[i]) {
                    count[i] = count[i/2]+1;
                    path[i] = i/2;
                }
            }

            if (count[i-1] + 1 < count[i]) {
                count[i] = count[i-1]+1;
                path[i] = i-1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count[N] +"\n");

        while(N > 0) {
            sb.append(N + " ");
            N = path[N];
        }
        System.out.println(sb.toString());
    }
}
