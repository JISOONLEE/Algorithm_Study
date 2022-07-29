import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_8982_수족관1 {
    private static final int MAX = 40001;
    private static int N, K, len;
    private static int[] depth, height;
    private static class Point {
        int idx, dep;
        Point(int idx, int dep) {
            this.idx = idx;
            this.dep = dep;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        depth = new int[MAX];
        height = new int[MAX];
        br.readLine();
        for (int i=0;i<N/2-1;i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j=x1;j<x2;j++) {
                depth[j] = y1;
            }
            len = x2 - 1;
        }
        br.readLine();

        K = Integer.parseInt(br.readLine());
        Point[] points = new Point[K];
        for (int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int dep = Integer.parseInt(st.nextToken());

            points[i] = new Point(idx, dep);
        }

        for (Point p : points) {
            int temp = p.dep;
            for (int i = p.idx;i>=0;i--) {
                temp = temp > depth[i] ? depth[i] : temp;
                height[i] = temp > height[i] ? temp : height[i];
            }

            temp = p.dep;
            for (int i = p.idx;i<=len;i++) {
                temp = temp > depth[i] ? depth[i] : temp;
                height[i] = temp > height[i] ? temp : height[i];
            }
        }

        int answer = 0;
        for (int i=0;i<=len;i++) {
            answer += depth[i] - height[i];
        }

        System.out.println(answer);
    }
}
