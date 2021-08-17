import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JO_냉장고_1828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<>();
		for (int n = 0; n < N; n++) {
			String[] str = br.readLine().split(" ");
			list.add(new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
		}

		Collections.sort(list);

		int result = 1;
		int max = list.get(0).maxTemp;

		for (int i = 0; i < list.size() - 1; i++) {
			if (max < list.get(i + 1).minTemp) {
				max = list.get(i + 1).maxTemp;
				result++;
			}
		}
		System.out.println(result);
	}

	public static class Point implements Comparable<Point> {
		int minTemp;
		int maxTemp;

		Point(int minTemp, int maxTemp) {
			this.minTemp = minTemp;
			this.maxTemp = maxTemp;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.maxTemp - o.maxTemp;
		}
	}
}
