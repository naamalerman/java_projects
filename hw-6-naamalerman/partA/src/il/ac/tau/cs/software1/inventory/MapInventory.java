package il.ac.tau.cs.software1.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapInventory implements Inventory{
	public HashMap<Float,List<Collectible>> map;
	
	public MapInventory() {
		map = new HashMap<Float,List<Collectible>>();
	}
	
	public void collect(Collectible collectible) {
		if (map.containsKey(collectible.getPrice())) {
			List<Collectible> collectiblePrice = map.get(collectible.getPrice());
			collectiblePrice.add(collectible);
		}
		else {
			List<Collectible> collectiblePrice = new ArrayList<>();
			collectiblePrice.add(collectible);
			map.put((Float) collectible.getPrice(), collectiblePrice);
		}
	}
	
	public float getTotalWeight() {
		float weightCount = 0;
		for (Float key : map.keySet()) {
			for (Collectible c: map.get(key)) {
				weightCount+=c.getWeight();
			}
		}
		return weightCount;
	}
	
	public int getCurrentCount() {
		int collectibleCounter = 0;
		for (Float key : map.keySet()) {
			collectibleCounter += map.get(key).size();
		}
		return collectibleCounter;
	}
	
	public MapInventoryIterator iterator(){
		return new MapInventoryIterator(map);
	}
}
