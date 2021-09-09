import java.util.*;
import java.lang.*;
class Solution {
    int map[][];
    int copyMap[][];
    int keylen;
    int locklen;
    public boolean solution(int[][] key, int[][] lock) {
        int len = lock.length+((key.length)-1)*2;
        System.out.println(len);
        map = new int[len][len];
        keylen = key.length;
        locklen = lock.length;
        for(int i=0;i<lock.length;i++) {
            for(int j=0;j<lock[i].length;j++) {
                map[i+key.length-1][j+key.length-1] = lock[i][j];
            }
        }
        int[][] keycopy = new int[key.length][key.length];
        for(int i=0;i<key.length;i++)
            keycopy[i] = key[i].clone();

        for(int i=0;i<4;i++) {
            int[][] temp = new int[key.length][key.length];
            for(int j=0;j<key.length;j++) {
                for(int k=0;k<key[j].length;k++) {
                    temp[k][(key.length-1)-j] = keycopy[j][k];
                }
            }
            for(int j=0;j<len-key.length+1;j++) {
                for(int k=0;k<len-key.length+1;k++) {
                    copyMap = new int[len][len];
                    copy();
                    for(int m=0;m<key.length;m++) {
                        for(int n=0;n<key.length;n++) {
                            copyMap[j+m][k+n] += temp[m][n];
                        }
                    }
                    if(check())
                        return true;
                }
            }
            for(int j=0;j<key.length;j++)
                keycopy[j] = temp[j].clone();
        }
        return false;
    }
    private boolean check() {
        boolean keycheck = true;
        for(int i=0;i<locklen;i++) {
            for(int j=0;j<locklen;j++) {
                if(copyMap[i+keylen-1][j+keylen-1] != 1)
                    keycheck = false;
            }
        }
        return keycheck;
    }
    private void copy() {
        for(int i=0;i<map.length;i++) {
            copyMap[i] = map[i].clone();
        }
    }
}
