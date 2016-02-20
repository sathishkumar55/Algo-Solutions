import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Borrowers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String next = in.nextLine();
		SortedMap<String, List<String>> bookMap = new TreeMap<String, List<String>>();
		while (!next.equals("END")) {
			String[] split = next.split(" by ");
			if (bookMap.containsKey(split[1])) {
				List<String> oldList = bookMap.get(split[1]);
				oldList.add(split[0]);
				Collections.sort(oldList);
				bookMap.put(split[1], oldList);
			} else {
				List<String> newList = new ArrayList<String>();
				newList.add(split[0]);
				bookMap.put(split[1], newList);
			}
			next = in.nextLine();
		}
		Map<String, Integer> numMap = new HashMap<String, Integer>();
		Integer i = 0;
		for (List<String> l : bookMap.values()) {
			for (String s : l) {
				numMap.put(s, i++);
			}
		}
		Map<String, Integer> newMap = new HashMap<String, Integer>(numMap);
		SortedMap<Integer, String> tempMap = new TreeMap<Integer, String>();
		next = in.nextLine();
		while (!next.equals("END")) {
			if (next.startsWith("RETURN ")) {
				String substring = next.substring(7);
				tempMap.put(numMap.get(substring), substring);
			} else if (next.startsWith("BORROW ")) {
				newMap.remove(next.substring(7));
			} else {
				shelve(newMap, tempMap);
				tempMap = new TreeMap<Integer, String>();
			}
			next = in.nextLine();
		}
		in.close();

	}

	private static void shelve(Map<String, Integer> newMap,
			SortedMap<Integer, String> tempMap) {
		SortedMap<Integer, String> myMap = new TreeMap<Integer, String>();
		for (Entry<String, Integer> entry : newMap.entrySet()) {
			myMap.put(entry.getValue(), entry.getKey());
		}
		for (Entry<Integer, String> entry : tempMap.entrySet()) {
			SortedMap<Integer, String> headMap = myMap.headMap(entry.getKey());
			if (headMap.isEmpty()) {
				System.out.println("Put " + entry.getValue() + " first");
			} else {
				Integer lastKey = headMap.lastKey();
				System.out.println("Put " + entry.getValue() + " after "
						+ headMap.get(lastKey));
			}
			newMap.put(entry.getValue(), entry.getKey());
			myMap.put(entry.getKey(), entry.getValue());
		}
		System.out.println("END");
	}
}
