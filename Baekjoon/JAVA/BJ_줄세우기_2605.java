package IM_BJ_DIFFICULTY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_줄세우기_2605 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int students = Integer.parseInt(br.readLine());
		String[] nums = br.readLine().split(" ");
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < students; i++) {
			int num = Integer.parseInt(nums[i]);
			if (list.isEmpty())
				list.add(i+1);
			else
				list.add(list.size()-num, i+1);
		}
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
	}

}
