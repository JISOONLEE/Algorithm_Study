import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1157_단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] alpa = new int[26];

        for(int i=0;i<input.length();i++) {
            if('A'<=input.charAt(i) && input.charAt(i)<='Z') {
                alpa[input.charAt(i) - 'A']++;
            } else {
                alpa[input.charAt(i) - 'a']++;
            }
        }

        int max = 0;
        char ch = '?';
        for(int i=0;i<26;i++) {
            if(max < alpa[i]) {
                max = alpa[i];
                ch = (char) (i+65);
            } else if(max == alpa[i]) {
                ch = '?';
            }
        }

        System.out.println(ch);
    }
}
