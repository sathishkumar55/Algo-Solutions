import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FalseCoin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String nextLine = in.nextLine();
		int m = Integer.parseInt(nextLine);
		for (int i = 0; i < m; i++) {
			in.nextLine();
			processInput(in);
			if (i != m - 1)
				System.out.println();
		}
		in.close();
	}

	private static void processInput(Scanner in) {
		String nextLine = in.nextLine();
		String[] split = nextLine.split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);
		processTestCase(n, k, in);
	}

	private static void processTestCase(int n, int k, Scanner in) {
		Map<Integer, Byte> myMap = new HashMap<Integer, Byte>();
		for (int i = 1; i <= n; i++) {
			myMap.put(i, null);
		}
		for (int i = 0; i < k; i++) {
			removeTrueCoins(myMap, in);
		}
		if (myMap.keySet().size() == 1) {
			System.out.println(myMap.keySet().iterator().next());
		} else {
			System.out.println(0);
		}
	}

	private static void removeTrueCoins(Map<Integer, Byte> myList, Scanner in) {
		String nextLine = in.nextLine();
		String[] split = nextLine.split(" ");
		int elementsInPan = Integer.parseInt(split[0]);
		List<Integer> tempList = new ArrayList<Integer>();
		for (int i = 1; i <= 2 * elementsInPan; i++) {
			tempList.add(Integer.parseInt(split[i]));
		}
		nextLine = in.nextLine();
		if (nextLine.equals("=")) {
			for (Integer i : tempList) {
				myList.remove(i);
			}
		} else {
			for (Integer i : tempList) {
				if (!myList.containsKey(i)) {
					myList.remove(i);
				}
			}
		}
	}
}
