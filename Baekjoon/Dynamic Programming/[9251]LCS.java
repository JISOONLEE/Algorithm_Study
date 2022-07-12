import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9251_LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for (int i=0;i<str1.length();i++) {
            char ch1 = str1.charAt(i);
            for (int j=0;j<str2.length();j++) {
                char ch2 = str2.charAt(j);

                if (ch1 == ch2) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);
    }
}
