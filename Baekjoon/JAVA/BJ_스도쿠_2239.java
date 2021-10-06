import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_스도쿠_2239 {
	static int[][] sudoku;
	static ArrayList<Point> zeroList;

	private static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sudoku = new int[9][9];
		zeroList = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			String st = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = st.charAt(j) - '0';
				if (sudoku[i][j] == 0)
					zeroList.add(new Point(i, j));
			}
		}
		solve(0);
	}

	private static void solve(int idx) {
		if(idx == zeroList.size()) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(sudoku[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		Point p = zeroList.get(idx);
		boolean[] check = new boolean[10];
		for (int j = 0; j < 9; j++) {
			if (sudoku[p.x][j] != 0) // 가로
				check[sudoku[p.x][j]] = true;
			if (sudoku[j][p.y] != 0) // 세로
				check[sudoku[j][p.y]] = true;
		}

		int nx = (p.x) / 3 * 3;
		int ny = (p.y) / 3 * 3;
		for (int r = nx; r < nx + 3; r++) {
			for (int c = ny; c < ny + 3; c++) {
				if (sudoku[r][c] != 0)
					check[sudoku[r][c]] = true;
			}
		}

		for(int i=1;i<=9;i++) {
			if(!check[i]) {
				sudoku[p.x][p.y] = i;
				solve(idx+1);
				sudoku[p.x][p.y] = 0;
			}
		}
	}
}
