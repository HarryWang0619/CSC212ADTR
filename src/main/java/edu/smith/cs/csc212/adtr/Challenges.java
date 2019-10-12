package edu.smith.cs.csc212.adtr;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class Challenges {

	// The union of two sets is the set of elements that either contains.
	public static SetADT<Integer> union(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();
		for (Integer l : left) {
			output.insert(l);
			for (Integer r : right) {
				if (!output.contains(r)) {
					output.insert(r);
				}
			}
		}
		return output;
	}
	
	// The intersection of two sets is the set of elements that both contain.
	public static SetADT<Integer> intersection(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();
		for (Integer l : left) {
			if (right.contains(l)) {
				output.insert(l);
			}
		}
		return output;
	}
	
	// Count the words in the input list and put them in the map.
	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();
		int k = 0;
		while (k < words.size()) {
			output.put(words.getIndex(k), (k+1));
			k += 1;
		}
		return output;
	}
}
