import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2293_동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int[] dp = new int[k+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for(int j=arr[i];j<=k;j++)
                dp[j] += dp[j-arr[i]];
        }
        System.out.println(dp[k]);

    }
}
