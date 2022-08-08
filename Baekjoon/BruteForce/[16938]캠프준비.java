import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16938_캠프준비 {
    private static int N, answer;
    private static long L, R, X;
    private static long[] A, list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Long.parseLong(st.nextToken());
        R = Long.parseLong(st.nextToken());
        X = Long.parseLong(st.nextToken());
        A = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        for (int i=2;i<=N;i++) {
            list = new long[i];
            comb(0, 0, i);
        }
        System.out.println(answer);
    }
    private static void comb(int idx, int cnt, int M) {
        if (cnt == M) {
            long sum = Arrays.stream(list).sum();
            if (sum >= L && sum <= R) {
                long max = Arrays.stream(list).max().getAsLong();
                long min = Arrays.stream(list).min().getAsLong();
                if (max - min >= X) answer++;
            }

            return;
        }
        for (int i=idx;i<N;i++) {
            list[cnt] = A[i];
            comb(i+1, cnt+1, M);
        }
    }
}
