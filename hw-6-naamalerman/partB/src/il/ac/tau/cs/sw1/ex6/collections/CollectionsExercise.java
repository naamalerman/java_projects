package il.ac.tau.cs.sw1.ex6.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsExercise {

	public static Map<Character, Map<String, Integer>> unionLists(List<Map<Character, Set<String>>> mapsList){
		Map<Character, Map<String, Integer>> unionDict = new HashMap<Character, Map<String, Integer>>();
		for (Map<Character, Set<String>> map: mapsList) {
			if (map!=null) {
				for (Character c: map.keySet()) {
					if (!unionDict.keySet().contains(c)) {
						unionDict.put(c, new HashMap<String, Integer>());
					}
					Map<String, Integer> currDict = unionDict.get(c);
					for (String str: map.get(c)) {
						int strInt = 1;
						if (currDict.keySet().contains(str)) {
							strInt += currDict.get(str);
						}
						currDict.put(str, strInt);
					}
				}
			}
		}
		return unionDict;
	}
	
	/* @pre: mapsList.size() > 0 */
	public static Map<Character, Integer> processDicts(List<Map<Character, Set<String>>> mapsList) {
		Map<Character, Map<String, Integer>> unionDict = unionLists(mapsList);
		
		Map<Character, Integer> process = new HashMap<Character, Integer>();
		
		for (Character c: unionDict.keySet()) {
			int cBiggestRepet = 0;
			Map<String, Integer> currCharDict = unionDict.get(c);
			for (String str: currCharDict.keySet()) {
				if (currCharDict.get(str)>cBiggestRepet) {
					cBiggestRepet = currCharDict.get(str);
				}
			}
			process.put(c, cBiggestRepet);
		}
		return process;
	}
	
	public static class modCosComparator implements Comparator<Integer>{
		public int p;
		
		public modCosComparator(int p) {
			this.p = p;
		}
		
		public int compare(Integer i1, Integer i2) {
			return Double.compare(Math.cos(i1%this.p), Math.cos(i2%this.p));
		}
	}
	
	/* @pre p is prime */
	public static List<Integer> weirdSort(List<Integer> lst, int p) {
		List<Integer> res = new ArrayList<>(lst);
		Comparator<Integer> copmare = new modCosComparator(p);
		Collections.sort(res, copmare);
		return res;
	}

}
