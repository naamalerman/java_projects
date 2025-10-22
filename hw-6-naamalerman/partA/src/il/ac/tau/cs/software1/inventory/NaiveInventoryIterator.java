package il.ac.tau.cs.software1.inventory;

import java.util.Iterator;

public class NaiveInventoryIterator implements Iterator<Collectible>{
	
	public NaiveInventory naiveInventory;
	public int collectiveCounter;
	
	public NaiveInventoryIterator(NaiveInventory naive) {
		naiveInventory = naive;
		collectiveCounter = 0;
	}
	@Override
	public Collectible next() {
		return naiveInventory.getCollArr()[collectiveCounter++];
	}
	
	@Override
	public boolean hasNext() {
		if (naiveInventory.getCurrentCount() <= collectiveCounter){
			return false;
		}
		return true;
	}

}
