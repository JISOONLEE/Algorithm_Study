import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_9934_완전이진트리 {
    static int K;
    static int[] nums;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        nums = new int[(int)Math.pow(2, K)-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<nums.length;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        for(int i=0;i<K;i++) {
            list.add(new ArrayList<>());
        }

        solve(0, nums.length-1, 0);

        for(int i=0;i<list.size();i++) {
            ArrayList al = list.get(i);
            for (int j=0;j<al.size();j++) {
                System.out.print(al.get(j)+" ");
            }
            System.out.println();
        }
    }

    public static void solve(int s, int e, int floor) {
        if(floor == K) return;

        int mid = (s+e)/2;
        list.get(floor).add(nums[mid]);

        solve(s, mid - 1, floor + 1);
        solve(mid + 1, e, floor + 1);

    }
}
