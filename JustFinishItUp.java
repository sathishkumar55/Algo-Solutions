import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JustFinishItUp {

	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				int[] petrolValArr = new int[n];
				String nextLine = br.readLine();
				String[] split = nextLine.split(" ");
				List<String> tempList = new ArrayList<String>();
				for (String s : split) {
					tempList.add(s);
				}
				while (tempList.size() != 2 * n) {
					nextLine = br.readLine();
					String[] split2 = nextLine.split(" ");
					for (String s : split2) {
						tempList.add(s);
					}
				}
				int total = 0;
				int x = 100002;
				for (int q = 0; q < n; q++) {
					petrolValArr[q] = Integer.parseInt(tempList.get(q))
							- Integer.parseInt(tempList.get(n + q));
					if (q < x && petrolValArr[q] > 0) {
						x = q;
					}
					total += petrolValArr[q];
				}
				if (total < 0) {
					System.out.println("Case " + (i + 1) + ": Not possible");
				} else {
					System.out.println("Case " + (i + 1)
							+ ": Possible from station "
							+ (getPossibilityPosition(petrolValArr, x) + 1));
				}

			}
			br.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int getPossibilityPosition(int[] petrolValArr, int x) {
		int availability = 0;
		for (int i = x; i < petrolValArr.length; i++) {
			availability += petrolValArr[i];
			if (availability < 0) {
				for (int y = x + 1; y < petrolValArr.length; y++) {
					if (petrolValArr[y] > 0) {
						return getPossibilityPosition(petrolValArr, y);
					}
				}
				break;
			}
		}
		for (int i = 0; i < x; i++) {
			availability += petrolValArr[i];
			if (availability < 0) {
				for (int y = x + 1; y < petrolValArr.length; y++) {
					if (petrolValArr[y] > 0) {
						return getPossibilityPosition(petrolValArr, y);
					}
				}
				break;
			}

		}
		return x;
	}
}
