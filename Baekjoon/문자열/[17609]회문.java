package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_17609_회문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<T;i++) {
            String str = br.readLine();

            if (palindrome(str)) {
                sb.append("0\n");
                continue;
            } else {
                if (pseudoPalindrome(str, 0, str.length()-1)) {
                    sb.append("1\n");
                } else {
                    sb.append("2\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
    private static boolean palindrome(String str) {
        for (int i=0;i<str.length()/2;i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) return false;
        }
        return true;
    }

    private static boolean pseudoPalindrome(String str, int left, int right) {
        while(left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                boolean a = palindrome(str.substring(left+1, right+1));
                boolean b = palindrome(str.substring(left, right));

                if (a | b == true) return true;
                else return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
