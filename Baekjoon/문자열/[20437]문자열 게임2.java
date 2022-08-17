package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_20437_문자열게임2 {
    private static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            if (K == 1) {
                System.out.println("1 1");
                continue;
            }
            solve(W, K);
        }
    }

    private static void solve(String W, int K) {
        int[] arr = new int[26];
        for (int i=0;i<W.length();i++) {
            arr[W.charAt(i)-'a']++;
        }

        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i=0;i<W.length();i++) {
            if (arr[W.charAt(i)-'a'] < K) continue;

            int cnt = 1;
            for (int j = i+1;j<W.length();j++) {
                if (W.charAt(i) == W.charAt(j)) cnt++;
                if (cnt == K) {
                    min = Math.min(min, j - i + 1);
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }

        if (min == Integer.MAX_VALUE || max == -1) System.out.println(-1);
        else System.out.println(min+" "+max);
    }
}
