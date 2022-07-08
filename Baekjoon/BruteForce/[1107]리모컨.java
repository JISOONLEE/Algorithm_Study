import java.awt.font.FontRenderContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1107_리모컨 {
    static boolean[] broken = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        if (M > 0)
            st = new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++) {
            int num = Integer.parseInt(st.nextToken());
            broken[num] = true;
        }

        int answer = Math.abs(N - 100);
        int cnt = 0;
        outer : for (int i=0;i<999999;i++) {
            String str = String.valueOf(i);
            for (int j=0;j<str.length();j++) {
                if (broken[str.charAt(j)-'0']) {
                    continue outer;
                }
            }

            cnt = str.length() + Math.abs(N - i);

            if (answer > cnt)
                answer = cnt;
        }

        System.out.println(answer);
    }
}
