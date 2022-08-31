package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888_연산자끼워넣기 {
    static int N, ansMax, ansMin;
    static int[] A;
    static int[] operator;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        operator = new int[4];

        for (int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<4;i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        ansMax = Integer.MIN_VALUE;
        ansMin = Integer.MAX_VALUE;
        dfs(1, A[0]);
        System.out.println(ansMax);
        System.out.println(ansMin);
    }
    private static void dfs(int idx, int num) {
        if (idx == N) {
            ansMax = Math.max(ansMax, num);
            ansMin = Math.min(ansMin, num);
            return;
        }
        for (int i=0;i<4;i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0 : dfs(idx+1, num + A[idx]); break;
                    case 1 : dfs(idx+1, num - A[idx]); break;
                    case 2 : dfs(idx+1, num * A[idx]); break;
                    case 3 : dfs(idx+1, num / A[idx]); break;
                }

                operator[i]++;
            }
        }
    }
}
