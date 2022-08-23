package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    private static HashMap<String, String> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        map = new HashMap<>();
        make_date();

        ArrayList<String> answer = new ArrayList<>();
        for (String date : map.keySet()) {
            boolean check = false;
            for (int i=0;i<8;i++) {
                if (date.charAt(i) != input.charAt(i) && input.charAt(i)!='?') {
                    check = true;
                    break;
                }
            }
            if (check) continue;
            else answer.add(map.get(date));
        }

        for (int i=0;i<answer.size();i++)
            System.out.println(answer.get(i));
    }

    private static void make_date() {
        int[] dates = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int Y = 1950, M = 1, D = 1;

        while(Y < 2050) {
            String date1 = String.format("%d%02d%02d", Y, M, D);//YYYYMMDD;
            String date2 = String.format("%02d%02d%d", M, D, Y); //MMDDYYYY;
            String date3 = String.format("%02d%02d%d", D, M, Y); //DDMMYYYY;
            map.put(date1, date1);
            map.put(date2, date1);
            map.put(date3, date1);

            D += 1;
            if (D > dates[M]) {
                if (Y % 4 == 0 && M == 2 && D == 29) continue;
                D = 1;
                M += 1;
            }

            if (M > 12) {
                Y += 1;
                M = 1;
            }
        }
    }
}
