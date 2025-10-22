package il.ac.tau.cs.software1.inventory;

public class NaiveInventory implements Inventory{
	private final int INITIAL_CAPACITY = 100;
	Collectible[] Collectibles;
	int collectCount;
	
	public NaiveInventory() {
		Collectibles = new Collectible[INITIAL_CAPACITY];
		collectCount = 0;
	}
	
	public void collect(Collectible collectible) {
		if (this.Collectibles.length==this.collectCount) {
			Collectible[] tmp = new Collectible[2*this.collectCount];
			for (int i=0; i<this.collectCount; i++) {
				tmp[i] = this.Collectibles[i];
			}
			this.Collectibles = tmp;
		}
		this.Collectibles[this.collectCount] = collectible;
		this.collectCount++;
	}
	
	public float getTotalWeight() {
		float weightCount = 0;
		for (int i=0; i<this.collectCount; i++) {
			weightCount+=this.Collectibles[i].getWeight();
		}
		return weightCount;
	}
	
	
	public int getCurrentCount() {
		return this.collectCount;
	}
	
	public Collectible[] getCollArr() {
		return this.Collectibles;
	}

}
