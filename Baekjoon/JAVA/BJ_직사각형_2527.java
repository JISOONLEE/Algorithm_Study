package IM_BJ_DIFFICULTY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_직사각형_2527 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			String[] str = br.readLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
			int x3 = Integer.parseInt(str[4]);
			int y3 = Integer.parseInt(str[5]);
			int x4 = Integer.parseInt(str[6]);
			int y4 = Integer.parseInt(str[7]);

			if ((x1 == x4 && y1 == y4) || (x2 == x3 && y2 == y3) || (x1 == x4 && y2 == y3) || (x2 == x3 && y1 == y4))
				System.out.println('c');
			else if (x2 < x3 || y2 < y3 || x4 < x1 || y4 < y1)
				System.out.println('d');
			else if ((x2 == x3 && y2!=y3)|| (y1 == y4 && x2 != x3) || (y1 == y4 && x1!=x4)
					|| (x1 == x4 && y2 != y3))
				System.out.println('b');
			else
				System.out.println('a');
		}
	}

}
