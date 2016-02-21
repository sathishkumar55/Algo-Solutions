import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PolePosition {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String nextLine = in.nextLine();
		int n = Integer.parseInt(nextLine);
		int i = 0;
		List<String> myList = new ArrayList<String>();
		while (!nextLine.equals("0")) {
			nextLine = in.nextLine();
			if (i == n) {
				process(n, myList);
				myList.clear();
				n = Integer.parseInt(nextLine);
				i = 0;
			} else {
				myList.add(nextLine);
				i++;
			}
		}
		in.close();
	}

	private static void process(int n, List<String> myList) {
		String[] myArr = new String[n];
		String[] split = new String[2];
		for (int i = 0; i < n; i++) {
			split = myList.get(i).split(" ");
			int pos = i + Integer.parseInt(split[1]);
			if (pos >= 0 && pos < n) {
				myArr[pos] = split[0];
			} else {
				System.out.println(-1);
				return;
			}
		}
		for (String s : myArr) {
			if (s == null) {
				System.out.println(-1);
				return;
			}
		}
		for (int i = 0; i < n - 1; i++) {
			System.out.print(myArr[i] + " ");
		}
		System.out.println(myArr[n - 1]);
	}
}
