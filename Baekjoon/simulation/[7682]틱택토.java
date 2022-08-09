import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_7682_틱택토 {
    private static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if (str.equals("end")) break;

            map = new char[3][3];
            int idx = 0, xCnt = 0, oCnt = 0, empty = 0;
            for (int i=0;i<3;i++) {
                for (int j=0;j<3;j++) {
                    map[i][j] = str.charAt(idx);
                    idx++;

                    if (map[i][j] == 'X') xCnt++;
                    else if (map[i][j] == 'O') oCnt++;
                    else if (map[i][j] == '.') empty++;
                }
            }

            if (Math.abs(xCnt - oCnt) > 2 || oCnt > xCnt) {
                System.out.println("invalid");
                continue;
            }

            if (xCnt + oCnt == 9 && xCnt == oCnt+1) {
                if (isBingo('O') && !isBingo('X')) {
                    System.out.println("invalid");
                    continue;
                } else if (isBingo('O') && isBingo('X')) {
                    System.out.println("invalid");
                    continue;
                }
                System.out.println("valid");
                continue;
            } else {
                if (xCnt == oCnt+1) {
                    if (isBingo('X') && !isBingo('O')) {
                        System.out.println("valid");
                        continue;
                    } else {
                        System.out.println("invalid");
                        continue;
                    }
                } else if (xCnt == oCnt) {
                    if (isBingo('O') && !isBingo('X'))  {
                        System.out.println("valid");
                        continue;
                    } else {
                        System.out.println("invalid");
                        continue;
                    }
                }
            }
            System.out.println("invalid");
        }
    }

    private static boolean isBingo(char ch) {
        // 가로
        for (int i=0;i<3;i++) {
            if (map[i][0] == ch && map[i][1] == ch && map[i][2] == ch) {
                return true;
            }
        }
        // 세로
        for (int i=0;i<3;i++) {
            if (map[0][i] == ch && map[1][i] == ch && map[2][i] == ch) {
                return true;
            }
        }
        // 대각선
        if (map[0][0] == ch && map[1][1] == ch && map[2][2] == ch) return true;
        if (map[2][0] == ch && map[1][1] == ch && map[0][2] == ch) return true;

        return false;
    }
}
