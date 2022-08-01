import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1062_가르침 {
    private static int N, K, ans;
    private static String[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int mask = 0;
        words = new String[N];
        if (K < 5) {
            System.out.println(0);
        } else {
            mask |= 1 << (int)'a'-96;
            System.out.println(mask);
            mask |= 1 << (int)'c'-96;
            System.out.println(mask);
            mask |= 1 << (int)'i'-96;
            System.out.println(mask);
            mask |= 1 << (int)'n'-96;
            System.out.println(mask);
            mask |= 1 << (int)'t'-96;
            System.out.println(mask);

            for (int i=0;i<N;i++) {
                String str = br.readLine();
                str = str.replaceAll("[a, c, i, n, t]", "");
                words[i] = str;
            }

            comb(0, 5, mask);
            System.out.println(ans);
        }
    }

    private static void comb(int idx, int cnt, int mask) {
        if (cnt == K) {
            int count = 0;
            for (int i=0;i<N;i++) {
                boolean flag = false;
                for (int j=0;j<words[i].length();j++){
                    if ((mask & (1<<words[i].charAt(j)-96)) == 0) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) count++;
            }
            ans = Math.max(ans, count);
            return;
        }

        for (int i=idx;i<27;i++) {
            if ((mask & (1<<i))==0){
                comb(i+1, cnt+1, mask|(1<<i));
            }
        }
    }
}
