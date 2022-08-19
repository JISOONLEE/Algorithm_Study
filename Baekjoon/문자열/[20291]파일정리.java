package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class BJ_20291_파일정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<N;i++) {
            String extension = br.readLine().split("\\.")[1];
            if (map.containsKey(extension)) {
                map.put(extension, map.get(extension)+1);
            } else {
                map.put(extension, 1);
                list.add(extension);
            }
        }

        Collections.sort(list);

        for (String key : list) {
            System.out.println(key+" "+map.get(key));
        }
    }
}
