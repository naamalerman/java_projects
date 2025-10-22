package il.ac.tau.cs.software1.inventory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MapInventoryIterator implements Iterator<Collectible>{
	public HashMap<Float,List<Collectible>> map;
	private Iterator<Float> outterIterator;
	private Iterator<Collectible> innerIterator;
	
	public MapInventoryIterator(HashMap<Float,List<Collectible>> mapInventory) {
		map = mapInventory;
		outterIterator = map.keySet().iterator();
	}
	
	public Collectible next() {
		return innerIterator.next();	
	}
	
	public boolean hasNext() {
		if (innerIterator != null && innerIterator.hasNext()) {
            return true;
        }
		
		while (outterIterator.hasNext()) {
			List<Collectible> currPrice = map.get(outterIterator.next());
			if (currPrice.iterator().hasNext()) {
				innerIterator = currPrice.iterator();
				return true;
			}
		}
		return false;
	}
}